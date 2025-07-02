import java.io.*;
import java.util.*;

public class StudentManager {
    private List<Student> students = new ArrayList<>();
    private Map<Integer, Student> studentMap = new HashMap<>();
    private Set<Student> sortedStudents = new TreeSet<>();

    public void addStudent(Student s) {
        if (studentMap.containsKey(s.getId())) {
            throw new IllegalArgumentException("ID already exists: " + s.getId());
        }
        students.add(s);
        studentMap.put(s.getId(), s);
        sortedStudents.add(s);
    }

    public void removeStudent(int id) {
        Student s = studentMap.remove(id);
        if (s == null) {
            throw new NoSuchElementException("No student with ID: " + id);
        }
        students.remove(s);
        sortedStudents.remove(s);
    }

    public void updateStudent(int id, String name, int age, String grade, String address) {
        Student s = searchStudent(id);
        if (s == null) throw new NoSuchElementException("No student with ID: " + id);

        sortedStudents.remove(s);
        s.setName(name);
        s.setAge(age);
        s.setGrade(grade);
        s.setAddress(address);
        sortedStudents.add(s);
    }

    public Student searchStudent(int id) {
        return studentMap.get(id);
    }

    public void displayAllStudents() {
        if (sortedStudents.isEmpty()) {
            System.out.println("No students available.");
        } else {
            sortedStudents.forEach(System.out::println);
        }
    }

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        File file = new File(filename);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                @SuppressWarnings("unchecked")
                List<Student> loaded = (List<Student>) obj;
                students.clear();
                studentMap.clear();
                sortedStudents.clear();

                for (Student s : loaded) {
                    students.add(s);
                    studentMap.put(s.getId(), s);
                    sortedStudents.add(s);
                }
            }
        }
    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(new ArrayList<>(students));
        }
    }
}
