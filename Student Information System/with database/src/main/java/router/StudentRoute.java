package router;

import controller.Add;
import controller.View;
import controller.Update;
import controller.Remove;
import model.Students;

public class StudentRoute {
    Add add = new Add();
    View view = new View();
    Update update = new Update();
    Remove remove = new Remove();

    public void addStudent(Students s) {
        add.addStudent(s);
    }

    public void viewStudent() {
        view.viewStudent();
    }

    public void updateStudent(String id, String name, int birthDate, int age, String gender, String course) {
        update.updateStudent(id, name, birthDate, age, gender, course);
    }

    public void removeStudent(String id) {
        remove.removeStudent(id);
    }
}
