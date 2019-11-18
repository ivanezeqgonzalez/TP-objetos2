package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.List;

class PropietarioTest {

	private Propietario propietario;
	private Inmueble mockInmueble = mock(Inmueble.class);
	private Sistema mockSistema = mock(Sistema.class);
	
	@BeforeEach
	void setUp() throws Exception {
		this.propietario = new Propietario("nombre_dueño", "email_dueño", "telefono_dueño", null);
						
	}

	@Test
	void testRecibirSolicitudReserva() {

	}
	
	@Test
	void testAceptarReserva() {
		
		
	}	
	
	@Test
	void testGetReservasPendientes() {
		
	}

	@Test
	void testRemoverSolicitudReserva() {
		
	}

}
