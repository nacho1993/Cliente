package Objetos;

public class Tabla {
	private String nombre;
	private String nomcam;
	private String tipo;
	
	public Tabla(String nombre, String nomcam, String tipo) {
		super();
		this.nombre = nombre;
		this.nomcam = nomcam;
		this.tipo = tipo;
	}

	public Tabla() {

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
