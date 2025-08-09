package com.example.smart.controller;

import com.example.smart.model.Task;
import com.example.smart.model.User;
import com.example.smart.repository.TaskRepository;
import com.example.smart.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskRepository taskRepo;
    private final UserRepository userRepo;
    public TaskController(TaskRepository t, UserRepository u){ this.taskRepo = t; this.userRepo = u; }

    @GetMapping
    public List<Task> list(){ return taskRepo.findAll(); }

    @PostMapping
    public Task create(@RequestBody Map<String,Object> body){
        Task t = new Task();
        t.setTitle((String)body.get("title"));
        t.setDescription((String)body.get("description"));
        t.setPriority((String)body.get("priority"));
        t.setStatus((String)body.getOrDefault("status","TODO"));
        Object ass = body.get("assigneeIds");
        if(ass instanceof List){
            List<?> ids = (List<?>)ass;
            Set<User> users = new HashSet<>();
            for(Object o: ids){
                Number n = (Number)o;
                userRepo.findById(n.longValue()).ifPresent(users::add);
            }
            t.setAssignees(users);
        }
        taskRepo.save(t);
        return t;
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id, @RequestBody Map<String,Object> body){
        Optional<Task> ot = taskRepo.findById(id);
        if(ot.isEmpty()) return Map.of("error","not found");
        Task t = ot.get();
        if(body.containsKey("status")) t.setStatus((String)body.get("status"));
        taskRepo.save(t);
        return t;
    }
}
