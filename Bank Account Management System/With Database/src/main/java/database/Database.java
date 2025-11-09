package database;

import java.sql.*;


public class Database {
	public static final String URL = "jdbc:mysql://localhost:3306/bankaccountmanagementsystem";
	public static final	String USERNAME = "root";
	public static final String PASSWORD = "";
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC Driver is not found");
		}catch(SQLException e) {
			System.out.println("Database connection failed " + e.getMessage());
		}
		return conn;
	}
}


// DEBUG IN MAIN
//Connection conn = Database.getConnection();
//if (conn != null) {
//    System.out.println("✅ Connection successful!");
//} else {
//    System.out.println("❌ Connection failed.");
//}