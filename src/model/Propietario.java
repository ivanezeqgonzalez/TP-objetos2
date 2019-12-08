package model;
import java.util.*;

public class Propietario extends Usuario{

	
	public Propietario(String nombreCompleto, String eMail, int telefono, Sistema sistema) {
		super(nombreCompleto, eMail, telefono, sistema);
	}


	
	//RESERVAS
	
	public void aceptarSolicitud(SolicitudReserva solicitud) {
		this.sistema.concretarReserva(solicitud, this);		
	}	
	
	public List<SolicitudReserva> getSolicitudesPendientes() {
		return this.sistema.getSolicitudesPendientesDe(this);
	}

	public void removerSolicitudReserva(SolicitudReserva solicitud) {
		this.sistema.descartarSolicitud(solicitud);
	}
}










