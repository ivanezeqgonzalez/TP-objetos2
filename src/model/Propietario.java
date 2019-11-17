package model;
import java.util.*;

public class Propietario extends Usuario implements ObservablePropietario {

	private List<Inmueble> inmuebles = new ArrayList<Inmueble>();
	
	private HandlerReserva handlerReserva;
	
	
	public Propietario(String nombreCompleto, String eMail, String telefono, Sistema sistema) {
		super(nombreCompleto, eMail, telefono, sistema);
	}

	public void agregarInmueble (Inmueble inmueble) {
		//this.sistema.(inmueble);
	}

	public List<Inmueble> getInmuebles() {
		return this.inmuebles;
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










