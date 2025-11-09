package operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;
import model.BankAccount;

public class Update {
    
    public void UpdateAccount(BankAccount account) {
        String sql = "UPDATE users SET savings = ? WHERE accountId = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, account.getInitialSavings());
            stmt.setInt(2, account.getAccountId());

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Database updated successfully!");
            } else {
                System.out.println("Failed to update database. Account not found.");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

}
