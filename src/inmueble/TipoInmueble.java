package inmueble;

public class TipoInmueble {
	
	private String nombre;
	private String descripcion;
	
	public TipoInmueble(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
	
}
