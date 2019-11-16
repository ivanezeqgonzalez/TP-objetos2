package model;

import java.time.LocalDate;
import java.util.ArrayList;


public class Sistema {
	private ArrayList<Publicacion> publicaciones;
	
	public Sistema() {
		this.publicaciones = new ArrayList<Publicacion>();
	}
	
	public ArrayList<Publicacion> getAllPublicaciones() {
		return this.publicaciones;
	}
	public void publicar(Propietario unPropietario, Inmueble unInmueble, LocalDate fechaInicio, LocalDate fechaFin, float precio) {
		this.publicaciones.add(new Publicacion(unPropietario, unInmueble, fechaInicio, fechaFin, precio));
	}
}
