package inmueble;

import usuario.Usuario;

public class Comentario {
	
	private String nombreUsuario;
	private String comentario;

	public Comentario(Usuario usuario, String comentario) {
		super();
		this.nombreUsuario = usuario.getNombreCompleto();
		this.comentario = comentario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getComentario() {
		return comentario;
	}
	
	
	
	

}
