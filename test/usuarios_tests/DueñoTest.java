package usuarios_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import inmueble.Inmueble;
import usuario.Dueño;

class DueñoTest {

	private Dueño dueño;
	private Inmueble mockInmueble = mock(Inmueble.class);
	
	@BeforeEach
	void setUp() throws Exception {
		this.dueño = new Dueño ("nombre_dueño", "email_dueño", "telefono_dueño");
						
	}

	@Test
	void testCrearPublicacion() {
		//excercice
		this.dueño.agregarInmueble(mockInmueble);
		
		//asserting
		assertTrue (this.dueño.getInmuebles().contains(mockInmueble));
				
	}

}
