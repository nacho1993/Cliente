package Objetos;

public class Tabla {
	private String nombre;
	private String nomcam;
	private String tipo;
	private Boolean primary;
	
	
	public Tabla(String nombre, String nomcam, String tipo, boolean primary) {
		super();
		this.nombre = nombre;
		this.nomcam = nomcam;
		this.tipo = tipo;
		this.primary = primary;
	}

	public Tabla() {

	}
	
	public Boolean getPrimary() {
		return primary;
	}

	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNomcam() {
		return nomcam;
	}

	public void setNomcam(String nomcam) {
		this.nomcam = nomcam;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
