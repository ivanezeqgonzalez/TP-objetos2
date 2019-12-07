package model;

import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InquilinoTest {

	
	Inquilino inquilino;
	Sistema mockSistema;
	@BeforeEach
	void setUp() throws Exception {
		this.mockSistema = mock(Sistema.class);
		this.inquilino = new Inquilino("nombre_inquilino", "mail_inquilino", "", this.mockSistema);
	}

	@Test
	void testSolicitudReservasActivas() {
		this.inquilino.getReservasActivas();
		verify(this.mockSistema).getReservasActivasDe(this.inquilino);		
	}
	
	@Test
	void testSolicitudReservasPendientes() {
		this.inquilino.getReservasPendientes();
		verify(this.mockSistema).getReservasPendientesDe(this.inquilino);	
	}

}
