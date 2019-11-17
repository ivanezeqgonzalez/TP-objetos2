package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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
	
	public List<Publicacion> getPublicacionesDe(Usuario usuario){
		return this.handlerPublicacion.getPublicaciones(); //falta filtro!
	};
	
	
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
		return this.handlerReservas.getReservasActivas(); //falta filtro!
	}
	public List<Reserva> getReservasActivasDe(Inquilino inquilino) {
		return this.handlerReservas.getReservasActivas(); //falta filtro!
	}

	public void descartarSolicitud(Reserva reserva) {
		this.handlerReservas.descartarSolicitud(reserva);
		
	}
	
	public List<Reserva> getReservasPendientesDe(Inquilino inquilino) {
		return this.handlerReservas.getReservasActivas(); //falta filtro!
	}

	
	
	
	
	
	
	

}
