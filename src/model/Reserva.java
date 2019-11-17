package model;

import org.joda.time.DateTime;

public class Reserva {

	private Inquilino inquilino;
	private Inmueble inmueble;
	private DateTime checkin;
	private DateTime checkout;

	Reserva(Inquilino inq, Inmueble inm, DateTime in, DateTime out) {
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

	public DateTime getCheckin() {
		return this.checkin;
	}

	public DateTime getCheckout() {
		return this.checkout;
	}

	public Propietario getPropietario() {
		return this.inmueble.getPropietario();
	}
}
