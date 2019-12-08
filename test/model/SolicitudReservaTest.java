package model;

import static org.junit.jupiter.api.Assertions.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class SolicitudReservaTest {
	private DateTime fi, ff;
	private Inquilino unInquilino;
	private Publicacion unaPublicacion;
	private SolicitudReserva unaSolicitud;
	private Propietario unPropietario;
	private Propietario otroPropietario;
	@BeforeEach
	void setUp() throws Exception {
		fi = DateTime.parse("01-02-2019", DateTimeFormat.forPattern("dd-MM-yyyy"));
		ff = DateTime.parse("01-04-2019", DateTimeFormat.forPattern("dd-MM-yyyy"));
		unInquilino = mock(Inquilino.class);
		unaPublicacion = mock(Publicacion.class);
		unPropietario = mock(Propietario.class);
		otroPropietario = mock(Propietario.class);
		unaSolicitud = new SolicitudReserva(unaPublicacion, fi, ff, unInquilino);
	}

	@Test
	void testSigueDisponibleDelegaAPublicacion() {
		when(unaPublicacion.estaDisponibleEnRango(fi,ff)).thenReturn(true);
		assert(unaSolicitud.sigueDisponible());

		when(unaPublicacion.estaDisponibleEnRango(fi,ff)).thenReturn(false);
		assert(!unaSolicitud.sigueDisponible());
	}
	@Test
	void testConcretarReservaDelegaAPublicacion() {
		unaSolicitud.concretarReserva();
		verify(unaPublicacion, times(1)).concretarReserva(unaSolicitud);
	}
	@Test
	void testGetPropietarioDelegaAPublicacion() {
		when(unaPublicacion.getPropietario()).thenReturn(unPropietario);
		assertEquals(unaSolicitud.getPropietario(), unPropietario);

		when(unaPublicacion.getPropietario()).thenReturn(otroPropietario);
		assertEquals(unaSolicitud.getPropietario(), otroPropietario);
	}
	@Test
	void testGettersFecha() {
		assertEquals(fi, unaSolicitud.getFechaInicio());
		assertEquals(ff, unaSolicitud.getFechaFin());
	}
}
