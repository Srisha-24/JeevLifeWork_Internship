import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable, Comparable<Student> {
    private int id;
    private String name;
    private int age;
    private String grade;
    private String address;

    public Student(int id, String name, int age, String grade, String address) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.age = age;
        this.grade = Objects.requireNonNull(grade, "Grade cannot be null");
        this.address = Objects.requireNonNull(address, "Address cannot be null");
    }

    // Getters & Setters...
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
    }
    public int getAge() { return age; }
    public void setAge(int age) {
        if (age <= 0) throw new IllegalArgumentException("Age must be positive.");
        this.age = age;
    }
    public String getGrade() { return grade; }
    public void setGrade(String grade) {
        this.grade = Objects.requireNonNull(grade, "Grade cannot be null");
    }
    public String getAddress() { return address; }
    public void setAddress(String address) {
        this.address = Objects.requireNonNull(address, "Address cannot be null");
    }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', age=%d, grade='%s', address='%s'}",
                             id, name, age, grade, address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student other = (Student) o;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
        // Or sort by name: this.name.compareToIgnoreCase(other.name);
    }
}
