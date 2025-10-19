import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Controller controller = new Controller();

        int choice;
        int studentId, birthDate;
        String fullName, gender = "", course = "";

        do {
            System.out.println("==== Student Management System ====");
            System.out.println("1. Add student");
            System.out.println("2. View all students");
            System.out.println("3. Update Student");
            System.out.println("4. Remove student");

            System.out.print("Choice a function: ");
            choice = input.nextInt();

            switch(choice) {
                case 0:
                    System.out.println("Exit System...");
                    break;
                case 1:
                    System.out.println("\n==== Register Students ====");
                    System.out.print("Enter Student Id: ");
                    studentId = input.nextInt();

                    System.out.print("Full Name: ");
                    fullName = input.nextLine();
                    input.nextLine();

                    System.out.print("Birth Date: ");
                    birthDate = input.nextInt();

                    System.out.print("Gender: ");
                    gender = input.nextLine();
                    input.nextLine();

                    System.out.print("Course: ");
                    course = input.nextLine();

                    controller.AddStudent(new Student(studentId, fullName, birthDate, gender, course));
                    break;
                case 2:
                    System.out.println("\n==== Student List ====");
                    controller.ViewAllStudents();
                    break;
                case 3:
                    System.out.println("\n==== Update Student Info ====");
                    System.out.print("Student Id: ");
                    studentId = input.nextInt();

                    Student isFound = controller.FindById(studentId);

                    if(isFound == null) {
                        System.out.println("No Student register.");
                    }else {
                        System.out.println("0. Exit            1. Update All");
                        System.out.println("2. Update name     3. Update gender");
                        System.out.println("4. Update course");

                        System.out.println("Choose an update function: ");
                        choice = input.nextInt();

                        if (choice == 1) {
                            Student updatedStudent = UpdateController.UpdateAll(studentId);
                            controller.UpdateStudent(updatedStudent);
                        }else {
                            System.out.println("Function 1 is only working.");
                            System.out.println("The other function is coming soon! ");
                        }
                    }

                    break;
                case 4:
                    System.out.println("\n==== Remove Student ====");
                    System.out.print("Student Id: ");
                    studentId = input.nextInt();

                    controller.DeleteStudent(studentId);
                    break;

            }

        }while(choice != 0);
    }
}