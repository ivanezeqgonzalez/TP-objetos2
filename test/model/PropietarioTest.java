package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class PropietarioTest {

	private Propietario propietario;
	private Inmueble mockInmueble = mock(Inmueble.class);
	
	@BeforeEach
	void setUp() throws Exception {
		this.propietario = new Propietario("nombre_due�o", "email_due�o", "telefono_due�o", new HandlerReserva());
						
	}

	@Test
	void testCrearPublicacion() {
		//excercice
		this.propietario.agregarInmueble(mockInmueble);
		
		//asserting
		assertTrue(this.propietario.getInmuebles().contains(mockInmueble));
				
	}

}
