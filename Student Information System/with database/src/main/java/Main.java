import java.util.Scanner;

import model.Students;
import router.StudentRoute;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentRoute route = new StudentRoute();

        while (true) {
            System.out.println("========== STUDENT MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n=== ADD STUDENT ===");
                    System.out.print("new Id: ");
                    String id = input.nextLine();

                    System.out.print("Full Name: ");
                    String name = input.nextLine();

                    System.out.print("Birth Year: ");
                    int birthYear = input.nextInt();

                    System.out.print("Age: ");
                    int age = input.nextInt();
                    input.nextLine();

                    System.out.print("Gender: ");
                    String gender = input.nextLine();

                    System.out.print("Course: ");
                    String course = input.nextLine();

                    Students s = new Students(id, name, birthYear, age, gender, course);
                    route.addStudent(s);
                    break;

                case 2:
                    System.out.println("\n=== VIEW STUDENTS ===");
                    route.viewStudent();
                    break;

                case 3:
                    System.out.println("\n=== UPDATE STUDENT ===");
                    System.out.print("Enter ID of Student to Update: ");
                    String updateId = input.nextLine();

                    System.out.print("Update Full Name: ");
                    String newName = input.nextLine();

                    System.out.print("Update Birth Year: ");
                    int newBirth = input.nextInt();

                    System.out.print("Update Age: ");
                    int newAge = input.nextInt();
                    input.nextLine();

                    System.out.print("Update Gender: ");
                    String newGender = input.nextLine();

                    System.out.print("Update Course: ");
                    String newCourse = input.nextLine();

                    route.updateStudent(updateId, newName, newBirth, newAge, newGender, newCourse);
                    break;

                case 4:
                    System.out.println("\n=== REMOVE STUDENT ===");
                    System.out.print("Enter ID to Remove: ");
                    String removeId = input.nextLine();
                    route.removeStudent(removeId);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    input.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }
        }
    }
}
