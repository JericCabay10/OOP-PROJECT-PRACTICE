package controller;

import java.sql.*;
import java.util.ArrayList;

import connection.Connections;
import model.Students;

public class View {
    ArrayList<Students> students = new ArrayList<>();

    public void viewStudent() {
        String query = "SELECT * FROM students";

        try (Connection conn = Connections.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            students.clear();

            while (rs.next()) {
                String id = rs.getString("idStudent");
                String name = rs.getString("fullName");
                int birthYear = rs.getInt("birthDate");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String course = rs.getString("course");

                Students s = new Students(id, name, birthYear, age, gender, course);
                students.add(s);
            }

            if (students.isEmpty()) {
                System.out.println("No student available.");
            } else {
                System.out.println("Registered students: " + students.size());
                for (Students s : students) {
                    s.DisplayInfo();
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
        }
    }
}
