package model;

import static org.junit.jupiter.api.Assertions.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


class PublicacionTest {

	private Publicacion publicacion;
	private Inmueble mockInmueble;
	private DateTime fecha_inicio_1, fecha_inicio_2, fecha_fin_1, fecha_fin_2;
	private Propietario unPropietario;
	private HandlerReserva handlerReserva;
	private SolicitudReserva unaSolicitudReserva;
	private Inquilino unInquilino;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.mockInmueble = mock (Inmueble.class);
		
		this.handlerReserva = mock(HandlerReserva.class);
		
		this.unPropietario = mock(Propietario.class);
		
		this.fecha_inicio_1 = DateTime.parse("01-02-2019", DateTimeFormat.forPattern("dd-MM-yyyy"));
		this.fecha_inicio_2 = DateTime.parse("01-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy"));
		this.fecha_fin_1 = DateTime.parse("15-02-2019", DateTimeFormat.forPattern("dd-MM-yyyy"));
		this.fecha_fin_2 = DateTime.parse("15-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy"));
		unaSolicitudReserva = mock(SolicitudReserva.class);
		unInquilino = mock(Inquilino.class);
		publicacion = new Publicacion(mockInmueble, fecha_inicio_1, fecha_fin_1, 1200f);
	}

	@Test
	void testCreacion() {
		when(mockInmueble.getPropietario()).thenReturn(unPropietario);
		this.publicacion = new Publicacion(mockInmueble, fecha_inicio_1, fecha_fin_1, 1200f);
		
		assertEquals(unPropietario, this.publicacion.getPropietario());
		assertEquals(mockInmueble, this.publicacion.getInmueble());
		assertEquals(1200f, this.publicacion.getPrecio());
		
		
	}
	@Test
	void testEstaDisponibleEnRangoDelegaResponsabilidadAlAdminDeFechas() {
		publicacion = new Publicacion(mockInmueble, fecha_inicio_1, fecha_fin_1, 1200f);
		publicacion.setHandlerReserva(handlerReserva);
		assertFalse(publicacion.estaDisponibleEnRango(fecha_inicio_2, fecha_fin_2));
	
	}
	@Test
	void testGetCiudadDelegaAInmueble() {
		publicacion.getCiudad();
		verify(mockInmueble, times(1)).getCiudad();
	}
	@Test
	void testGetHuespedesDelegaAInmueble() {
		publicacion.getHuespedes();
		verify(mockInmueble, times(1)).getCantHuespedes();
	}
	@Test
	void testEsActivaComienzaEnTrue() {
		assert(publicacion.esActiva());
	}
	
	@Test
	void testConcretarReservaRetornaUnaReservaYCambiaEstado() {
		when(unaSolicitudReserva.getFechaInicio()).thenReturn(fecha_inicio_1);
		when(unaSolicitudReserva.getFechaFin()).thenReturn(fecha_fin_1);
		when(unaSolicitudReserva.getInquilino()).thenReturn(unInquilino);
		Reserva unaReserva = publicacion.concretarReserva(unaSolicitudReserva);
		assertEquals(unaReserva.getInquilino(), unInquilino);
		assertEquals(unaReserva.getInmueble(), mockInmueble);
		assertEquals(unaReserva.getCheckin(), fecha_inicio_1 );
		assertEquals(unaReserva.getCheckout(), fecha_fin_1);
	}

	
}
