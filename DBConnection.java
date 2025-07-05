package elevatelab_intern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
	private static final String URL = "jdbs:mysql://localhost:3306/EmployeeDB";
	private static final String USER = "root";
	private static final String PASSWORD ="Thamizhan45";
	
	 public static Connection getConnection() {
	        try {
	            return DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (SQLException e) {
	            System.out.println("Connection Failed: " + e.getMessage());
	            return null;
	        }
	    }
}
