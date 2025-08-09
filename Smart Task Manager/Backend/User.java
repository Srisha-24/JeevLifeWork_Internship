package com.example.smart.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique=true)
    private String email;
    private String password;
    private boolean enabled = true; // dev mode true
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
