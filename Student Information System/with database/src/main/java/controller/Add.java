package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLException;

import connection.Connections;
import model.Students;

public class Add {
    public void addStudent(Students s) {
        if (s.getId() == null) {
            System.out.println("Invalid format, can't register.");
            return;
        }

        String query = "INSERT INTO students (idStudent, fullName, birthDate, age, gender, course) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Connections.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, s.getId());
            pstmt.setString(2, s.getName());
            pstmt.setInt(3, s.getBirthDate());
            pstmt.setInt(4, s.getAge());
            pstmt.setString(5, s.getGender());
            pstmt.setString(6, s.getCourse());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Student registered successfully!\n");
            } else {
                System.out.println("⚠️ Failed to register student.");
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("⚠️ Student ID already exists in database.\n");
        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
        }
    }
}
