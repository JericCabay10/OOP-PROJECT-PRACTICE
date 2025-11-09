package operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import model.BankAccount;

public class Add {
	public void AddAcount(BankAccount account) {
		String sql = "INSERT INTO users (accountId, accountName, savings, pin) VALUES(?, ?, ?, ?)";
		
		try(Connection conn = Database.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1, account.getAccountId());
			stmt.setString(2, account.getAccountName());
			stmt.setDouble(3, account.getInitialSavings());
			stmt.setString(4, account.getPinCode());
			
			
			int row = stmt.executeUpdate();
			
			if(row > 0) {
				System.out.println("Register successfull");
			}else {
				System.out.println("Error: No rows were inserted.");
			}
			
		}catch(SQLException e) {
			System.out.println("Invalid Database: " + e.getMessage());
		}
	}
}
