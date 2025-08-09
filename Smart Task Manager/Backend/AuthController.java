package com.example.smart.controller;

import com.example.smart.model.User;
import com.example.smart.repository.UserRepository;
import com.example.smart.repository.RoleRepository;
import com.example.smart.security.JwtUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Set;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final JwtUtils jwtUtils;
    public AuthController(UserRepository u, RoleRepository r, JwtUtils j){ this.userRepo = u; this.roleRepo = r; this.jwtUtils = j; }

    @PostMapping("/register")
    public Map<String,String> register(@RequestBody Map<String,String> body){
        String email = body.get("email");
        if(userRepo.findByEmail(email).isPresent()) return Map.of("error","User exists");
        User u = new User();
        u.setName(body.getOrDefault("name","User"));
        u.setEmail(email);
        u.setPassword(new BCryptPasswordEncoder().encode(body.get("password")));
        u.setRoles(Set.of(roleRepo.findByName("ROLE_EMPLOYEE").orElseThrow()));
        userRepo.save(u);
        return Map.of("message","registered - verify by admin (dev mode) or use login");
    }

    @PostMapping("/login")
    public Object login(@RequestBody Map<String,String> body){
        var opt = userRepo.findByEmail(body.get("email"));
        if(opt.isEmpty()) return Map.of("error","Invalid");
        User u = opt.get();
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        if(!enc.matches(body.get("password"), u.getPassword())) return Map.of("error","Invalid");
        String token = jwtUtils.generateToken(u.getEmail());
        return Map.of("token", "Bearer "+token);
    }
}
