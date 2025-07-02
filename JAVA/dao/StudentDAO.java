package dao;

import model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentDAO {
    Optional<Student> getById(int id);
    List<Student> getAll();
    void insert(Student student);
    void update(Student student);
    void delete(int id);
}