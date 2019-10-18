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
		// Observer=> Inquilino, Reserva
		// Observable=> this
		if(reserva == this.reserva) {
			//hr se encarga de agegarle al inquilino la reserva
			this.hReserva.registrarReserva(reserva);
		}
	}
	
	@Override
	public void notificarReservaSolicitada() {
		// Observer=> Dueño
		// Observable=> this
		this.dueño.recibirSolicitudReserva(this.reserva); 
		//this.dueño.addObserver(this);
		
	}

	@Override
	public void notificarReservaAceptada(Reserva reserva) {
		// El dueño acepto la reserva
		// Observer=> Inquilino, Reserva
		
		if(reserva == this.reserva) {
			//hr se encarga de agegarle al inquilino la reserva
			this.hReserva.registrarReserva(reserva);
			//this.dueño.removeObserver(this);
		}
	}

}
