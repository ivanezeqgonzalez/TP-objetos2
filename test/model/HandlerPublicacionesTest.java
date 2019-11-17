package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HandlerPublicacionesTest {

	private HandlerPublicacion handlerPublicacion;
	private Inmueble unInmueble;
	private Propietario unPropietario;
	private HandlerReserva handlerReserva;
	 
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.handlerPublicacion = new HandlerPublicacion();
		this.handlerReserva = mock(HandlerReserva.class);
		this.unInmueble = mock(Inmueble.class);
		this.unPropietario = mock(Propietario.class);
		
	}

	@Test
	void testHandlerSinPublicaciones() {
		//asserting
		assertTrue(this.handlerPublicacion.getPublicaciones().isEmpty());
	
	}
	@Test
	void testHandlerConPublicaciones() {
		//excercice
		this.handlerPublicacion.crearPublicacion(handlerReserva, unPropietario, unInmueble, DateTime.parse("01-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy")), 
				DateTime.parse("20-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy")), 5);
		//asserting
		assertEquals(1, this.handlerPublicacion.getPublicaciones().size());
	}

}
