package operations;

import java.util.ArrayList;

import model.Students;

public class Update {
    private ArrayList<Students> students;

    public Update(ArrayList<Students> students) {
        this.students = students;
    }

    public void UpdateStudent(Students updatedStudent) {
        for (Students student : students) {
            if (student.getId().equals(updatedStudent.getId())) {
            	student.setName(updatedStudent.getName());
            	student.setBirthDate(updatedStudent.getBirthDate());
            	student.setAge(updatedStudent.getAge());
            	student.setGender(updatedStudent.getGender());
            	student.setCourse(updatedStudent.getCourse());
                System.out.println("✅ Student updated successfully!");
                return;
            }
        }
        System.out.println("❌ Student ID not found!");
    }
}
