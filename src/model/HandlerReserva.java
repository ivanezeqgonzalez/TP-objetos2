package model;

import java.util.*;
import org.joda.time.DateTime;

public class HandlerReserva {
	private List<Reserva> reservas;
	private List<SolicitudReserva> solicitudes;
	

	HandlerReserva() {
		this.reservas = new ArrayList<Reserva>();
		this.solicitudes = new ArrayList<SolicitudReserva>();	
	}

	public void setSolicitudes(List<SolicitudReserva> solicitudes) {
		this.solicitudes = solicitudes;
	}
		
	public List<Reserva> getReservasActivas() {
		return this.reservas;
	}

	public List<SolicitudReserva> getSolicitudesPendientes() {
		return this.solicitudes;
	}

	public void concretarSolicitud(SolicitudReserva solicitud) {
		if (solicitud.sigueDisponible()) {
			this.reservas.add(solicitud.concretarReserva());
		}
	}
	
	public void solicitudReserva(Publicacion unaPublicacion, DateTime fi, DateTime ff, Inquilino unInquilino) {
		this.solicitudes.add(new SolicitudReserva(unaPublicacion, fi, ff, unInquilino));
	}

	public void descartarSolicitud(SolicitudReserva solicitud) {
		this.solicitudes.remove(solicitud);
		//notificar?
		
	}

}
