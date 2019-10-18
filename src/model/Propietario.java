package model;
import java.util.*;

public class Propietario implements ObservablePropietario{

	private List<Inmueble> inmuebles = new ArrayList<Inmueble>();
	private String nombreCompleto;
	private String eMail;
	private String telefeno;
	private ArrayList<Reserva> reservasSolicitadas = new ArrayList<Reserva>();
	//private ArrayList<NotificacionReserva> observers = new ArrayList<NotificacionReserva>();
	private HandlerReserva handlerReserva;
	
	
	public Propietario(String nombreCompleto, String eMail, String telefono, HandlerReserva hr) {
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
		System.out.println("Aceptando reserva");
		//observers.forEach(mt -> mt.notificarReservaAceptada(reserva));
		
		/*for(NotificacionReserva nt : observers) {
			nt.notificarReservaAceptada(reserva);
			System.out.println("Despues de nt");
		}*/
		//NO DEBERIA TENER PROBLEMA
		//this.removerSolicitudReserva(reserva);
		this.handlerReserva.registrarReserva(reserva);
		
	}

	public ArrayList<Reserva> getReservasSolicitadas() {
		System.out.println("get reservas solicitadas"+ reservasSolicitadas.size());
		return this.reservasSolicitadas;
	}


	public void recibirSolicitudReserva(Reserva reserva) {
		this.reservasSolicitadas.add(reserva);
	}
	
	public void removerSolicitudReserva(Reserva reserva) {
		this.reservasSolicitadas.remove(reserva);
	}

	/*public void addObserver(NotificacionReserva notificacionReserva) {
		this.observers.add(notificacionReserva);
		
	}
	
	public void removeObserver(NotificacionReserva notificacionReserva) {
		this.observers.remove(notificacionReserva);
		
	}*/

}










