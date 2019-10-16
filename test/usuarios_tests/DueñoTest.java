package usuarios_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import inmueble.Inmueble;
import usuario.Due�o;

class Due�oTest {

	private Due�o due�o;
	private Inmueble mockInmueble = mock(Inmueble.class);
	
	@BeforeEach
	void setUp() throws Exception {
		this.due�o = new Due�o ("nombre_due�o", "email_due�o", "telefono_due�o");
						
	}

	@Test
	void testCrearPublicacion() {
		//excercice
		this.due�o.agregarInmueble(mockInmueble);
		
		//asserting
		assertTrue (this.due�o.getInmuebles().contains(mockInmueble));
				
	}

}
