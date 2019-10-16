package usuario;

import java.util.ArrayList;
import java.util.List;

import inmueble.Inmueble;

public class Due�o extends Usuario {

	private List<Inmueble> inmuebles = new ArrayList<Inmueble>();
	
	public Due�o(String nombreCompleto, String eMail, String telefono) {
		super(nombreCompleto, eMail, telefono);
		
		
	}

	public void agregarInmueble (Inmueble inmueble) {
		this.inmuebles.add(inmueble);
	}

	public List<Inmueble> getInmuebles() {
		return this.inmuebles;
	}
	
	

}
