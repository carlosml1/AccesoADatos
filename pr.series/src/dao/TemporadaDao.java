package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Temporada;

public class TemporadaDao extends ObjetoDao implements Dao<Temporada> {

	private static Connection connection;

	@Override
	public void insertar(Temporada t) {
		// TODO Auto-generated method stub

		connection = openConnection();
		int num_Temporada = t.getNum_temporada();
		String titulo = t.getTitulo();
		int serie_id = t.getSerie().getId();
		String query = "insert into temporadas (num_temporada, titulo, " + "serie_id) values (?, ?, ?)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, t.getNum_temporada());
			ps.setString(2, t.getTitulo());
			ps.setInt(3, t.getSerie().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection();
	}

	@Override
	public void modificar(Temporada t) {
		

	}

	@Override
	public void borrar(Temporada t) {

		connection = openConnection();

		int id = t.getId();

		String query = "delete from temporadas where id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {

		}
		closeConnection();
	}

	public void borrarPorSerie(int serie_id) {
		connection = openConnection();

		String query = "delete from temporadas where serie_id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}

	@Override
	public ArrayList<Temporada> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temporada buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
