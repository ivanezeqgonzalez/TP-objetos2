package model;

import java.util.*;

public class HandlerReserva {
	private List<Reserva> reservasActivas;
	private List<Reserva> reservasPendientes;

	HandlerReserva() {
		this.reservasActivas = new ArrayList<Reserva>();
		this.reservasPendientes = new ArrayList<Reserva>();
	}

		
	public List<Reserva> getReservasActivas() {
		return reservasActivas;
	}

	public List<Reserva> getReservasPendientes() {
		return reservasPendientes;
	}

	public void aceptarReserva(Reserva reserva) {
		this.reservasActivas.add(reserva);		
	}
	
	public void peticionReserva(Reserva reserva) {
		this.reservasPendientes.add(reserva);
	}

	public void descartarSolicitud(Reserva reserva) {
		this.reservasPendientes.remove(reserva);
		
	}

}
