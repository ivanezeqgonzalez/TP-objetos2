package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HandlerPublicacion {
	
	private List<Publicacion> publicaciones = new ArrayList<Publicacion>();

	public List<Publicacion> getPublicaciones() {
		// TODO Auto-generated method stub
		return this.publicaciones;
	}

	public void crearPublicacion(Propietario propietario, Inmueble inmueble, LocalDate checkin, LocalDate checkout,
			float precio) {
		
		this.publicaciones.add(new Publicacion(propietario, inmueble, checkin, checkout, precio));
		
	}
	
	

}
