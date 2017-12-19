package Objetos;

public class Doctor extends Persona {
	private int matricula;
	private String especialidad;
	 
	public Doctor() {
		
	}
	
	public Doctor(int id, int dni, String nombre, String apellido, String domicilio, String especialidad, int matricula, Boolean estado) {
		super(id, dni, nombre, apellido, domicilio, estado);
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
