package service;

import model.Student;
import java.util.List;

public interface StudentService {
    Student getStudent(int id);
    List<Student> getAllStudents();
    void createStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);
}