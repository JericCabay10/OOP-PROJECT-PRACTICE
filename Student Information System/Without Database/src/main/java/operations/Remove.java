package operations;

import java.util.ArrayList;

import model.Students;

public class Remove {
    private ArrayList<Students> students;

    public Remove(ArrayList<Students> students) {
        this.students = students;
    }

    public void DeleteStudent(String id) {
        boolean isFound = false;

        for (Students s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("🗑️ Student successfully deleted!");
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.out.println("❌ Student not found!");
        }
    }
}
