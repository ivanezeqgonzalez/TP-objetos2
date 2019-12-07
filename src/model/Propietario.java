package model;
import java.util.*;

public class Propietario extends Usuario{

	
	public Propietario(String nombreCompleto, String eMail, String telefono, Sistema sistema) {
		super(nombreCompleto, eMail, telefono, sistema);
	}
	
	//RESERVAS
	
	public void aceptarReserva(Reserva reserva) {
		this.sistema.registrarReservaDe(reserva, this);		
	}	
	
	public List<Reserva> getReservasPendientes() {
		return this.sistema.getReservasPendientesDe(this);
	}

	public void removerSolicitudReserva(Reserva reserva) {
		this.sistema.descartarSolicitud(reserva);
	}
}










