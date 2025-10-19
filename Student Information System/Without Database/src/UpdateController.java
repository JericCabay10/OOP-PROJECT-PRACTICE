import java.util.*;

public class UpdateController {
    static Scanner input = new Scanner(System.in);

    public static Student UpdateAll(int studentId) {
        System.out.print("Full Name: ");
        String fullName = input.nextLine();

        System.out.print("Birth Date (year only): ");
        int birthDate = input.nextInt();
        input.nextLine(); // consume leftover newline

        System.out.print("Gender: ");
        String gender = input.nextLine();

        System.out.print("Course: ");
        String course = input.nextLine();

        return new Student(studentId, fullName, birthDate, gender, course);
    }
}
