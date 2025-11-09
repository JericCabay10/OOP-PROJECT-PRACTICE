package operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;
import model.BankAccount;

public class Find {

    // Return BankAccount instead of boolean
    public BankAccount FindAccountById(int accountId) {
        String sql = "SELECT * FROM users WHERE accountId = ?";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("accountId");
                String name = rs.getString("accountName");
                double savings = rs.getDouble("savings");
                String pin = rs.getString("pin");

                return new BankAccount(id, name, savings, pin);
            } else {
                return null; // account not found
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
