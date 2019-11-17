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
		this.handlerPublicacion = new HandlerPublicacion();
		this.handlerInmuebles = new HandlerInmueble();
		this.handlerReservas = new HandlerReserva();
		this.buscador = new MotorDeBusqueda();

	}
	
	
	//PUBLICACIONES
	public List<Publicacion> getAllPublicaciones() {
		return this.handlerPublicacion.getPublicaciones();
	}
	
	public List<Publicacion> getPublicacionesDe(Propietario propietario){
		return this.handlerPublicacion.getPublicaciones().stream().
				filter(p -> p.getPropietario() == propietario).collect(Collectors.toList()); 
	};
	
	
	public void publicar(Propietario propietario, Inmueble inmueble, DateTime checkin, DateTime checkout, float precio) {
		this.handlerPublicacion.crearPublicacion(handlerReservas, propietario, inmueble, checkin, checkout, precio);
	}

	
	//INMUEBLES
	public List<Inmueble> getInmuebles() {
		// TODO Auto-generated method stub
		return this.handlerInmuebles.getInmuebles();
	}


	public void crearInmueble(TipoInmueble tipo, String pais, String ciudad, String direccion, int cantHuespedes,	Propietario propietario) {
		this.handlerInmuebles.crearInmueble(tipo, pais, ciudad, direccion, cantHuespedes, propietario);
		
	}

	//BUSQUEDAS

	public ArrayList<Publicacion> buscarPublicaciones(ArrayList<Publicacion> publicaciones, ArrayList<Filtro> filtros) throws SinFiltrosObligatoriosException {
		return this.buscador.buscarPublicaciones(publicaciones, filtros);
	}

	
	
	//RESERVAS (SIN TDD)
	public void cargarSolicutudReserva(Reserva reserva) {
		this.handlerReservas.peticionReserva(reserva);
		
	}
	public void registrarReservaDe(Reserva reserva) {
		this.handlerReservas.aceptarReserva(reserva);
		
	}

	public List<Reserva> getReservasPendientesDe(Propietario propietario) {
		
		return	this.handlerReservas.getReservasPendientes().stream().
				filter(r -> r.getPropietario() == propietario).collect(Collectors.toList());
		
	}
	
	public List<Reserva> getReservasActivasDe(Inquilino inquilino) {
		
		return	this.handlerReservas.getReservasActivas().stream().
				filter(r -> r.getInquilino() == inquilino).collect(Collectors.toList());
		
		
	}
	public List<Reserva> getReservasPendientesDe(Inquilino inquilino) {
		 
		return	this.handlerReservas.getReservasPendientes().stream().
				filter(r -> r.getInquilino() == inquilino).collect(Collectors.toList());
		
	}

	public void descartarSolicitud(Reserva reserva) {
		this.handlerReservas.descartarSolicitud(reserva);
		
	}
	

	
	
	
	
	
	
	

}
