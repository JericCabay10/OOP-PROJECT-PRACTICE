import java.util.ArrayList;

public class Controller {
    ArrayList<Student> students = new ArrayList<>();

    void AddStudent(Student student) {
        students.add(student);
        System.out.println("Student successfully added");
    }

     void ViewAllStudents() {
        if(students.isEmpty()) {
            System.out.println("No Student Register!");
        }else {
            for(Student student : students){
                student.DisplayInfo();
            }
        }
    }

    void UpdateStudent(Student updatedStudent) {
        for (Student student : students) {
            if (student.getStudentId() == updatedStudent.getStudentId()) {
                student.setFullName(updatedStudent.getFullName());
                student.setBirthDate(updatedStudent.getBirthDate());
                student.setGender(updatedStudent.getGender());
                student.setCourse(updatedStudent.getCourse());
                System.out.println("✅ Student updated successfully!");
                return;
            }
        }
        System.out.println("❌ Student ID not found!");
    }

    void DeleteStudent(int studentId) {
        boolean isFound = false;

        for(Student s : students) {
            if(s.getStudentId() == studentId) {
                isFound = true;
                students.remove(s);
                System.out.println("Student successfully Deleted!");
                break;
            }
        }

        if(!isFound) {
            System.out.println("Student not found!\n");
        }
    }

    Student FindById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student; // ✅ Found the student
            }
        }
        return null; // ❌ Not found, return null
    }
}
