package com.example.studentcrud.service;

import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.StudentRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private StudentServiceImpl service;

    private Student student;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        student = new Student(1L, "John", 20, "A+", "NY");
    }

    @Test
    void testAddStudent() {
        when(repository.save(any())).thenReturn(student);
        assertEquals("John", service.addStudent(student).getName());
    }
}
