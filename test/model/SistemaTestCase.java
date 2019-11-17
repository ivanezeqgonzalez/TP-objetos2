package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.joda.time.DateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTestCase {

	private Sistema unSistemaNuevo;
	private Inmueble unInmueble;
	private Propietario unPropietario;
	@BeforeEach
	void setUp() throws Exception {
		unSistemaNuevo = new Sistema();
		unInmueble = mock(Inmueble.class);
		unPropietario = mock(Propietario.class);
	}

	@Test
	void testEnSistemaRecienCreadoNoCuentaConPublicaciones() {
		assert(unSistemaNuevo.getAllPublicaciones().isEmpty());
	}
	@Test
	void testAlPublicarAumentaEnUnoLaCantidadDePublicaciones() {
		unSistemaNuevo.publicar(unPropietario, unInmueble, LocalDate.parse("2019-01-01"), LocalDate.parse("2020-01-20"), 5);

		assertEquals(unSistemaNuevo.getAllPublicaciones().size(), 1);
	}
	@Test
	void testAlPublicarSeteaCorrectamenteLosDatos( ) {
		unSistemaNuevo.publicar(unPropietario, unInmueble, LocalDate.parse("2019-01-01"), LocalDate.parse("2020-01-20"), 5);
		
		assertEquals(unSistemaNuevo.getAllPublicaciones().size(), 1);

		Publicacion publicacion = unSistemaNuevo.getAllPublicaciones().get(0);
		assertEquals(unPropietario, publicacion.getPropietario());
		assertEquals(unInmueble, publicacion.getInmueble());
		assertEquals(5, publicacion.getPrecio());
	}
	
	
}
