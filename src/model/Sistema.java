package model;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class Sistema {
	private ArrayList<Publicacion> publicaciones;
	
	public Sistema() {
		this.publicaciones = new ArrayList<Publicacion>();
	}
	
	public ArrayList<Publicacion> getAllPublicaciones() {
		return this.publicaciones;
	}
	public void publicar(Propietario unPropietario, Inmueble unInmueble, DateTime fechaInicio, DateTime fechaFin, float precio) {
		this.publicaciones.add(new Publicacion(unPropietario, unInmueble, fechaInicio, fechaFin, precio));
	}
}
