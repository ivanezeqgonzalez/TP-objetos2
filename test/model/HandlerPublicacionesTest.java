package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HandlerPublicacionesTest {

	private HandlerPublicacion handler;
	private Inmueble unInmueble;
	private Propietario unPropietario;
	 
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.handler = new HandlerPublicacion();
		this.unInmueble = mock(Inmueble.class);
		this.unPropietario = mock(Propietario.class);
		
	}

	@Test
	void testHandlerSinPublicaciones() {
		//asserting
		assertTrue(this.handler.getPublicaciones().isEmpty());
	
	}
	@Test
	void testHandlerConPublicaciones() {
		//excercice
		this.handler.crearPublicacion(unPropietario, unInmueble, LocalDate.parse("2019-01-01"), LocalDate.parse("2020-01-20"), 5);
		//asserting
		assertEquals(1, this.handler.getPublicaciones().size());
	}

}
