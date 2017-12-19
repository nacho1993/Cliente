package Objetos;

public class Persona {
	public int id;
	public int dni;
	public String nombre;
	public String apellido;
	public String domicilio;
	public Boolean estado;
	
	
	public Persona() {
		
	}
	
	public Persona(int id, int dni, String nombre, String apellido, String domicilio, Boolean estado) {
		this.id = id;
		this.dni = dni;
		this.nombre= nombre;
		this.apellido= apellido;
		this.domicilio= domicilio;
		this.estado = estado; 
		
	}

	public int getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
