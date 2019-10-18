package model;

import java.util.*;

public class NotificacionReserva implements ObservableNotificar, ObserverNotificar{
	private Propietario due�o;
	private HandlerReserva hReserva;
	private Reserva reserva;
	
	NotificacionReserva(HandlerReserva hReserva, Reserva reserva) {
		this.due�o = reserva.getInmueble().getDue�o();
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
		this.due�o.recibirSolicitudReserva(this.reserva); 
	}

	@Override
	public void notificarReservaAceptada(Reserva reserva) {
		if(reserva == this.reserva) {
			this.hReserva.registrarReserva(reserva);
		}
	}

}
