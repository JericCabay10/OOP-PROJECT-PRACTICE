package controller;
import java.util.ArrayList;

import operations.*;

import model.Students;


public class StudentController {
    ArrayList<Students> students = new ArrayList<>();
    
    Add add = new Add(students);
    View view = new View(students);
    Update update = new Update(students);
    Remove remove = new Remove(students);
    FindById finder = new FindById(students);

    public void AddStudent(Students s) { 
    	add.AddStudent(s); 
    }
    
    public void ViewAllStudents() { 
    	view.ViewAllStudents(); 
    }
    
    public void UpdateStudent(String id, String name, int birth, int age, String gender, String course) {
        Students updated = new Students(id, name, birth, age, gender, course);
        update.UpdateStudent(updated);
    }
    
    public void DeleteStudent(String id) { 
    	remove.DeleteStudent(id); 
    }

    public Students FindById(String studentId) { 
        return finder.FindById(studentId);
    }
}
