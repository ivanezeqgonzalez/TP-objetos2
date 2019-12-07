package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * 
 * Los test que solamente tienen una llamada a un método.
 * Son testeados en sus clases correspondientes.
 * 
 * */
class SistemaTest {

	private Sistema unSistemaNuevo;
	private Inmueble unInmueble;
	private Propietario unPropietario;
	private Inquilino unInquilino;
	private Reserva unaReserva;
	
	@BeforeEach
	void setUp() throws Exception {
		unSistemaNuevo = new Sistema();
		unInmueble = mock(Inmueble.class);
		unPropietario = mock(Propietario.class);
		unInquilino = mock(Inquilino.class);
		unaReserva = mock(Reserva.class);
		
		Mockito.when(unaReserva.getInquilino()).thenReturn(unInquilino);
		Mockito.when(unaReserva.getPropietario()).thenReturn(unPropietario);

		
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
		this.unSistemaNuevo.crearInmueble(unInmueble, unPropietario);
		//asserting
		assertFalse(this.unSistemaNuevo.getInmuebles().isEmpty());
	}
	
	@Test
	void testAlPublicarSeteaCorrectamenteLosDatos( ) {
		unSistemaNuevo.publicar(unPropietario, unInmueble, DateTime.parse("01-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy")), 
				DateTime.parse("20-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy")), 5f);
		
		assertEquals(unSistemaNuevo.getAllPublicaciones().size(), 1);

		Publicacion publicacion = unSistemaNuevo.getAllPublicaciones().get(0);
		assertEquals(unPropietario, publicacion.getPropietario());
		assertEquals(unInmueble, publicacion.getInmueble());
		assertEquals(5f, publicacion.getPrecio());
	}
	
	@Test
	void testPeticionReserva() {
		assertTrue(unSistemaNuevo.getReservasPendientes().isEmpty());
		unSistemaNuevo.peticionReserva(unaReserva);
		assertEquals(1, unSistemaNuevo.getReservasPendientes().size());
	}
	
	
	@Test
	void testGetReservasActivasYRegistrarReservaDe() {
		assertTrue(unSistemaNuevo.getReservasActivas().isEmpty());
		unSistemaNuevo.peticionReserva(unaReserva);
		when(unaReserva.esActiva()).thenReturn(true);
		unSistemaNuevo.registrarReservaDe(unaReserva, unPropietario);
		
		assertEquals(1, unSistemaNuevo.getReservasActivas().size());
		assertFalse(unSistemaNuevo.getReservasActivas().isEmpty());
	}
	
	@Test
	void testGetPublicacionesDePropietario() {
		unSistemaNuevo.getPublicacionesDe(unPropietario);
	}
	
	@Test
	void testGetReservasActivasDe() {
		assertTrue(unSistemaNuevo.getReservasActivasDe(unInquilino).isEmpty());
	}
	
	@Test 
	void testDescartarSolicitud() {
		unSistemaNuevo.descartarSolicitud(unaReserva);
	}
	
	@Test
	void testGetInmuebles() {
		assertTrue(unSistemaNuevo.getInmuebles().isEmpty());
	}
	
	@Test
	void testGetInmueblesDePropietario() {
		assertTrue(unSistemaNuevo.getInmuebles(unPropietario).isEmpty());
	}
	
	@Test
	void testGetReservasPendientesDeInquilino() {
		unSistemaNuevo.getReservasPendientesDe(unInquilino);
	}
}
