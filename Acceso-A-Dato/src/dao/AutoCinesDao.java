package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import pojo.Autocines;
import pojo.Ciudad;
import utils.DatabaseConnection;

public class AutoCinesDao extends ObjetoDao implements Dao<Autocines>{
	
	private static Connection connection;
	
	public AutoCinesDao(){
		
	}
	@Override
	public void insertar(Autocines autocine) {
		// TODO Auto-generated method stub
		connection = openConnection();
		String query3 = "ALTER TABLE autocines AUTO_INCREMENT=0;";
		String query2 = "SET SQL_SAFE_UPDATES = 0;";
		String query = "insert into autocines (nombre,trabajador,coches,clientes)"
				+ "values (?,?,?,?)";
		try {
			PreparedStatement ps1 = connection.prepareStatement(query2);
			ps1 = connection.prepareStatement(query3);
			ps1.executeUpdate();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, autocine.getNombre());
			ps.setString(2, autocine.getTrabajador());
			ps.setString(3, autocine.getCoches());
			ps.setString(4, autocine.getClientes());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void modificar(Autocines autocine) {
		connection = openConnection();
		
		String query = "update autocines set nombre=?,trabajador=?,coches=?,clientes=?"
				+ "where id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(5, autocine.getId());
			ps.setString(1, autocine.getNombre());
			ps.setString(2, autocine.getTrabajador());
			ps.setString(3, autocine.getCoches());
			ps.setString(4, autocine.getClientes());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Autocines> obtenerAutocine(Autocines autocine){
		ArrayList<Autocines> autocines = new ArrayList<Autocines>();
		connection = openConnection();
		
		String query = "select * from autocines where serie_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			
			ps.setInt(1, autocine.getId());
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Autocines autocines1 = new Autocines(
						rs.getString("nombre"),
						rs.getString("trabajador"),
						rs.getString("coches"),
						rs.getString("clientes"));
				autocines.add(autocines1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return autocines;
		
	}
	
	@Override
	public void borrar(Autocines autocine) {
		 connection = openConnection();

	        int id = autocine.getId();

	        String query = "delete from autocines where id = ?";

	        try {
	            PreparedStatement ps = connection.prepareStatement(query);
	            ps.setInt(1, id);
	            ps.execute();
	        }catch (SQLException e){

	        }
	        closeConnection();	
	}
	@Override
	public void borrarCiudad(Ciudad ciudad) {
		connection = openConnection();
		
		int id = ciudad.getAutocinesId();

        String query = "DELETE FROM ciudad WHERE autocines_id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        closeConnection();


	}
	

	@Override
	public ArrayList<Autocines> buscarTodos() {
		// TODO Auto-generated method stub
		ArrayList<Autocines> autocines= new ArrayList<Autocines>();
		connection = openConnection();
		String query = "select * from autocines";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ResultSet r = ps.executeQuery();
			
			while(r.next()) {
				Autocines autocines1 = new Autocines(
						r.getString("nombre"),
						r.getString("trabajador"),
						r.getString("coches"),
						r.getString("clientes"));
				autocines.add(autocines1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return autocines;
	}

	@Override
	public Autocines buscarPorId(int id) {
		// TODO Auto-generated method stub
		connection = openConnection();
		Autocines s= null;
		
		String query = "select * from autocines where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				s = new Autocines(
						r.getString("nombre"),
						r.getString("trabajador"),
						r.getString("coches"),
						r.getString("clientes"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return s;
	}
	public void borrarTodo() {
		connection = openConnection();
		String query = "delete from autocines";
		
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
	public Ciudad buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void modificar(String nombre, String nombre2) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
