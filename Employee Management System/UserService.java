
package com.example.userservice.service;

import com.example.userservice.model.User;
import com.example.userservice.model.AuthRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService 
{
    public ResponseEntity<?> registerUser(User user) 
    {
        return ResponseEntity.ok("User registered: " + user.getUsername());
    }

    public ResponseEntity<?> login(AuthRequest request) 
    {
        return ResponseEntity.ok("Logged in with: " + request.getUsername());
    }

    public User getUserByUsername(String username) 
    {
        User user = new User();
        user.setUsername(username);
        user.setEmail(username + "@example.com");
        return user;
    }
}
