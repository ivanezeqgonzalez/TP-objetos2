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
		// Observer=> Inquilino, Reserva
		// Observable=> this
		if(reserva == this.reserva) {
			//hr se encarga de agegarle al inquilino la reserva
			this.hReserva.registrarReserva(reserva);
		}
	}
	
	@Override
	public void notificarReservaSolicitada() {
		// Observer=> Due�o
		// Observable=> this
		this.due�o.recibirSolicitudReserva(this.reserva); 
		//this.due�o.addObserver(this);
		
	}

	@Override
	public void notificarReservaAceptada(Reserva reserva) {
		// El due�o acepto la reserva
		// Observer=> Inquilino, Reserva
		
		if(reserva == this.reserva) {
			//hr se encarga de agegarle al inquilino la reserva
			this.hReserva.registrarReserva(reserva);
			//this.due�o.removeObserver(this);
		}
	}

}
