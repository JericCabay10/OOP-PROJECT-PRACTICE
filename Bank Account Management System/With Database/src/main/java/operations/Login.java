package operations;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;
import model.BankAccount;
import model.LoginModel;

public class Login {
	
	//Admin Login
	public LoginModel AdminLogin(String username, String password) {
	    String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

	    try (Connection conn = Database.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, username);
	        stmt.setString(2, password);

	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            int id = rs.getInt("id");
	            username = rs.getString("username");
	            
	            return new LoginModel(username, password);
	        } else {
	            return null;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}


	
	//User Login
	public BankAccount UserLogin(String pinCode) {
        String sql = "SELECT * FROM users WHERE pin = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pinCode);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("accountId");
                String name = rs.getString("accountName");
                double savings = rs.getDouble("savings");
                String pin = rs.getString("pin");

                return new BankAccount(id, name, savings, pin);
            } else {
                return null; // login failed
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
	
}
