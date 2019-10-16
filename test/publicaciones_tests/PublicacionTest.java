package publicaciones_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmueble.Inmueble;
import inmueble.TipoInmueble;
import usuario.Dueño;

import static org.mockito.Mockito.*;
 

class PublicacionTest {

	private Publicacion publicacion;
	private Inmueble mockInmueble;
	private TipoInmueble mockTipoInmueble;
	private Dueño mockDueño;
	
	
	@BeforeEach
	void setUp() throws Exception {
		//setup
		this.mockDueño = mock(Dueño.class);
		this.mockInmueble = mock (Inmueble.class);
		this.mockTipoInmueble = mock(TipoInmueble.class);
		
		//config
		when(mockInmueble.getTipo()).
		
	}

	@Test
	void testCreacion() {
		this.publicacion = new Publicacion(mockInmueble, mockUsuario, 1200f);
		
	}

}
