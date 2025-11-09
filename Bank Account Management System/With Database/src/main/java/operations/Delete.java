package operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.Database;

public class Delete {
	public void DeleteUser(int accountId) {
		String sql = "DELETE FROM users WHERE accountId = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, accountId);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Account '" + accountId + "' deleted successfully.");
            } else {
                System.out.println("No account found with acountId: " + accountId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
