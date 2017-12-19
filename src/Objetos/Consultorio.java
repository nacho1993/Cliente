package Objetos;

public class Consultorio {
	private int id;
	private int numero;
	private int piso;
	private Boolean estado;
	
	public Consultorio() {
		
	}
	
	public Consultorio(int id, int numero, int piso, Boolean estado) {
		this.id = id;
		this.numero= numero;
		this.piso= piso;
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
