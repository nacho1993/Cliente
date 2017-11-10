package Objetos;

public class Persona {
	public int dni;
	public String nombre;
	public String apellido;
	public String domicilio;	
	
	public Persona() {
		
	}
	
	public Persona(int dni, String nombre, String apellido, String domicilio) {
		this.dni = dni;
		this.nombre= nombre;
		this.apellido= apellido;
		this.domicilio= domicilio;
		
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

}
