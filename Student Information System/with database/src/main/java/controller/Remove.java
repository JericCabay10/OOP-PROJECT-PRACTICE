package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.Connections;

public class Remove {
    public void removeStudent(String id) {
        String query = "DELETE FROM students WHERE idStudent = ?";

        try (Connection conn = Connections.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, id);
            int row = pstmt.executeUpdate();

            if (row > 0) {
                System.out.println("✅ Student removed successfully!\n");
            } else {
                System.out.println("⚠️ Student ID not found in database.\n");
            }

        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
        }
    }
}
