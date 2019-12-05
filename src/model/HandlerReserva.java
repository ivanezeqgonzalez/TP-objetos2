package model;

import java.util.*;
import java.util.stream.*;

public class HandlerReserva {
	private List<Reserva> reservas;
	

	HandlerReserva() {
		this.reservas = new ArrayList<Reserva>();		
	}

		
	public List<Reserva> getReservasActivas() {
		return this.reservas.stream().filter(r -> r.esActiva()).collect(Collectors.toList());
	}

	public List<Reserva> getReservasPendientes() {
		return this.reservas.stream().filter(r -> ! r.esActiva()).collect(Collectors.toList());
	}

	public void aceptarReserva(Reserva reserva) {
		reserva.setActiva();
		this.reservas.add(reserva);		
	}
	
	public void peticionReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}

	public void descartarSolicitud(Reserva reserva) {
		this.reservas.remove(reserva);
		
	}

}
