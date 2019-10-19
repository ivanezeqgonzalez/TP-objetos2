package model;

import java.util.*;

public class Inquilino extends Usuario implements ObserverInquilino {

	private ArrayList<Reserva> reservasAceptadas = new ArrayList<Reserva>();
	protected int ranking;

	public ArrayList<Reserva> getReservas() {
		return this.reservasAceptadas;
	}

	Inquilino(String nombreCompleto, String eMail, String telefono) {
		super(nombreCompleto, eMail, telefono);
		this.ranking = 0;
	}

	@Override
	public void agregarReservaAceptada(Reserva reserva) {
		this.reservasAceptadas.add(reserva);
	}

}
