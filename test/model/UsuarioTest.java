package model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UsuarioTest {

	private Usuario usuario;
	
	@Test
	void testCreacion() {
		this.usuario = new Usuario ("Angelo Padron", "padron891@gmail.com", 42745404, null);
		
		assertEquals ("Angelo Padron", this.usuario.getNombreCompleto());
		assertEquals ("padron891@gmail.com", this.usuario.getEMail());
		assertEquals (42745404, this.usuario.getTelefono());
		
	}

}
