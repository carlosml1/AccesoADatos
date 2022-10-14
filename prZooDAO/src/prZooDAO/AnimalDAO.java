package prZooDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AnimalDAO {

	private static Connection connection;

	public static void insertAnimal(Animal animal) {
		connection = openConnection();

		String query = "insert into animales (nombre,habitad,peso_aproximado) values (?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, animal.getNombre());
			preparedStatement.setString(2, animal.getHabitad());
			preparedStatement.setDouble(3, animal.getPesoAproximado());
			preparedStatement.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		closeConnection();
	}

	private static Connection openConnection() {
		DataBaseConexion dbConnection = new DataBaseConexion();
		connection = dbConnection.getConnection();
		return connection;
	}

	private static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
