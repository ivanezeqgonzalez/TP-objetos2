package model;

import java.util.*;

public class Inquilino extends Usuario /*implements ObserverInquilino*/ {
	private ArrayList<Reserva> reservasAceptadas = new ArrayList<Reserva>();

	Inquilino(String nombreCompleto, String eMail, int telefono, Sistema sistema) {
		super(nombreCompleto, eMail, telefono, sistema);
		this.ranking = 0;
	}
		
	public List <Reserva> getReservasActivas(){
		return this.reservasAceptadas;
	}
	
	public List<SolicitudReserva> getReservasPendientes(){
		return this.sistema.getSolicitudesPendientesDe(this);
	}

}