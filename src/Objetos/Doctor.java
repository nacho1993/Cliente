package Objetos;

public class Doctor extends Persona {
	private int matricula;
	private String especialidad;
	 
	public Doctor() {
		
	}
	
	public Doctor(int dni, String nombre, String apellido, String domicilio, int matricula, String especialidad) {
		super(dni, nombre, apellido, domicilio);
		this.matricula= matricula;
		this.especialidad= especialidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

}
