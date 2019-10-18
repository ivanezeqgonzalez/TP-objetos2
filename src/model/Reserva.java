package model;

import java.time.LocalDate;

public class Reserva {

	private Inquilino inquilino;
	private Inmueble inmueble;
	private LocalDate checkin;
	private LocalDate checkout;

	Reserva(Inquilino inq, Inmueble inm, LocalDate in, LocalDate out) {
		this.inquilino = inq;
		this.inmueble = inm;
		this.checkin = in;
		this.checkout = out;
	}

	public Inquilino getInquilino() {
		return this.inquilino;
	}

	public Inmueble getInmueble() {
		return this.inmueble;
	}

	public LocalDate getCheckin() {
		return this.checkin;
	}

	public LocalDate getCheckout() {
		return this.checkout;
	}

	public Propietario getDueño() {
		return this.inmueble.getDueño();
	}
}
