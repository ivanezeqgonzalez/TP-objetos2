package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;

public class HandlerPublicacion {
	
	private List<Publicacion> publicaciones = new ArrayList<Publicacion>();

	public List<Publicacion> getPublicaciones() {
		return this.publicaciones;
	}
	
	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones.addAll(publicaciones);
	}

	public Publicacion crearPublicacion(Inmueble inmueble, DateTime checkin, DateTime checkout,
			float precio) {
		Publicacion pub = new Publicacion(inmueble, checkin, checkout, precio);
		this.publicaciones.add(pub);
		return pub;
	}

	public List<Publicacion> getPublicacionesActivas() {
		return this.publicaciones.stream().filter(p -> p.esActiva()).collect(Collectors.toList());
	}
	
	

}
