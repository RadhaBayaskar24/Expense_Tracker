package Authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB 
{
	    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	    private static final String USER = "system";
	    private static final String PASSWORD = "RADHA";

	    public static Connection getConnection() {
	        try {
	            return DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (SQLException e) {
	            System.err.println("Database connection failed: " + e.getMessage());
	            return null;
	        }
	    }
}
