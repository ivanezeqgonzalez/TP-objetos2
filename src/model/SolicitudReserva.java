package model;

import org.joda.time.DateTime;

public class SolicitudReserva {
	private Publicacion publicacion;
	private DateTime fecha_inicio;
	private DateTime fecha_fin;
	private Inquilino inquilino;
	
	public SolicitudReserva(Publicacion unaPublicacion, DateTime fecha_inicio, DateTime fecha_fin, Inquilino unInquilino) {
		this.publicacion = unaPublicacion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.inquilino = unInquilino;
	}
	public boolean sigueDisponible() {
		return this.publicacion.estaDisponibleEnRango(fecha_inicio, fecha_fin);
	}
	public Reserva concretarReserva() {
		return this.publicacion.concretarReserva(this);
	}
	
	public DateTime getFechaFin() {
		return this.fecha_fin;
	}
	
	public DateTime getFechaInicio() {
		return this.fecha_inicio;
	}
	public Inquilino getInquilino() {
		return this.inquilino;
	}

	public Propietario getPropietario() {
		return this.publicacion.getPropietario();
	}

}
