package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ConcretarReservaTest {
	/**
	 * Concrecion de reserva
	 * A partir de una publicacion:
	 * Fase1: Inquilino realiza la reserva.
	 * Fase2: Dueï¿½o acepta o denega la resserva.
	 * En caso de aceptar:
	 * - Se concreta la reserva.
	 * - Notifica al inquilino.
	 * - Registra en el sistema la reserva
	 */
	private Publicacion unaPublicacion;
	private Inmueble unInmueble;
	private Inquilino unInquilino;
	private Propietario unPropietario;
	private DateTime checkin, checkout;
	private HandlerReserva handlerReserva;
	private TipoInmueble mockTipoInmueble;
	@BeforeEach
	
	void setUp() throws Exception {
		mockTipoInmueble = mock(TipoInmueble.class);
		handlerReserva = new HandlerReserva();
		unInquilino = new Inquilino("Ivan Gonzalez", "email", "15663", null);
		unPropietario = new Propietario("Roman", "email", "155", null);
		unInmueble = new Inmueble(mockTipoInmueble, "Argentina", "Berazategui", "Calle 22", 5, unPropietario);
		
		this.checkin = DateTime.parse("03-11-2019", DateTimeFormat.forPattern("dd-MM-yyyy"));
		this.checkout = DateTime.parse("07-11-2019", DateTimeFormat.forPattern("dd-MM-yyyy"));
		
		unaPublicacion = new Publicacion(handlerReserva, unPropietario, unInmueble, checkin, checkout, 250.f);
		
		
	}
	
	@Test 
	void testConcretarReserva() {
				
		/** Fase1:
		 * El inquilino realiza la reserva
		 */
		assertTrue(unInquilino.getReservasPendientes().size() == 0);
	}
	
	@Test
	void test() {
		this.unaPublicacion.reservar(unInquilino, checkin, checkout);

		/**
		 * Fase2:
		 * El dueño acepta la reserva
		 */
		
		List<Reserva> lista = unPropietario.getReservasPendientes();
		unPropietario.aceptarReserva(lista.get(0));
		
		assertTrue(unInquilino.getReservasPendientes().size() == 1);
		
	}
}






