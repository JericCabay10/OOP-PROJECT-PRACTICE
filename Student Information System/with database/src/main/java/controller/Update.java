package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.Connections;

public class Update {
    public void updateStudent(String id, String name, int birthDate, int age, String gender, String course) {
        String query = "UPDATE students SET fullName = ?, birthDate = ?, age = ?, gender = ?, course = ? WHERE idStudent = ?";

        try (Connection conn = Connections.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, birthDate);
            pstmt.setInt(3, age);
            pstmt.setString(4, gender);
            pstmt.setString(5, course);
            pstmt.setString(6, id);

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
}
