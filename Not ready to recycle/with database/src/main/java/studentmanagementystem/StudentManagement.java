package studentmanagementystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.Connections;

public class StudentManagement {
	ArrayList<Student> students = new ArrayList<>();
	private int count = 0;
	
	public void addStudent(Student s) {
		if(s.getId() == null) {
			System.out.println("Invalid format can't register");
			return;
		}
		
		String query = "INSERT INTO person (idStudent, name, age, grade) VALUES (?, ?, ?, ?)";
		
		try(Connection conn = Connections.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query)) {
			
			pstmt.setString(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setInt(3, s.getAge());
			pstmt.setString(4, s.getGrade());
			
			int rows = pstmt.executeUpdate();
			
			if(rows > 0) {
				 System.out.println("✅ Student registered successfully!\n");
            } else {
                System.out.println("⚠️ Failed to register student.");
            }
			
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("⚠️ Student ID already exists in database.\n");
		}catch(SQLException e) {
			System.out.println("❌ Database error: " + e.getMessage());
		}
	}

	
	public void viewStudent() {
		String query = "SELECT * FROM person";
		
		try(Connection conn = Connections.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query)) {
			
			while(rs.next()) {
				String id = rs.getString("idStudent");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String grade = rs.getString("grade");
				
				Student s = new Student(id, name, age, grade);
				students.add(s);
			}
			
			if(students.isEmpty()) {
				System.out.println("No student available.");
			}else {
				System.out.println("Register student: " +students.size());
				for(Student s : students) {
					s.studentInfo();
				}
			}
		} catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
        }

	}
	
	public void updateStudent(String id, String name, int age, String grade) {
	    String query = "UPDATE person SET name = ?, age = ?, grade = ? WHERE idStudent = ?";
	    try (Connection conn = Connections.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(query)) {

	        pstmt.setString(1, name);
	        pstmt.setInt(2, age);
	        pstmt.setString(3, grade);
	        pstmt.setString(4, id);

	        int row = pstmt.executeUpdate();

	        if (row > 0) {
	            System.out.println("✅ Student updated successfully!\n");
	        } else {
	            System.out.println("⚠️ Student ID not found in database.\n");
	        }

	    } catch (SQLException e) {
	        System.out.println("❌ Database error: " + e.getMessage());
	    }
	}

	
	public void removeStudent(String id) {
		String query = "DELETE FROM person WHERE idStudent = ?";
		try(Connection conn = Connections.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query)) {
			
			pstmt.setString(1, id);
			
			int row = pstmt.executeUpdate();
			
			if(row > 0) {
				System.out.println("✅ Student updated successfully!\n");
	        } else {
	            System.out.println("⚠️ Student ID not found in database.\n");
	        }
		}catch(SQLException e) {
			System.out.println("Database error: " + e.getMessage());
		}
	}
}
