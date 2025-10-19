package studentmanagementystem;

import java.util.*;
import java.sql.Connection;

import connection.Connections; //Class name


public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentManagement manage = new StudentManagement();
		Connection conn =  Connections.getConnection();
		
		String id = "";
		String name = "";
		int age = 0;
		String grade = "";
		
		int choice = 0;
		
		if(conn != null) {
			System.out.println("Database connected successfully!");
		}else {
			System.out.println("Invalid");
		}
		
		
		do {
			System.out.println("==== STUDENT MANAGEMENT SYSTEM ====");
			System.out.println("0. Exit System or Function");
			System.out.println("1. Register Student.");
			System.out.println("2. View Student Lists.");
			System.out.println("3. Update Student Info.");
			System.out.println("4. Delete Student Info.");
			
			System.out.print("Choose a function: ");
			choice = scan.nextInt();
			scan.nextLine();
			
			switch(choice) {
			case 0:
				System.out.println("System Exit...");
				break;
			case 1:
				System.out.println("\n==== Register Student ====");
				System.out.print("Id: ");
				id = scan.nextLine();
				System.out.print("Name: ");
				name = scan.nextLine();
				System.out.print("Age: ");
				age = scan.nextInt();
				scan.nextLine();
				System.out.print("Grade: ");
				grade = scan.nextLine();
				
				Student student = new Student(id, name, age, grade);
				manage.addStudent(student);
				System.out.println("=============================");
				System.out.println("");
				break;
			case 2:
				System.out.println("\n==== View List Students Registered ====");
				manage.viewStudent();
				System.out.println("============================");
				System.out.println("");
				break;
			case 3:
				System.out.println("\n==== Update Student ====");
				System.out.print("Id: ");
				id = scan.nextLine();
				System.out.print("Name: ");
				name = scan.nextLine();
				System.out.print("Age: ");
				age = scan.nextInt();
				scan.nextLine();
				System.out.print("Grade: ");
				grade = scan.nextLine();
				
				manage.updateStudent(id, name, age, grade);
				manage.viewStudent();
				System.out.println("=============================");
				System.out.println("");
				break;
			case 4:
				System.out.println("\n==== Remove Student ====");
				System.out.print("Enter Id: ");
				id = scan.nextLine();
				
				manage.removeStudent(id);
				System.out.println("=============================");
				System.out.println("");
				break;
			}
		}while(choice != 0);

	}
}
