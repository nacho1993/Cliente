package Objetos;

public class Turno {
	private int numero;
	private String fecha;
	public Pasiente pasiente;
	public Doctor doctor;
	
	
	public Turno() {
		
	}

	public Turno(int numero, String fecha, Pasiente pasiente, Doctor doctor) {
		this.numero= numero;
		this.fecha= fecha;
		this.pasiente= pasiente;
		this.doctor= doctor;
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Pasiente getPasiente() {
		return pasiente;
	}

	public void setPasiente(Pasiente pasiente) {
		this.pasiente = pasiente;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}
