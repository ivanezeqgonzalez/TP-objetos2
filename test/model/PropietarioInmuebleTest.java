package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PropietarioInmuebleTest {
	private Propietario unPropietario; 
	private Inmueble unInmueble;
	private PropietarioInmueble propietarioInmueble;

	@BeforeEach
	void setUp() throws Exception {
		unPropietario = mock(Propietario.class);
		unInmueble = mock(Inmueble.class);
		propietarioInmueble = new PropietarioInmueble();
	}

	@Test
	void testGetInmueblesPropietario() {
		assertEquals(0, propietarioInmueble.getInmueblesPropietario(unPropietario).size());
		propietarioInmueble.setInmueblePropietario(unPropietario, unInmueble);
		assertEquals(1, propietarioInmueble.getInmueblesPropietario(unPropietario).size());
	}

	@Test
	void testSetInmueblePropietario() {
		assertEquals(0, propietarioInmueble.getInmueblesPropietario(unPropietario).size());
		propietarioInmueble.setInmueblePropietario(unPropietario, unInmueble);
		assertEquals(1, propietarioInmueble.getInmueblesPropietario(unPropietario).size());
	}

}
