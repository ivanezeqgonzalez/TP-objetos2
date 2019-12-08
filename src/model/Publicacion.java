package model;

import org.joda.time.DateTime;

public class Publicacion {
	
	private Float precio;
	private Inmueble inmueble;
	private Intervalo intervalo;
	private HandlerReserva handlerReserva;
	private Boolean activa;

	public Publicacion(Inmueble inm, DateTime in, DateTime out, Float precio) {
		this.inmueble = inm;
		this.intervalo = new Intervalo(in, out);
		this.precio = precio;
		this.activa = true;
	}
	
	public void setHandlerReserva(HandlerReserva hr) {
		this.handlerReserva = hr;
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
		return this.inmueble.getPropietario();
	}
	
	public Inmueble getInmueble() {
		return this.inmueble;
	} 
	
	
	//METODOS PRINCIPALES
	public void reservar(Inquilino unInquilino, DateTime in, DateTime out) {		
		
		if (this.intervalo.estaDisponible(in, out)) {
			handlerReserva.solicitudReserva(this, in, out, unInquilino);
		}
		
	}
	
	public Boolean estaDisponibleEnRango(DateTime fecha_inicio, DateTime fecha_fin) {
		return this.intervalo.estaDisponible(fecha_inicio, fecha_fin);
		
	}

	public Boolean esActiva() {
		return this.activa;
	}

	public Reserva concretarReserva(SolicitudReserva solicitudReserva) {
		this.intervalo.restarIntervalo(solicitudReserva.getFechaInicio(), solicitudReserva.getFechaFin());
		this.activa = this.intervalo.verifyAct();
		return new Reserva(solicitudReserva.getInquilino(), this.inmueble, solicitudReserva.getFechaInicio(), solicitudReserva.getFechaFin());
	}
}
