import java.util.Scanner;

import model.Students;

import controller.StudentController;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentController controller = new StudentController();

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
                    System.out.print("Id: ");
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
                    controller.AddStudent(s);
                    break;

                case 2:
                    System.out.println("\n=== VIEW STUDENTS ===");
                    controller.ViewAllStudents();
                    break;

                case 3:
                    System.out.println("\n=== UPDATE STUDENT ===");
                    
                    Students existingStudent = null;
                    String updateId;

                    // 🔁 Keep asking until a valid ID is found
                    do {
                        System.out.print("Enter Student ID: ");
                        updateId = input.nextLine();

                        existingStudent = controller.FindById(updateId);

                        if (existingStudent == null) {
                            System.out.println("❌ Student ID not found! Please try again.\n");
                        }

                    } while (existingStudent == null);

                    // ✅ Once found, proceed with updates
                    System.out.print("Full Name: ");
                    String newName = input.nextLine();

                    System.out.print("Birth Year: ");
                    int newBirth = input.nextInt();

                    System.out.print("Age: ");
                    int newAge = input.nextInt();
                    input.nextLine();

                    System.out.print("Gender: ");
                    String newGender = input.nextLine();

                    System.out.print("Course: ");
                    String newCourse = input.nextLine();

                    controller.UpdateStudent(updateId, newName, newBirth, newAge, newGender, newCourse);
                    break;

                case 4:
                    System.out.println("\n=== REMOVE STUDENT ===");
                    System.out.print("Enter ID to Remove: ");
                    String removeId = input.nextLine();
                    controller.DeleteStudent(removeId);
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
