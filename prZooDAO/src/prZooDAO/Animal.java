package prZooDAO;

public class Animal {
	
	private int id;
	private String nombre;
	private String Habitad;
	private double pesoAproximado;
	
	
	public Animal(String nombre, String habitad, double pesoAproximado) {
		this.nombre = nombre;
		Habitad = habitad;
		this.pesoAproximado = pesoAproximado;
	}

	public Animal(int id, String nombre, String habitad, double pesoAproximado) {
		this.id = id;
		this.nombre = nombre;
		Habitad = habitad;
		this.pesoAproximado = pesoAproximado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHabitad() {
		return Habitad;
	}

	public void setHabitad(String habitad) {
		Habitad = habitad;
	}

	public double getPesoAproximado() {
		return pesoAproximado;
	}

	public void setPesoAproximado(double pesoAproximado) {
		this.pesoAproximado = pesoAproximado;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nombre=" + nombre + ", Habitad=" + Habitad + ", pesoAproximado=" + pesoAproximado
				+ "]";
	}
	
	
}
