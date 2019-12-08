package model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InquilinoTest {
	private Sistema unSistema;
	private Inquilino unInquilino;
	@BeforeEach
	void setUp() throws Exception {
		unSistema = mock(Sistema.class);
		unInquilino = new Inquilino("unNombre", "unMail", 42066703, unSistema);
	}

	@Test
	void testGetReservasActivas() {
		assertEquals(0, unInquilino.getReservasActivas().size());
	}
	@Test
	void testgetReservasPendientesDelegaAsistema() {
		unInquilino.getReservasPendientes();
		verify(unSistema, times(1)).getSolicitudesPendientesDe(unInquilino);
	}

}
