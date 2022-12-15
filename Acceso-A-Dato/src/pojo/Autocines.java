package pojo;

public class Autocines {
	
	private int id;
	private String nombre;
	private String trabajador;
	private String coches;
	private String clientes;
	
	public Autocines(int id, String nombre, String trabajador, String coches, String clientes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.trabajador = trabajador;
		this.coches = coches;
		this.clientes = clientes;
	}

	public Autocines(String nombre, String trabajador, String coches, String clientes) {
		super();
		this.nombre = nombre;
		this.trabajador = trabajador;
		this.coches = coches;
		this.clientes = clientes;
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

	public String getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(String trabajador) {
		this.trabajador = trabajador;
	}

	public String getCoches() {
		return coches;
	}

	public void setCoches(String coches) {
		this.coches = coches;
	}

	public String getClientes() {
		return clientes;
	}

	public void setClientes(String clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Autocines [nombre=" + nombre + ", trabajador=" + trabajador + ", coches=" + coches
				+ ", clientes=" + clientes + "]";
	}
	
	
}
