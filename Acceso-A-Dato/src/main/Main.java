package main;

import java.sql.Connection;
import java.util.ArrayList;

import dao.AutoCinesDao;
import dao.CiudadDao;
import pojo.Autocines;
import pojo.Ciudad;

public class Main {

	public static void main(String[] args) {
				
		AutoCinesDao aD = new AutoCinesDao();
		CiudadDao cD = new CiudadDao();
		
		Autocines a = new Autocines ("Autocines Libre","Jose Ador","Mercedes GT","Manuel Porras");
		System.out.println(a);
		aD.insertar(a);
		Autocines a1 = new Autocines ("Autocines Cerrado","Armando Paredes","Audi R8","Javi Vaquero");
		System.out.println(a1);
		aD.insertar(a1);
		Autocines a2 = new Autocines (3,"Autocines Medio","Paquito Chocolatero","Seat Ibiza","Carlos Martín");
		System.out.println(a2);
		aD.insertar(a2);
		
		Ciudad c = new Ciudad ("Malaga",1);
		System.out.println(c);
		cD.insertar(c);
		Ciudad c1 = new Ciudad ("Barcelona",2);
		System.out.println(c1);
		cD.insertar(c1);
		Ciudad c2 = new Ciudad ("Gipuzkoa",3);
		System.out.println(c2);
		cD.insertar(c2);
		
		Autocines a3 = new Autocines (1,"Autocines Tarkov","Dimitri Patrenkov","LADA Niva","Francisco Paco");		
		aD.modificar(a3);
		
		cD.modificar("Malaga","Tarkov");
		
		cD.borrar(c2);
		
		aD.borrar(a2);
		
		System.out.println(cD.buscarPorNombre("Barcelona"));
		
		System.out.println(aD.buscarPorId(2));
		
		cD.borrarTodo();
		aD.borrarTodo();
	}


}
