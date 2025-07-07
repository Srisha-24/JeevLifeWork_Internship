package com.example.studentcrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Min(value = 1, message = "Age must be positive")
    private int age;

    @Pattern(regexp = "^(A\\+|A|B\\+|B|C\\+|C|D|F)$", message = "Invalid grade format")
    private String grade;

    private String address;
}