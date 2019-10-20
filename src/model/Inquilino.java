package model;

import java.util.*;

public class Inquilino extends Usuario implements ObserverInquilino {
	private ArrayList<Reserva> reservasAceptadas = new ArrayList<Reserva>();

	Inquilino(String nombreCompleto, String eMail, String telefono) {
		super(nombreCompleto, eMail, telefono);
		this.ranking = 0;
	}
	
	public ArrayList<Reserva> getReservas() {
		return this.reservasAceptadas;
	}
	
	@Override
	public void agregarReservaAceptada(Reserva reserva) {
		this.reservasAceptadas.add(reserva);
	}

}
