package ui;

import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

import java.util.Scanner;

public class ConsoleUI {
    private final StudentService service = new StudentServiceImpl();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("1. Add 2. Get 3. List 4. Update 5. Delete 6. Exit");
            switch (scanner.nextInt()) {
                case 1 -> add();
                case 2 -> get();
                case 3 -> list();
                case 4 -> update();
                case 5 -> delete();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid");
            }
        }
    }

    private void add() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Email: ");
        String email = scanner.next();
        service.createStudent(new Student(0, name, age, email));
    }

    private void get() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.println(service.getStudent(id));
    }

    private void list() {
        service.getAllStudents().forEach(System.out::println);
    }

    private void update() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Email: ");
        String email = scanner.next();
        service.updateStudent(new Student(id, name, age, email));
    }

    private void delete() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        service.deleteStudent(id);
    }
}
