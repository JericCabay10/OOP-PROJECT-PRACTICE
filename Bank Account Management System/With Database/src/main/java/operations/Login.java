package operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;
import model.LoginModel;

public class Login {
	
	//Admin Login
	public boolean AdminLogin(String username, String password) {
		String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
		
		try(Connection conn = Database.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			
			return rs.next();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}		
	}
	
	//User Login
	public boolean UserLogin(String pinCode) {
		String sql = "SELECT * FROM users WHERE pin = ?";
		
		try(Connection conn = Database.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, pinCode);
			
			ResultSet rs = stmt.executeQuery();
			return rs.next();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
