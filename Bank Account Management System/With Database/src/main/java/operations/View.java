package operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import model.BankAccount;

public class View {
ArrayList<BankAccount> users = new ArrayList<>();
	
	public void ViewAllAccounts() {
		String sql = "SELECT * FROM users";
		
		try(Connection conn = Database.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
						ResultSet rs = stmt.executeQuery()) {
			
			boolean hasAccount = false;
			
			while(rs.next()) {
				hasAccount = true;
				int accountId = rs.getInt("accountId");
				String accountName = rs.getString("accountName");
				double savingAccount = rs.getDouble("savings");
				String pinCode = rs.getString("pin");
				
				
				BankAccount account = new BankAccount(accountId, accountName, savingAccount, pinCode);
				account.DisplayInfo();
			}
			
			if(!hasAccount) {
				System.out.println("No Account register!");
			}
			
		} catch (SQLException e) {
			
		}
	}
}
