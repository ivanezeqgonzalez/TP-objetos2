package borrar;

import java.util.ArrayList;
import java.util.List;

import model.Inmueble;
import model.Usuario;

public class Dueño extends Usuario {

	private List<Inmueble> inmuebles = new ArrayList<Inmueble>();
	
	public Dueño(String nombreCompleto, String eMail, String telefono) {
		super(nombreCompleto, eMail, telefono);
		
		
	}

	public void agregarInmueble (Inmueble inmueble) {
		this.inmuebles.add(inmueble);
	}

	public List<Inmueble> getInmuebles() {
		return this.inmuebles;
	}
	
	

}
