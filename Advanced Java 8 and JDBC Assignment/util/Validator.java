package util;

import model.Student;

public class Validator {
    public static boolean isValid(Student s) {
        return s.getAge() > 0 && s.getEmail().contains("@");
    }
}
