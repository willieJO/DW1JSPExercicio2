package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String HOST = "localhost";
	private static final String DB_NAME = "exercicio2";
	private static final String USER = "root";
	private static final String PASSWORD = "";

    static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		final String url = String.format("jdbc:mysql://%s/%s", HOST, DB_NAME);
		return DriverManager.getConnection(url, USER, PASSWORD);		
	}	
    
}
