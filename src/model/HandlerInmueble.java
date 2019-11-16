package model;

import java.util.ArrayList;
import java.util.List;

public class HandlerInmueble {
	
	private List<Inmueble> inmuebles = new ArrayList<Inmueble>();

	public List<Inmueble> getInmuebles() {
		return this.inmuebles;
	}

	

	public void crearInmueble(TipoInmueble tipo, String pais, String ciudad, String direccion, int cantHuespedes, Propietario propietario) {
		
		this.inmuebles.add(new Inmueble(tipo, pais, ciudad, direccion, cantHuespedes, propietario));
		
	}
	
	

}
