package operations;

import java.util.ArrayList;
import model.Students;

public class Add {
    private ArrayList<Students> students;

    public Add(ArrayList<Students> students) {
        this.students = students;
    }

    public void AddStudent(Students student) {
        students.add(student);
        System.out.println("✅ Student successfully added!");
    }
}