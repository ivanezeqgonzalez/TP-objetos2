package model;

import org.joda.time.DateTime;

public class Publicacion {
	
	private Float precio;
	private Inmueble inmueble;
	private Intervalo intervalo;
	private HandlerReserva handlerReserva;
	private Propietario propietario;

	public Publicacion(HandlerReserva handlerReserva, Propietario propietario, Inmueble inm, DateTime in, DateTime out, Float precio) {
		this.inmueble = inm;
		this.intervalo = new Intervalo(in, out);
		this.precio = precio;
		this.handlerReserva = handlerReserva;
		this.propietario = propietario;
	}

	//GETTERS
	public int getHuespedes() {
		return this.inmueble.getCantHuespedes();
	}
	public double getPrecio() {
		return this.precio;
	}
	public String getCiudad() {
		return this.inmueble.getCiudad();
	}
	public Propietario getPropietario() {
		return this.propietario;
	}
	
	public Inmueble getInmueble() {
		return this.inmueble;
	} 
	
	
	//METODOS PRINCIPALES
	public void reservar(Inquilino unInquilino, DateTime in, DateTime out) {		
		
		if (this.intervalo.estaDisponible(in, out)) {
			handlerReserva.peticionReserva(new Reserva(unInquilino, this.inmueble, in, out));
		}
		
	}
	
	public Boolean estaDisponibleEnRango(DateTime fecha_inicio, DateTime fecha_fin) {
		return this.intervalo.estaDisponible(fecha_inicio, fecha_fin);
		
	}


	

}
