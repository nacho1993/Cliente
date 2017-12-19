package login;

public class Formulario {
	private int id;
	private String descripcion;
	
	public Formulario(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Formulario() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
