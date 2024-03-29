package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;


class HandlerInmuebleTest {

	private HandlerInmueble handler;
	private Inmueble mockInmueble ;
	private Propietario mockPropietario;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.handler = new HandlerInmueble();
		this.mockInmueble = mock(Inmueble.class);
		this.mockPropietario = mock(Propietario.class);
	}
	
	@Test
	void testGetInmueblesPropietario() {
		assertEquals(0, handler.getInmueblesPropietario(mockPropietario).size());
		handler.setInmueblePropietario(mockInmueble, mockPropietario);
		assertEquals(1, handler.getInmueblesPropietario(mockPropietario).size());
	}

	@Test
	void testSetInmueblePropietario() {
		assertEquals(0, handler.getInmueblesPropietario(mockPropietario).size());
		handler.setInmueblePropietario(mockInmueble, mockPropietario);
		assertEquals(1, handler.getInmueblesPropietario(mockPropietario).size());
	}
}

