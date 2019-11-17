package model;

import java.util.*;

public class Inquilino extends Usuario implements ObserverInquilino {
	private ArrayList<Reserva> reservasAceptadas = new ArrayList<Reserva>();

	Inquilino(String nombreCompleto, String eMail, String telefono, Sistema sistema) {
		super(nombreCompleto, eMail, telefono, sistema);
		this.ranking = 0;
	}
	
	public List<Reserva> getReservas() {
		return this.sistema.getReservasDe(this);
	}
	
	@Override
	public void agregarReservaAceptada(Reserva reserva) {
		this.sistema.agregarReservaPara(this, reserva);
	}

}