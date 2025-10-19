package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
	private static final String URL = "jdbc:mysql://localhost:3306/students";
	private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection() {
    	Connection conn = null;
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		conn = DriverManager.getConnection(URL, USER, PASSWORD);
    	}catch(ClassNotFoundException e) {
    		System.out.println("❌ JDBC Driver not found.");
    	}catch(SQLException e) {
    		System.out.println("❌ Database connection failed: " + e.getMessage());
    	}
    	
    	return conn;
    }
}
