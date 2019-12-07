package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

class PropietarioTest {

	private Propietario propietario;
	private Inmueble mockInmueble = mock(Inmueble.class);
	private Sistema mockSistema = mock(Sistema.class);
	private Reserva mockReserva = mock(Reserva.class);
	
	@BeforeEach
	void setUp() throws Exception {
		this.propietario = new Propietario("nombre_dueño", "email_dueño", "telefono_dueño", mockSistema);
						
	}

	@Test
	void testAceptarReserva() {
		propietario.aceptarReserva(mockReserva);
		verify(mockSistema).registrarReservaDe(mockReserva, this.propietario);
	}	
	
	@Test
	void testGetReservasPendientes() {
		ArrayList<Reserva> listaVaciaReservas = new ArrayList<Reserva>();
		assertEquals(listaVaciaReservas, propietario.getReservasPendientes());
	}

	@Test
	void testRemoverSolicitudReserva() {
		propietario.removerSolicitudReserva(mockReserva);
		verify(mockSistema).descartarSolicitud(mockReserva);
	}

}
