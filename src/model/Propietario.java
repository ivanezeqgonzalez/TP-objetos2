package model;
import java.util.*;

public class Propietario extends Usuario implements ObservablePropietario {

	private List<Inmueble> inmuebles = new ArrayList<Inmueble>();
	
	private HandlerReserva handlerReserva;
	
	
	public Propietario(String nombreCompleto, String eMail, String telefono, HandlerReserva hr) {
		super(nombreCompleto, eMail, telefono);
	
		this.handlerReserva = hr;
	}

	public void agregarInmueble (Inmueble inmueble) {
		this.inmuebles.add(inmueble);
	}

	public List<Inmueble> getInmuebles() {
		return this.inmuebles;
	}
	
	public void aceptarReserva(Reserva reserva) {
		this.handlerReserva.registrarReserva(reserva);
		
	}

	public List<Reserva> getReservasPendientes() {
		return this.handlerReserva.getReservasPendientes();
	}

	public void recibirSolicitudReserva(Reserva reserva) {
		this.handlerReserva.peticionReserva(reserva);
	}
	
	public void removerSolicitudReserva(Reserva reserva) {
		this.handlerReserva.descartarSolicitud(reserva);
	}
}










