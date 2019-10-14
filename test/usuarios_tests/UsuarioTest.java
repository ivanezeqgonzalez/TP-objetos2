package usuarios_tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import usuario.Usuario;

/*
 * Usuario es la superclase cuyas subclases seran inquilino, dueño y (posiblemente) administrador.
 * En este test de unidad se hace el TDD para la clase mencionada. 
 */

class UsuarioTest {

	private Usuario usuario;
	
	//test basico creacion
	@Test
	void testCreacion() {
		this.usuario = new Usuario ("Angelo Padron", "padron891@gmail.com", "42745404");
		
		assertEquals ("Angelo Padron", this.usuario.getNombreCompleto());
		assertEquals ("padron891@gmail.com", this.usuario.getEMail());
		assertEquals ("42745404", this.usuario.getTelefono());
		
	}

}
