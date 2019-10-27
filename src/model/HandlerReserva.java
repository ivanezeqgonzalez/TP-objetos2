package model;

import java.util.*;

public class HandlerReserva {
	private List<Reserva> reservas;

	HandlerReserva() {
		this.reservas = new ArrayList<Reserva>();
	}

	public void peticionReserva(Reserva reserva) {
		reserva.getPropietario().recibirSolicitudReserva(reserva);
	}

	public void registrarReserva(Reserva reserva) {
		this.reservas.add(reserva);
		reserva.getInquilino().agregarReservaAceptada(reserva);
		reserva.getPropietario().removerSolicitudReserva(reserva);
	}

}
