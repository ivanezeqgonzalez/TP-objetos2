package model;

import java.util.*;

public class Inquilino implements ObserverInquilino {

	private ArrayList<Reserva> reservasAceptadas = new ArrayList<Reserva>();
	protected String nombreCompleto;
	protected String eMail;
	protected String telefono;
	protected int ranking;

	public ArrayList<Reserva> getReservas() {
		return this.reservasAceptadas;
	}

	Inquilino(String nombreCompleto, String eMail, String telefono) {
		this.nombreCompleto = nombreCompleto;
		this.eMail = eMail;
		this.telefono = telefono;
		this.ranking = 0;
	}

	@Override
	public void agregarReservaAceptada(Reserva reserva) {
		this.reservasAceptadas.add(reserva);
	}

}
