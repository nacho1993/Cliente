package Objetos;

public class Turno {
	private int id;
	private String fecha;
	int doctor;
	int paciente;
	int consultorio;

	
	
	public Turno() {
		
	}

	public Turno(int id, String fecha, int doctor, int paciente, int consultorio) {
		this.id= id;
		this.fecha= fecha;
		this.paciente= paciente;
		this.doctor= doctor;
		this.consultorio= consultorio;
		
	}



	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDoctor() {
		return doctor;
	}

	public void setDoctor(int doctor) {
		this.doctor = doctor;
	}

	public int getPaciente() {
		return paciente;
	}

	public void setPaciente(int paciente) {
		this.paciente = paciente;
	}

	public int getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(int consultorio) {
		this.consultorio = consultorio;
	}

	
}
