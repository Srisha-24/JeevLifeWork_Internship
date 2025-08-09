package com.example.smart;

import com.example.smart.model.Role;
import com.example.smart.model.User;
import com.example.smart.repository.RoleRepository;
import com.example.smart.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Set;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Component
public class DataLoader implements CommandLineRunner {
    private final RoleRepository roleRepo;
    private final UserRepository userRepo;
    public DataLoader(RoleRepository roleRepo, UserRepository userRepo){
        this.roleRepo = roleRepo; this.userRepo = userRepo;
    }
    @Override
    public void run(String... args) throws Exception {
        if(roleRepo.findByName("ROLE_ADMIN").isEmpty()){
            roleRepo.save(new Role("ROLE_ADMIN"));
            roleRepo.save(new Role("ROLE_MANAGER"));
            roleRepo.save(new Role("ROLE_EMPLOYEE"));
        }
        if(userRepo.findByEmail("admin@example.com").isEmpty()){
            User u = new User();
            u.setName("Admin");
            u.setEmail("admin@example.com");
            u.setPassword(new BCryptPasswordEncoder().encode("Admin123"));
            u.setRoles(Set.of(roleRepo.findByName("ROLE_ADMIN").get()));
            userRepo.save(u);
            System.out.println("Created admin user: admin@example.com / Admin123");
        }
    }
}
