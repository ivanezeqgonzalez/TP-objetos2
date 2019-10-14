package servicio;

public class Servicio {
	
	private String nombreServicio;
	private String descripcion;
	
	public Servicio(String nombreServicio, String descripcion) {
		super();
		this.nombreServicio = nombreServicio;
		this.descripcion = descripcion;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
}
