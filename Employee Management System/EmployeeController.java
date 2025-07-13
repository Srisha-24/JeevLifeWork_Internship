
package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController 
{
    private List<Employee> employees = new ArrayList<>();

    @GetMapping
    public List<Employee> getAll() 
    {
        return employees;
    }

    @PostMapping
    public String addEmployee(@RequestBody Employee emp)
     {
        employees.add(emp);
        return "Employee added";
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) 
    {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee updated) 
    {
        for (Employee e : employees) 
        {
            if (e.getId() == id) 
            {
                e.setName(updated.getName());
                e.setDepartment(updated.getDepartment());
                e.setPosition(updated.getPosition());
                e.setSalary(updated.getSalary());
                return "Updated";
            }
        }
        return "Not found";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) 
    {
        employees.removeIf(e -> e.getId() == id);
        return "Deleted";
    }
}
