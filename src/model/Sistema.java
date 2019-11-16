package model;

import java.time.LocalDate;
import java.util.List;


public class Sistema {
	private HandlerPublicacion handlerPublicacion;
	private HandlerInmueble handlerInmuebles;
	
	public Sistema() {
		this.handlerPublicacion = new HandlerPublicacion();
		this.handlerInmuebles = new HandlerInmueble();
	}
	
	
	//PUBLICACIONES
	public List<Publicacion> getAllPublicaciones() {
		return this.handlerPublicacion.getPublicaciones();
	}
	
	public void publicar(Propietario propietario, Inmueble inmueble, LocalDate checkin, LocalDate checkout, float precio) {
		this.handlerPublicacion.crearPublicacion(propietario, inmueble, checkin, checkout, precio);
	}


	
	//INMUEBLES
	public List<Inmueble> getInmuebles() {
		// TODO Auto-generated method stub
		return this.handlerInmuebles.getInmuebles();
	}

	public void crearInmueble(TipoInmueble tipo, String pais, String ciudad, String direccion, int cantHuespedes,	Propietario propietario) {
		this.handlerInmuebles.crearInmueble(tipo, pais, ciudad, direccion, cantHuespedes, propietario);
		
	}
	
	
}
