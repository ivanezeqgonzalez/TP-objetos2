package model;

public interface ObservableNotificar {
	public void notificarReservaSolicitada();
	
	public void notificarReservaConcretada(Reserva reserva);
}
