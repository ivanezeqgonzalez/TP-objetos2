package model;
import java.util.*;

public class Propietario extends Usuario implements ObservablePropietario {

	private List<Inmueble> inmuebles = new ArrayList<Inmueble>();
	private String nombreCompleto;
	private String eMail;
	private String telefeno;
	private ArrayList<Reserva> reservasSolicitadas = new ArrayList<Reserva>();
	private HandlerReserva handlerReserva;
	
	
	public Propietario(String nombreCompleto, String eMail, String telefono, HandlerReserva hr) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.eMail= eMail;
		this.telefeno= telefono;
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

	public ArrayList<Reserva> getReservasSolicitadas() {
		return this.reservasSolicitadas;
	}


	public void recibirSolicitudReserva(Reserva reserva) {
		this.reservasSolicitadas.add(reserva);
	}
	
	public void removerSolicitudReserva(Reserva reserva) {
		this.reservasSolicitadas.remove(reserva);
	}
}










