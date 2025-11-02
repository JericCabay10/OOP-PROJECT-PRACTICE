package operations;

import java.util.ArrayList;

import model.Students;

public class View {
    private ArrayList<Students> students;

    public View(ArrayList<Students> students) {
        this.students = students;
    }

    public void ViewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No Student Registered!");
        } else {
            for (Students student : students) {
                student.DisplayInfo();
            }
        }
    }
}
