package model;

public class Usuario implements Rankeable{

	protected Sistema sistema;
	protected String nombreCompleto;
	protected String eMail;
	protected int telefono;
	protected int ranking;
	protected int count;
	
	public Usuario(String nombreCompleto, String eMail, int telefono, Sistema sistema) {
		this.sistema = sistema;
		this.nombreCompleto = nombreCompleto;
		this.eMail = eMail;
		this.telefono = telefono;
		this.ranking = 0;
		this.count = 0;
	}

	//GETTERS
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public String getEMail() {
		return eMail;
	}
	public int getTelefono() {
		return telefono;
	}

	//RANKINGS
	@Override
	public void rankearse(int puntaje) {
		this.ranking += puntaje;
		this.count++;		
	}

	@Override
	public int getRanking() {
		if (this.count > 0) {
			return this.ranking / this.count;
		}
		
		return ranking;
	}

	@Override
	public void rankear(Rankeable rankeable, int rank) {
		rankeable.rankearse(rank);
		
	}
}
