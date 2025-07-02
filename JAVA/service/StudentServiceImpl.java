package service;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import exception.StudentNotFoundException;
import model.Student;
import util.Validator;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDAO dao = new StudentDAOImpl();

    public Student getStudent(int id) {
        return dao.getById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public List<Student> getAllStudents() {
        return dao.getAll();
    }

    public void createStudent(Student student) {
        if (!Validator.isValid(student)) throw new IllegalArgumentException("Invalid student");
        dao.insert(student);
    }

    public void updateStudent(Student student) {
        if (!Validator.isValid(student)) throw new IllegalArgumentException("Invalid student");
        dao.update(student);
    }

    public void deleteStudent(int id) {
        dao.delete(id);
    }
}
