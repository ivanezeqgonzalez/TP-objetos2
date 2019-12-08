package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;

import busqueda.Filtro;
import busqueda.MotorDeBusqueda;
import exceptions.SinFiltrosObligatoriosException;

public class Sistema {

	private HandlerPublicacion handlerPublicacion;
	private HandlerInmueble handlerInmuebles;
	private HandlerReserva handlerReservas;
	private MotorDeBusqueda buscador;
	
	public Sistema() {
		this.handlerInmuebles = new HandlerInmueble();
	}
	
	public void setBuscador(MotorDeBusqueda unBuscador) {
		this.buscador = unBuscador;
	}
	public void setHandlerReserva(HandlerReserva handlerReserva) {
		this.handlerReservas = handlerReserva;
	}
	public void setHandlerPublicacion(HandlerPublicacion handlerPublicacion) {
		this.handlerPublicacion = handlerPublicacion;
	}
	
	//PUBLICACIONES
	public List<Publicacion> getAllPublicaciones() {
		return this.handlerPublicacion.getPublicaciones();
	}
	public List<Publicacion> getPublicacionesActivas() {
		return this.handlerPublicacion.getPublicacionesActivas();
	}
	
	public List<Publicacion> getPublicacionesDe(Propietario propietario){
		return this.handlerPublicacion.getPublicaciones().stream().
				filter(p -> p.getPropietario() == propietario).collect(Collectors.toList()); 
	};
	
	
	public void publicar(Propietario propietario, Inmueble inmueble, DateTime checkin, DateTime checkout, float precio) {
		Publicacion pub = this.handlerPublicacion.crearPublicacion(inmueble, checkin, checkout, precio);
		pub.setHandlerReserva(this.handlerReservas);
	}

	
	//INMUEBLES
	public List<Inmueble> getInmuebles() {
		return this.handlerInmuebles.getInmuebles();
	}


	public void crearInmueble(Inmueble inmueble, Propietario propietario) {
		this.handlerInmuebles.setInmueblePropietario(inmueble, propietario);
		
	}

	//BUSQUEDAS

	public ArrayList<Publicacion> buscarPublicaciones(ArrayList<Filtro> filtros) throws SinFiltrosObligatoriosException {
		return this.buscador.buscarPublicaciones(filtros);
	}

	
	
	//RESERVAS
	
	public List<Reserva> getReservasActivas() {
		return this.handlerReservas.getReservasActivas();
	}
	
	public List<SolicitudReserva> getSolicitudesPendientes(){
		return this.handlerReservas.getSolicitudesPendientes();
	}
	
	
	public void concretarReserva(SolicitudReserva solicitud, Propietario propietario) {
		if (solicitud.getPropietario().equals(propietario) && getSolicitudesPendientesDe(propietario).contains(solicitud)) {
			this.handlerReservas.concretarSolicitud(solicitud);			
		}		
	}

	public List<SolicitudReserva> getSolicitudesPendientesDe(Propietario propietario) {
		return this.handlerReservas.getSolicitudesPendientes().stream().
				filter(s -> s.getPropietario() == propietario).collect(Collectors.toList());
	}

	public List<Reserva> getReservasActivasDe(Inquilino inquilino) {
		
		return	this.handlerReservas.getReservasActivas().stream().
				filter(r -> r.getInquilino() == inquilino).collect(Collectors.toList());
		
		
	}
	public List<SolicitudReserva> getSolicitudesPendientesDe(Inquilino inquilino) {
		return	this.handlerReservas.getSolicitudesPendientes().stream().
				filter(r -> r.getInquilino() == inquilino).collect(Collectors.toList());
		
	}

	public void descartarSolicitud(SolicitudReserva solicitud) {
		this.handlerReservas.descartarSolicitud(solicitud);
		
	}
	public List<Inmueble> getInmuebles(Propietario propietario) {
		return this.handlerInmuebles.getInmueblesPropietario(propietario);
	}

}
