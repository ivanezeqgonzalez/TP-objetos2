package usuario;

import iRanking.Rankeable;

/**
 * 
 */

/**
 * @author Angelo Padron
 *
 */
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
	
	
}
