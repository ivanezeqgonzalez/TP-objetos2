package publicaciones_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmueble.Inmueble;
import usuario.Usuario;

import static org.mockito.Mockito.*;
 

class PublicacionTest {

	private Publicacion publicacion;
	private Inmueble mockInmueble;
	private Usuario mockUsuario;
	
	@BeforeEach
	void setUp() throws Exception {
		//setup
		this.mockUsuario = mock(Usuario.class);
		this.mockInmueble = mock (Inmueble.class);
		
		//config
		
		
	}

	@Test
	void testCreacion() {
		this.publicacion = new Publicacion(mockInmueble, mockUsuario, 1200f);
		
	}

}
