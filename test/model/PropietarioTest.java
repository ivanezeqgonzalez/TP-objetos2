package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

class PropietarioTest {

	private Propietario propietario;
	private Sistema mockSistema = mock(Sistema.class);
	private SolicitudReserva unaSolicitud = mock(SolicitudReserva.class);
	
	@BeforeEach
	void setUp() throws Exception {
		this.propietario = new Propietario("nombre_dueño", "email_dueño", 4227123, mockSistema);
						
	}

	@Test
	void testAceptarReserva() {
		propietario.aceptarSolicitud(unaSolicitud);
		verify(mockSistema).concretarReserva(unaSolicitud, this.propietario);
	}	
	
	@Test
	void testGetReservasPendientes() {
		ArrayList<Reserva> listaVaciaReservas = new ArrayList<Reserva>();
		assertEquals(listaVaciaReservas, propietario.getSolicitudesPendientes());
	}

	@Test
	void testRemoverSolicitudReserva() {
		propietario.removerSolicitudReserva(unaSolicitud);
		verify(mockSistema).descartarSolicitud(unaSolicitud);
	}

}
