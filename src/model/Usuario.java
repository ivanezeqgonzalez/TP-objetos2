package model;

public class Usuario implements Rankeable{

	protected String nombreCompleto;
	protected String eMail;
	protected String telefono;
	protected int ranking;
	
	public Usuario(String nombreCompleto, String eMail, String telefono) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.eMail = eMail;
		this.telefono = telefono;
		this.ranking = 0;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public String getEMail() {
		return eMail;
	}

	public String getTelefono() {
		return telefono;
	}

	@Override
	public void rankearse(int puntaje) {
		// TODO Auto-generated method stub
		this.ranking = puntaje;
		
	}

	@Override
	public int getRanking() {
		// TODO Auto-generated method stub
		return ranking;
	}

	@Override
	public void rankear(Rankeable rankeable, int rank) {
		// TODO Auto-generated method stub
		rankeable.rankearse(rank);
		
	}
	
}
