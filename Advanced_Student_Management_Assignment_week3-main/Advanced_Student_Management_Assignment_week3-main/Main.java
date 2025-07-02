import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final String DATA_FILE = "students.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager mgr = new StudentManager();
        try {
            mgr.loadFromFile(DATA_FILE);3
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Warning: Could not load data (" + e.getMessage() + ")");
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n---- Student Management ----");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit & Save");
            System.out.print("Choose (1‑6): ");

            int choice = -1;
            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline
            } catch (InputMismatchException ime) {
                sc.nextLine();
                System.out.println("Please enter a number between 1 and 6.");
                continue;
            }

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Name: "); String name = sc.nextLine();
                        System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
                        System.out.print("Grade: "); String grade = sc.nextLine();
                        System.out.print("Address: "); String address = sc.nextLine();
                        mgr.addStudent(new Student(id, name, age, grade, address));
                        System.out.println("Student added.");
                    }
                    case 2 -> {
                        System.out.print("Enter ID to remove: "); int id = sc.nextInt(); sc.nextLine();
                        mgr.removeStudent(id);
                        System.out.println("Student removed.");
                    }
                    case 3 -> {
                        System.out.print("Enter ID to update: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Name: "); String name = sc.nextLine();
                        System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
                        System.out.print("Grade: "); String grade = sc.nextLine();
                        System.out.print("Address: "); String address = sc.nextLine();
                        mgr.updateStudent(id, name, age, grade, address);
                        System.out.println("Student updated.");
                    }
                    case 4 -> {
                        System.out.print("Enter ID to search: "); int id = sc.nextInt(); sc.nextLine();
                        Student s = mgr.searchStudent(id);
                        System.out.println(s != null ? s : "No student found.");
                    }
                    case 5 -> mgr.displayAllStudents();
                    case 6 -> {
                        mgr.saveToFile(DATA_FILE);
                        System.out.println("Data saved. Exiting.");
                        exit = true;
                    }
                    default -> System.out.println("Enter a number 1‑6 only.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
