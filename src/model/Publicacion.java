package model;

import java.time.LocalDate;

public class Publicacion {
	
	private Float precio;
	private Inmueble inmueble;
	private LocalDate checkin;
	private LocalDate checkout;

	Publicacion(Inmueble inm, LocalDate in, LocalDate out, Float precio) {
		this.inmueble = inm;
		this.checkin = in;
		this.checkout = out;
		this.precio = precio;
	}

	public void reservar(HandlerReserva hr, Inquilino unInquilino, LocalDate in, LocalDate out) {
		hr.peticionReserva(new Reserva(unInquilino, this.inmueble, in, out));
	}

}
