package model;

import java.time.LocalDate;


public class Publicacion {
	
	private Float precio;
	private Inmueble inmueble;
	private LocalDate checkin;
	private LocalDate checkout;
	//private Fechas adminFechas;
	private Propietario propietario;

	public Publicacion(Propietario propietario, Inmueble inm, LocalDate in, LocalDate out, Float precio) {
		this.inmueble = inm;
		this.checkin = in;
		this.checkout = out;
		this.precio = precio;
		//this.adminFechas = new Fechas();
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
	public void reservar(HandlerReserva hr, Inquilino unInquilino, LocalDate in, LocalDate out) {
		hr.peticionReserva(new Reserva(unInquilino, this.inmueble, in, out));
	}
	
	public Boolean estaDisponibleEnRango(LocalDate fecha_inicio, LocalDate fecha_fin) {
		//return this.adminFechas.fechasSeSobreponen(this.checkin,this.checkout, fecha_inicio, fecha_fin);
		return fecha_inicio.isBefore(this.checkin) && fecha_fin.isBefore(this.checkout);
		
	}

	//public void setAdminFechas(Fechas adminFecha) {
	//	this.adminFechas = adminFecha;
	//}

	

}
