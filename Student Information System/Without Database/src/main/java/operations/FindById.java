package operations;

import java.util.ArrayList;
import model.Students;

public class FindById {
    private ArrayList<Students> students;

    public FindById(ArrayList<Students> students) {
        this.students = students;
    }

    public Students FindById(String studentId) {
        for (Students student : students) {
            if (student.getId().equals(studentId)) { // ✅ use .equals() for string comparison
                return student;
            }
        }
        return null; // ❌ not found
    }
}
