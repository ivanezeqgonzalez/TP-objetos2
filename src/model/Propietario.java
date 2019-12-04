package model;
import java.util.*;

public class Propietario extends Usuario implements ObservablePropietario {

	
	
	public Propietario(String nombreCompleto, String eMail, String telefono, Sistema sistema) {
		super(nombreCompleto, eMail, telefono, sistema);
	}

	public void agregarInmueble (Inmueble inmueble) {
		this.sistema.crearInmueble(inmueble, this);
	}

	public List<Inmueble> getInmuebles() {
		return this.sistema.getInmuebles(this);
	}
	
	
	//RESERVAS
	public void recibirSolicitudReserva(Reserva reserva) {
		this.sistema.cargarSolicutudReserva(reserva);
	}
	
	public void aceptarReserva(Reserva reserva) {
		this.sistema.registrarReservaDe(reserva);
		
	}	
	
	public List<Reserva> getReservasPendientes() {
		return this.sistema.getReservasPendientesDe(this);
	}

	public void removerSolicitudReserva(Reserva reserva) {
		this.sistema.descartarSolicitud(reserva);
	}
}










