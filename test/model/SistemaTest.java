package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import busqueda.FCiudad;
import busqueda.FFecha;
import busqueda.Filtro;
import busqueda.MotorDeBusqueda;
import exceptions.SinFiltrosObligatoriosException;

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
	private Propietario otroPropietario;
	private Inquilino unInquilino;
	private Inquilino otroInquilino;
	private Reserva unaReserva;
	private Reserva otraReserva;
	private MotorDeBusqueda unBuscador;
	private FCiudad unFiltroCiudad;
	private FFecha unFiltroFecha;
	private ArrayList<Filtro> unArrayDeFiltrosBasicos;
	private HandlerReserva unHandlerReserva;
	private HandlerPublicacion unHandlerPublicacion;
	private Publicacion unaPublicacion;
	private Publicacion otraPublicacion;
	private SolicitudReserva unaSolicitudReserva;
	private SolicitudReserva otraSolicitudReserva;
	@BeforeEach
	void setUp() throws Exception {
		unaPublicacion = mock(Publicacion.class);
		otraPublicacion = mock(Publicacion.class);
		unSistemaNuevo = new Sistema();
		unInmueble = mock(Inmueble.class);
		unBuscador = mock(MotorDeBusqueda.class);
		unPropietario = mock(Propietario.class);
		otroPropietario = mock(Propietario.class);
		unInquilino = mock(Inquilino.class);
		otroInquilino = mock(Inquilino.class);
		unaReserva = mock(Reserva.class);
		otraReserva = mock(Reserva.class);
		unSistemaNuevo.setBuscador(unBuscador);
		unFiltroCiudad =  mock(FCiudad.class);
		unFiltroFecha =  mock(FFecha.class);
		unArrayDeFiltrosBasicos = new ArrayList<Filtro>();
		unArrayDeFiltrosBasicos.add(unFiltroCiudad);
		unArrayDeFiltrosBasicos.add(unFiltroFecha);
		unHandlerReserva = mock(HandlerReserva.class);
		unHandlerPublicacion = mock(HandlerPublicacion.class);
		unaSolicitudReserva = mock(SolicitudReserva.class);
		otraSolicitudReserva = mock(SolicitudReserva.class);
		
		unSistemaNuevo.setHandlerReserva(unHandlerReserva);
		unSistemaNuevo.setHandlerPublicacion(unHandlerPublicacion);
		Mockito.when(unaReserva.getInquilino()).thenReturn(unInquilino);
		Mockito.when(unaReserva.getPropietario()).thenReturn(unPropietario);

		
	}
	
	@Test
	void testAlCrearInmuebleAumentaEnUnoLaCantidadDeInmuebles() {
		//excercice
		this.unSistemaNuevo.crearInmueble(unInmueble, unPropietario);
		//asserting
		assertFalse(this.unSistemaNuevo.getInmuebles().isEmpty());
	}

	@Test
	void testGetReservasActivasDe() {
		assertTrue(unSistemaNuevo.getReservasActivasDe(unInquilino).isEmpty());
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
	void testBuscarPublicacionDelegaResponsabilidadAlMotorDeBusqueda () throws SinFiltrosObligatoriosException {
		when(unBuscador.buscarPublicaciones(unArrayDeFiltrosBasicos)).thenReturn( new ArrayList<Publicacion>());
		unSistemaNuevo.buscarPublicaciones(unArrayDeFiltrosBasicos);
		verify(unBuscador).buscarPublicaciones(unArrayDeFiltrosBasicos);
	}
	@Test
	void testRegistarReservaDeConPropietariosDistintos() {
		List<SolicitudReserva> unArrayDeSolicitudes = new ArrayList<SolicitudReserva>();
		unArrayDeSolicitudes.add(unaSolicitudReserva);
		when(unaSolicitudReserva.getPropietario()).thenReturn(otroPropietario);
		when(unHandlerReserva.getSolicitudesPendientes()).thenReturn(unArrayDeSolicitudes);
		unSistemaNuevo.concretarReserva(unaSolicitudReserva, unPropietario);
		
		verify(unHandlerReserva, never()).concretarSolicitud(unaSolicitudReserva);
	}
	@Test
	void testRegistrarReservaDeConPropietariosIgualeYReservaPendienteEnListado() {
		List<SolicitudReserva> unArrayDeSolicitudes = new ArrayList<SolicitudReserva>();
		unArrayDeSolicitudes.add(unaSolicitudReserva);
		when(unaSolicitudReserva.getPropietario()).thenReturn(unPropietario);
		when(unHandlerReserva.getSolicitudesPendientes()).thenReturn(unArrayDeSolicitudes);
		unSistemaNuevo.concretarReserva(unaSolicitudReserva, unPropietario);
		
		verify(unHandlerReserva, times(1)).concretarSolicitud(unaSolicitudReserva);	
	}
	@Test
	void testRegistrarReservaDeConPropietariosIgualeYReservaPendienteNoEnListado() {
		List<SolicitudReserva> unArrayDeSolicitudes = new ArrayList<SolicitudReserva>();
		when(unaSolicitudReserva.getPropietario()).thenReturn(unPropietario);
		when(unHandlerReserva.getSolicitudesPendientes()).thenReturn(unArrayDeSolicitudes);
		unSistemaNuevo.concretarReserva(unaSolicitudReserva, unPropietario);
		
		verify(unHandlerReserva, never()).concretarSolicitud(unaSolicitudReserva);	
	}
	//@Test
	//void testPeticionReservaDelegaAHandlerReserva() {
	//	unSistemaNuevo.peticionReserva(unaReserva);
	//	verify(unHandlerReserva, times(1)).peticionReserva(unaReserva);
	//}
	@Test
	void testGetReservasActivasDelegaAHandlerReserva() {
		unSistemaNuevo.getReservasActivas();
		verify(unHandlerReserva, times(1)).getReservasActivas();
	}
	@Test
	void testGetSolicitudesPendientesDelegaAHandlerReserva() {
		unSistemaNuevo.getSolicitudesPendientes();
		verify(unHandlerReserva, times(1)).getSolicitudesPendientes();
	}
	@Test
	void testGetPublicacionesDeFiltraCorrectamente() {
		ArrayList<Publicacion> unArrayDePublicaciones = new ArrayList<Publicacion>();
		unArrayDePublicaciones.add(unaPublicacion);
		unArrayDePublicaciones.add(otraPublicacion);
		
		when(unaPublicacion.getPropietario()).thenReturn(unPropietario);
		when(otraPublicacion.getPropietario()).thenReturn(otroPropietario);
		when(unHandlerPublicacion.getPublicaciones()).thenReturn(unArrayDePublicaciones);
		
		List<Publicacion> rows = unSistemaNuevo.getPublicacionesDe(unPropietario);
		
		assert(rows.contains(unaPublicacion));
		assert(!rows.contains(otraPublicacion));
	}
	@Test
	void testGetAllPublicacionesDelegaAlHandlerDePublicaciones() {
		unSistemaNuevo.getAllPublicaciones();
		verify(unHandlerPublicacion, times(1)).getPublicaciones();
	}
	@Test
	void testGetAllPublicacionesActivasDelegaAlHandlerDePublicaciones() {
		unSistemaNuevo.getPublicacionesActivas();
		verify(unHandlerPublicacion, times(1)).getPublicacionesActivas();
	}
	@Test
	void testPublicarDelegaAlHandlerDePublicaciones() {
		when(unHandlerPublicacion.crearPublicacion(unInmueble,  DateTime.parse("01-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy")),  DateTime.parse("01-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy")), 5f)).thenReturn(unaPublicacion);
		unSistemaNuevo.publicar(unPropietario, unInmueble,  DateTime.parse("01-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy")),  DateTime.parse("01-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy")), 5f);

		verify(unHandlerPublicacion, times(1)).crearPublicacion(unInmueble,  DateTime.parse("01-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy")),  DateTime.parse("01-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy")), 5f);	
		verify(unaPublicacion, times(1)).setHandlerReserva(unHandlerReserva);
	}
	@Test
	void testDescartarSolicitudDelegaAlHandlerDeReserva() {
		unSistemaNuevo.descartarSolicitud(unaSolicitudReserva);
		
		verify(unHandlerReserva, times(1)).descartarSolicitud(unaSolicitudReserva);
	}
	
	@Test
	void testGetReservasPendientesDeInquilinoDelegaLaBusquedaDeReservasPendientesYFiltraCorrectamente() {
		List<SolicitudReserva> allSolicitudes = new ArrayList<SolicitudReserva>();
		allSolicitudes.add(unaSolicitudReserva);
		allSolicitudes.add(otraSolicitudReserva);
		when(unaSolicitudReserva.getInquilino()).thenReturn(unInquilino);
		when(otraSolicitudReserva.getInquilino()).thenReturn(otroInquilino);
		when(unHandlerReserva.getSolicitudesPendientes()).thenReturn(allSolicitudes);
		List<SolicitudReserva> solicitudes = unSistemaNuevo.getSolicitudesPendientesDe(unInquilino);
		verify(unHandlerReserva, times(1)).getSolicitudesPendientes();
		
		assert(solicitudes.contains(unaSolicitudReserva));
		assert(!solicitudes.contains(otraSolicitudReserva));
	}
	@Test
	void testGetReservasPendientesDePropietarioDelegaLaBusquedaDeReservasPendientesYFiltraCorrectamente() {
		List<SolicitudReserva> allSolicitudes = new ArrayList<SolicitudReserva>();
		allSolicitudes.add(unaSolicitudReserva);
		allSolicitudes.add(otraSolicitudReserva);
		when(unaSolicitudReserva.getPropietario()).thenReturn(unPropietario);
		when(otraSolicitudReserva.getPropietario()).thenReturn(otroPropietario);
		when(unHandlerReserva.getSolicitudesPendientes()).thenReturn(allSolicitudes);
		List<SolicitudReserva> solicitudes = unSistemaNuevo.getSolicitudesPendientesDe(unPropietario);
		verify(unHandlerReserva, times(1)).getSolicitudesPendientes();
		
		assert(solicitudes.contains(unaSolicitudReserva));
		assert(!solicitudes.contains(otraSolicitudReserva));
	}
	
	@Test
	void testGetReservasActivasDeInquilinoDelegaLaBusquedaDeReservasActivasYFiltraCorrectamente() {
		List<Reserva> allReservas = new ArrayList<Reserva>();
		allReservas.add(unaReserva);
		allReservas.add(otraReserva);
		when(unaReserva.getInquilino()).thenReturn(unInquilino);
		when(otraReserva.getInquilino()).thenReturn(otroInquilino);
		when(unHandlerReserva.getReservasActivas()).thenReturn(allReservas);
		List<Reserva> reservas = unSistemaNuevo.getReservasActivasDe(unInquilino);
		verify(unHandlerReserva, times(1)).getReservasActivas();
		
		assert(reservas.contains(unaReserva));
		assert(!reservas.contains(otraReserva));
	}
}
