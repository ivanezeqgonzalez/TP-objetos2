package model;

import java.util.*;

public class HandlerReserva {
	//version2
	private List<Reserva> reservasSolicitadas;
	private List<Reserva> reservas;

	HandlerReserva() {
		this.reservas = new ArrayList<Reserva>();
		//version2
		this.reservasSolicitadas= new ArrayList<Reserva>();
	}

	public void peticionReserva(Reserva reserva) {
		NotificacionReserva nr = new NotificacionReserva(this, reserva);
		this.reservasSolicitadas.add(reserva); //version2
		reserva.getInmueble().getDue�o().recibirSolicitudReserva(reserva);
		//nr.notificarReservaSolicitada();
		
	}

	public void registrarReserva(Reserva reserva) {
		this.reservas.add(reserva);
		reserva.getInquilino().agregarReservaAceptada(reserva);
		
		//version2
		reserva.getInmueble().getDue�o().removerSolicitudReserva(reserva);
		//reserva.getInmueble().getDue�o().removeObserver(notificacionReserva);(reserva);
	}

}
