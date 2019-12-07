package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {
	private Inmueble unInmueble;
	private Inquilino unInquilino;
	private Propietario unPropietario;
	private Reserva reserva;
	private DateTime checkin, checkout;
	private TipoInmueble mockTipoInmueble;

	@BeforeEach
	void setUp() throws Exception {
		mockTipoInmueble = mock(TipoInmueble.class);
		this.unInquilino = new Inquilino("Ivan Gonzalez", "email", "15663", null);
		this.unPropietario = new Propietario("Roman", "email", "155", null);
		unInmueble = new Inmueble(mockTipoInmueble, "Argentina", "Berazategui", "Calle 22", 5, unPropietario);
		this.checkin = DateTime.parse("01/01/2019", DateTimeFormat.forPattern("dd/MM/yyyy"));
		this.checkout = DateTime.parse("20/01/2019", DateTimeFormat.forPattern("dd/MM/yyyy"));
		this.reserva = new Reserva(this.unInquilino, this.unInmueble, this.checkin, this.checkout);
	}

	@Test
	void getInquilino() {
		assertEquals(unInquilino, this.reserva.getInquilino());
	}

	@Test
	void getInmueble() {
		assertEquals(unInmueble, this.reserva.getInmueble());
	}

	@Test
	void getCheckin() {
		assertEquals(this.checkin, this.reserva.getCheckin());
	}

	@Test
	void getCheckout() {
		assertEquals(this.checkout, this.reserva.getCheckout());
	}
	
	@Test
	void getPropietario() {
		assertEquals(this.unPropietario, this.reserva.getPropietario());
	}
	
	@Test
	void getActiva() {
		assertFalse(this.reserva.esActiva());
	}
}
