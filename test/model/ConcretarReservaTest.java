package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ConcretarReservaTest {
	/**
	 * Concrecion de reserva
	 * A partir de una publicacion:
	 * Fase1: Inquilino realiza la reserva.
	 * Fase2: Due�o acepta o denega la resserva.
	 * En caso de aceptar:
	 * - Se concreta la reserva.
	 * - Notifica al inquilino.
	 * - Registra en el sistema la reserva
	 */
	private Publicacion unaPublicacion;
	private Inmueble unInmueble;
	private Inquilino unInquilino;
	private Propietario unPropietario;
	private LocalDate checkin;
	private LocalDate checkout;
	private HandlerReserva handlerReserva;
	private TipoInmueble mockTipoInmueble;
	@BeforeEach
	
	void setUp() throws Exception {
		mockTipoInmueble = mock(TipoInmueble.class);
		handlerReserva = new HandlerReserva();
		unInquilino = new Inquilino("Ivan Gonzalez", "email", "15663");
		unPropietario = new Propietario("Roman", "email", "155", handlerReserva);
		unInmueble = new Inmueble(mockTipoInmueble, "Argentina", "Berazategui", "Calle 22", 5, unPropietario);
		
		this.checkin = LocalDate.of(2019,11,03);
		this.checkout = LocalDate.of(2019,11,07);
		
		unaPublicacion = new Publicacion(unPropietario, unInmueble, checkin, checkout, 250.f);
		
		
	}
	
	@Test 
	void testConcretarReserva() {
				
		/** Fase1:
		 * El inquilino realiza la reserva
		 */
		assertTrue(unInquilino.getReservas().size() == 0);
		
		this.unaPublicacion.reservar(handlerReserva, unInquilino, checkin, checkout);

		/**
		 * Fase2:
		 * El due�o acepta la reserva
		 */
		
		List<Reserva> lista = unPropietario.getReservasPendientes();
		unPropietario.aceptarReserva(lista.get(0));
		
		assertTrue(unInquilino.getReservas().size() == 1);
		
	}
}






