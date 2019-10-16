package publicaciones_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmueble.Inmueble;
import inmueble.TipoInmueble;
import usuario.Due�o;

import static org.mockito.Mockito.*;
 

class PublicacionTest {

	private Publicacion publicacion;
	private Inmueble mockInmueble;
	private TipoInmueble mockTipoInmueble;
	private Due�o mockDue�o;
	
	
	@BeforeEach
	void setUp() throws Exception {
		//setup
		this.mockDue�o = mock(Due�o.class);
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
