package dao;

import java.util.ArrayList;

import pojo.Ciudad;

public interface Dao<T> {

	public void insertar(T t);
	public void modificar(T t);
	public void borrar (T t);
	public ArrayList<T> buscarTodos();
	public T buscarPorId(int i);
	public void borrarCiudad(Ciudad ciudad);
	public Ciudad buscarPorNombre(String nombre);
	public void modificar(String nombre, String nombre2);
}
