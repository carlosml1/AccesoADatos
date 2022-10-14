package prZooDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConexion {

	Connection connection;
	
	public Connection getConnection() {
		String dbName = "bd_zoo";
		String userName = "root";
		String contraseña = "admin";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName, userName, contraseña);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return connection;
		
	}
}
