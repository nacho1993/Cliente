package Objetos;

public class Listaselect {
	private int id;
	private int dni;
	private String nombre;
	
	public Listaselect(int id, int dni, String nombre) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Listaselect() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	

}
