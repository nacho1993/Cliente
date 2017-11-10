package Objetos;

public class Ferulas {
	private int numprod;
	private int numser;
	private String descripcion;
	
	public Ferulas(){
		
	}
	
	public Ferulas(int numprod, int numser, String descripcion) {
		this.numprod= numprod;
		this.numser= numser;
		this.descripcion= descripcion;
	}

	public int getNumprod() {
		return numprod;
	}

	public void setNumprod(int numprod) {
		this.numprod = numprod;
	}

	public int getNumser() {
		return numser;
	}

	public void setNumser(int numser) {
		this.numser = numser;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
