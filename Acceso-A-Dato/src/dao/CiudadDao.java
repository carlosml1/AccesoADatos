package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import pojo.Autocines;
import pojo.Ciudad;

public class CiudadDao extends ObjetoDao implements Dao<Ciudad> {
	
	private static Connection connection;
	
	@Override
	public void insertar(Ciudad t) {
		String nombre = t.getNombre();
		int ciudad_autocine = t.getAutocinesId();
		
		connection = openConnection();
		String query3 = "ALTER TABLE Ciudad AUTO_INCREMENT=0;";
		String query2 = "SET SQL_SAFE_UPDATES = 0;";
		String query = "insert into ciudad (nombre, autocines_id) values (?,?)";
		PreparedStatement ps;
		try {
			PreparedStatement ps1 = connection.prepareStatement(query2);
			ps1 = connection.prepareStatement(query3);
			ps1.executeUpdate();
			ps = connection.prepareStatement(query);
			ps.setString(1, t.getNombre());
			ps.setInt(2, t.getAutocinesId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modificar(String nombre, String nombre2) {
		
		connection = openConnection();
		
		String query = "update ciudad set nombre=? where nombre=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, nombre2);
			ps.setString(2, nombre);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void borrar(Ciudad t) {
		connection = openConnection();

        String nombre = t.getNombre();

        String query = "delete from ciudad where nombre = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nombre);
            ps.execute();
        }catch (SQLException e){

        }
        closeConnection();	
		
	}

	@Override
	public ArrayList<Ciudad> buscarTodos() {
		ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
		connection = openConnection();
		
		String query = "select * from ciudad";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Ciudad ciudad1 = new Ciudad(
						rs.getString("nombre"),
						rs.getInt("autocines_id"));
				ciudades.add(ciudad1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return ciudades;
	}

	@Override
	public Ciudad buscarPorNombre(String nombre) {
		connection = openConnection();
		Ciudad s=null;
		
		String query = "select * from ciudad where nombre=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			
			ps.setString(1, nombre);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				s = new Ciudad(
						rs.getString("nombre"),
						rs.getInt("autocines_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return s;
	}
	public void borrarTodo() {
		connection = openConnection();
		String query = "delete from ciudad";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	@Override
	public void borrarCiudad(Ciudad ciudad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ciudad buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(Ciudad t) {
		// TODO Auto-generated method stub
		
	}


}
