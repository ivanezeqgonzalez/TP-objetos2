package model;

public interface ObserverInquilino {
	/**
	 * observable tiene que notificar a un Observer.
	 * el Observer depende de que el Observable lo notifique de algo.
	 * @param reserva
	 */
	
	// actualizar a Inquilino(Observer) cuando el dueño(Observable) acepte la reserva
	//  
	public void agregarReservaAceptada(Reserva reserva);
}
