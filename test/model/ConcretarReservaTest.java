package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConcretarReservaTest {
	
	private Publicacion unaPublicacion;
	private Inmueble unInmueble;
	private Inquilino unInquilino;
	private Propietario unPropietario;
	private DateTime checkin, checkout;
	private HandlerReserva handlerReserva;
	private TipoInmueble mockTipoInmueble;
	private Sistema mockSistema;
	private SolicitudReserva unaSolicitud;
	
	@BeforeEach
	
	void setUp() throws Exception {
		mockTipoInmueble = mock(TipoInmueble.class);
		mockSistema = mock(Sistema.class);
		handlerReserva = new HandlerReserva();
		
		unInquilino = new Inquilino("Ivan Gonzalez", "email", 15663, mockSistema);
		unPropietario = new Propietario("Roman", "email", 155, mockSistema);
		unInmueble = new Inmueble(mockTipoInmueble, "Argentina", "Berazategui", "Calle 22", 5, unPropietario);
		
		this.checkin = DateTime.parse("03-11-2019", DateTimeFormat.forPattern("dd-MM-yyyy"));
		this.checkout = DateTime.parse("07-11-2019", DateTimeFormat.forPattern("dd-MM-yyyy"));
		
		unaPublicacion = new Publicacion(unInmueble, checkin, checkout, 250.f);
		unaPublicacion.setHandlerReserva(handlerReserva);
		
		unaSolicitud = mock(SolicitudReserva.class);
		
	}
	
	@Test 
	void testConcretarReserva() {
		
		//Reserva pendiente
		unaPublicacion.reservar(unInquilino, checkin, checkout);
		List<SolicitudReserva> resultadoFiltro = handlerReserva.getSolicitudesPendientes().stream().
				filter(r -> r.getInquilino() == unInquilino).collect(Collectors.toList());
		
		assertEquals(1, resultadoFiltro.size());
		
		//Reserva concretada
		assertTrue(handlerReserva.getReservasActivas().isEmpty());
		
		SolicitudReserva solicitud = resultadoFiltro.get(0);
		unPropietario.aceptarSolicitud(solicitud);
		verify(mockSistema).concretarReserva(solicitud, unPropietario);
	}
	
	@Test
	void testAceptarSolicitudReservaDisponible() {
		SolicitudReserva mockSolicitud = mock(SolicitudReserva.class);
		when(mockSolicitud.sigueDisponible()).thenReturn(true);
		handlerReserva.concretarSolicitud(mockSolicitud);
		assertEquals(1, handlerReserva.getReservasActivas().size());
	}
	@Test
	void testAceptarSolicitudReservaNoDisponible() {
		SolicitudReserva mockSolicitud = mock(SolicitudReserva.class);
		when(mockSolicitud.sigueDisponible()).thenReturn(false);
		handlerReserva.concretarSolicitud(mockSolicitud);
		assertEquals(0, handlerReserva.getReservasActivas().size());
	}
	
	@Test
	void testRemoverReserva() {
		ArrayList<SolicitudReserva> solicitudes = new ArrayList<SolicitudReserva>();
		solicitudes.add(unaSolicitud);
		handlerReserva.setSolicitudes(solicitudes);
		assertEquals(1, handlerReserva.getSolicitudesPendientes().size());
		handlerReserva.descartarSolicitud(unaSolicitud);
		assertEquals(0, handlerReserva.getSolicitudesPendientes().size());
	}
}






