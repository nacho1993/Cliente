package Objetos;

import java.sql.Date;

public class Pasiente extends Persona {
	private int legajo;
	private String fecnac;
	private String obrasocial;
	
	public Pasiente() {
		
	}
	
	public Pasiente(int dni, String nombre, String apellido, String domicilio, int legajo, String fecnac, String obrasocial	){
		super(dni, nombre, apellido, domicilio);
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
