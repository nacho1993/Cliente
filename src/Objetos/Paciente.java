package Objetos;

import java.sql.Date;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Paciente extends Persona {
	private int legajo;
	private String fecnac;
	private String obrasocial;
	
	public Paciente() {
		
	}
	
	public Paciente(int id, int dni, String nombre, String apellido, String domicilio, int legajo, String fecnac, String obrasocial, Boolean estado){
		super(id, dni, nombre, apellido, domicilio, estado);
		this.legajo= legajo;
		this.fecnac= fecnac;
		this.obrasocial= obrasocial;
	}

	public String getFecnac() {
		return fecnac;
	}

	public void setFecnac(String fecnac) {
		this.fecnac = fecnac;
	}

	public String getObrasocial() {
		return obrasocial;
	}

	public void setObrasocial(String obrasocial) {
		this.obrasocial = obrasocial;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

}
