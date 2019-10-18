package model;

import java.util.*;

public class NotificacionReserva implements ObservableNotificar, ObserverNotificar{
	private Propietario dueño;
	private HandlerReserva hReserva;
	private Reserva reserva;
	
	NotificacionReserva(HandlerReserva hReserva, Reserva reserva) {
		this.dueño = reserva.getInmueble().getDueño();
		this.hReserva = hReserva;
		this.reserva = reserva;
	}
	
	@Override
	public void notificarReservaConcretada(Reserva reserva) {
		if(reserva == this.reserva) {
			this.hReserva.registrarReserva(reserva);
		}
	}
	
	@Override
	public void notificarReservaSolicitada() {
		this.dueño.recibirSolicitudReserva(this.reserva); 
	}

	@Override
	public void notificarReservaAceptada(Reserva reserva) {
		if(reserva == this.reserva) {
			this.hReserva.registrarReserva(reserva);
		}
	}

}
