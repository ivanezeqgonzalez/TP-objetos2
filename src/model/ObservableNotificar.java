package model;

public interface ObservableNotificar {
	/**
	 * observable tiene que notificar a un Observer.
	 * el Observer depende de que el Observable lo notifique de algo.
	 * @param reserva
	 */
	
	// notificar al Dueño(Observer) que se solicito una reserva
	// Inquilino(Observable) solicita una reserva.
	//public void notificarReservaSolicitada(Reserva reserva); 
	public void notificarReservaSolicitada();
	
	//notificar al inquilino(Observer) que se acepto la reserva. Notif> observable
	public void notificarReservaConcretada(Reserva reserva);
}
