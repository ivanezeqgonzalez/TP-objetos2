package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {
	private Inmueble unInmueble;
	private Inquilino unInquilino;
	private Propietario unPropietario;
	private Reserva reserva;
	private LocalDate checkin;
	private LocalDate checkout;

	@BeforeEach
	void setUp() throws Exception {

		//this.unInquilino = mock(Inquilino.class);
		//this.unInmueble = mock(Inmueble.class);
		this.unInquilino = new Inquilino("Ivan Gonzalez", "email", "15663");
		this.unPropietario = new Propietario("Roman", "email", "155");
		unInmueble = new Inmueble(this.unPropietario);
		this.checkin = LocalDate.of(2019, 11, 03);
		this.checkout = LocalDate.of(2019, 11, 07);
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
}
