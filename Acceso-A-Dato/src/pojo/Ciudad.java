package pojo;

public class Ciudad {

	private String nombre;
	private int autocinesId;

	public Ciudad(String nombre, int autocinesId) {
		this.nombre = nombre;
		this.autocinesId = autocinesId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAutocinesId() {
		return autocinesId;
	}

	public void setAutocinesId(int autocinesId) {
		this.autocinesId = autocinesId;
	}
	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + ", autocinesId=" + autocinesId + "]";
	}
	
}
