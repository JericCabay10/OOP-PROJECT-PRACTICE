package studentmanagementystem;

import java.util.ArrayList;

public class StudentManagement {
	ArrayList<Student> students = new ArrayList<>();
	private int count = 0;
	
	public void addStudent(Student s) {
		if(s.getId() == null) {
			System.out.println("Invalid format can't register");
		}else {
			count++;
			students.add(s);
			s.setStudentNumber(count);
			System.out.println("Student Register successfully!");
		}
	}

	
	public void viewStudent() {
		if(students.isEmpty()) {
			System.out.println("No student available.");
		}else {
			System.out.println("Register student: " +students.size());
			
			for(Student s : students) {
				s.studentInfo();
			}
		}
	}
	
	public void updateStudent(String id, String newName, int age, String grade) {
		boolean isFound = false;
		for(Student s : students) {
			if(s.getId().equalsIgnoreCase(id)) {
				s.setName(newName);
				s.setAge(age);
				s.setGrade(grade);
				System.out.println("Student Update successfully");
				isFound = true;
				break;
			}
		}
		
		if(!isFound) {
			System.out.println("Id is not register or wrong id input.");
		}
	}
	
	public void removeStudent(String id) {
		boolean isFound = false;
		for(Student s : students) {
			if(s.getId().equalsIgnoreCase(id)) {
				count--;
				students.remove(s);
				System.out.println("Student successfully remove.");
				isFound = true;
				break;
			}
		}
		
		if(!isFound) {
			System.out.println("The Student id is not register or wrong input");
		}
	}
	
	public Student findStudentById(String id) {
		for(Student s : students) {
			if(s.getId().equalsIgnoreCase(id)) {
				return s;
			}
		}
		return null;
	}
}
