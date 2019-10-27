package model;

import java.time.LocalDate;

import org.joda.time.DateTime;

public class Publicacion {
	
	private Float precio;
	private Inmueble inmueble;
	private DateTime checkin;
	private DateTime checkout;
	private Fechas adminFechas;
	private Propietario propietario;

	Publicacion(Propietario propietario, Inmueble inm, DateTime in, DateTime out, Float precio) {
		this.inmueble = inm;
		this.checkin = in;
		this.checkout = out;
		this.precio = precio;
		this.adminFechas = new Fechas();
		this.propietario = propietario;
	}

	public void reservar(HandlerReserva hr, Inquilino unInquilino, LocalDate in, LocalDate out) {
		hr.peticionReserva(new Reserva(unInquilino, this.inmueble, in, out));
	}
	public int getHuespedes() {
		return this.inmueble.getCantHuespedes();
	}
	public double getPrecio() {
		return this.precio;
	}
	public String getCiudad() {
		return this.inmueble.getCiudad();
	}
	public Boolean estaDisponibleEnRango(DateTime fecha_inicio, DateTime fecha_fin) {
		return this.adminFechas.verificar(this.checkin,this.checkout, fecha_inicio, fecha_fin);
	}

	public void setAdminFechas(Fechas adminFecha) {
		this.adminFechas = adminFecha;
	}

	public Propietario getPropietario() {
		return this.propietario;
	}

	public Inmueble getInmueble() {
		return this.inmueble;
	} 
	

}
