package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
	void testCargarReservaGeneral() {
		
		assertTrue(unSistemaNuevo.getReservasPendientes().isEmpty());
		unSistemaNuevo.cargarSolicutudReserva(unaReserva);
		assertFalse(unSistemaNuevo.getReservasPendientes().isEmpty());
		
		assertTrue(unSistemaNuevo.getReservasActivas().isEmpty());
		unSistemaNuevo.registrarReservaDe(unaReserva);
		assertFalse(unSistemaNuevo.getReservasActivas().isEmpty());
		
	}
	
	@Test
	void testCargarReservaGeneralEspecifico() {
		
		unSistemaNuevo.cargarSolicutudReserva(unaReserva);
	
		assertFalse(unSistemaNuevo.getReservasPendientesDe(unInquilino).isEmpty());
		assertFalse(unSistemaNuevo.getReservasPendientesDe(unPropietario).isEmpty());
		
		unSistemaNuevo.registrarReservaDe(unaReserva);
		assertFalse(unSistemaNuevo.getReservasActivasDe(unInquilino).isEmpty());
	}
	
	@Test 
	void testDescartarSolicitudPendiente(){
		unSistemaNuevo.cargarSolicutudReserva(unaReserva);
		assertFalse(unSistemaNuevo.getReservasPendientes().isEmpty());
		
		unSistemaNuevo.descartarSolicitud(unaReserva);
		assertTrue(unSistemaNuevo.getReservasPendientes().isEmpty());
	}
	
	

	
}
