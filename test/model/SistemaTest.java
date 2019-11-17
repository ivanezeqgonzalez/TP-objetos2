package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {

	private Sistema unSistemaNuevo;
	private Inmueble unInmueble;
	private Propietario unPropietario;
	private TipoInmueble unTipoInmueble;
	
	@BeforeEach
	void setUp() throws Exception {
		unSistemaNuevo = new Sistema();
		unInmueble = mock(Inmueble.class);
		unPropietario = mock(Propietario.class);
		unTipoInmueble = mock(TipoInmueble.class);
	}

	@Test
	void testEnSistemaRecienCreadoNoCuentaConPublicaciones() {
		assertTrue(unSistemaNuevo.getAllPublicaciones().isEmpty());
	}
	
	@Test
	void testEnSistemaRecienCreadoNoCuentaConInmuebles() {
		assertTrue(unSistemaNuevo.getInmuebles().isEmpty());
	}
	
	@Test
	void testAlPublicarAumentaEnUnoLaCantidadDePublicaciones() {
		unSistemaNuevo.publicar(unPropietario, unInmueble, DateTime.parse("01-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy")), 
				DateTime.parse("20-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy")), 5f);

		assertEquals(unSistemaNuevo.getAllPublicaciones().size(), 1);
	}
	
	@Test
	void testAlCrearInmuebleAumentaEnUnoLaCantidadDeInmuebles() {
		//excercice
		this.unSistemaNuevo.crearInmueble(unTipoInmueble, "pais", "ciudad", "direccion", 1, unPropietario);
		//asserting
		assertFalse(this.unSistemaNuevo.getInmuebles().isEmpty());
	}
	
	void testAlPublicarSeteaCorrectamenteLosDatos( ) {
		unSistemaNuevo.publicar(unPropietario, unInmueble, DateTime.parse("01-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy")), 
				DateTime.parse("20-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy")), 5f);
		
		assertEquals(unSistemaNuevo.getAllPublicaciones().size(), 1);

		Publicacion publicacion = unSistemaNuevo.getAllPublicaciones().get(0);
		assertEquals(unPropietario, publicacion.getPropietario());
		assertEquals(unInmueble, publicacion.getInmueble());
		assertEquals(5f, publicacion.getPrecio());
	}

	
}
