package Objetos;

public class Consultorio {
	private int numero;
	private int piso;
	
	public Consultorio() {
		
	}
	
	public Consultorio(int numero, int piso) {
		this.numero= numero;
		this.piso= piso;
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

}
