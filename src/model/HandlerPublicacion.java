package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class HandlerPublicacion {
	
	private List<Publicacion> publicaciones = new ArrayList<Publicacion>();

	public List<Publicacion> getPublicaciones() {
		// TODO Auto-generated method stub
		return this.publicaciones;
	}

	public void crearPublicacion(HandlerReserva handler, Propietario propietario, Inmueble inmueble, DateTime checkin, DateTime checkout,
			float precio) {
		
		this.publicaciones.add(new Publicacion(handler, propietario, inmueble, checkin, checkout, precio));
		
	}
	
	

}
