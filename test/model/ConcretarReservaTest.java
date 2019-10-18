package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ConcretarReservaTest {
	/**
	 * Concrecion de reserva
	 * A partir de una publicacion:
	 * Fase1: Inquilino realiza la reserva.
	 * Fase2: Dueño acepta o denega la resserva.
	 * En caso de aceptar:
	 * - Se concreta la reserva.
	 * - Notifica al inquilino.
	 * - Registra en el sistema la reserva
	 */
	private Publicacion unaPublicacion;
	private Inmueble unInmueble;
	private Inquilino unInquilino;
	//private Reserva reserva;
	private Propietario unPropietario;
	//private NotificacionReserva notificacionReserva;
	private LocalDate checkin;
	private LocalDate checkout;
	private HandlerReserva handlerReserva;
	
	@BeforeEach
	void setUp() throws Exception {
		handlerReserva = new HandlerReserva();
		unInquilino = new Inquilino("Ivan Gonzalez", "email", "15663");
		unPropietario = new Propietario("Roman", "email", "155", handlerReserva);
		unInmueble = new Inmueble(unPropietario);
		unaPublicacion = new Publicacion(unInmueble, LocalDate.of(2019,11,01), LocalDate.of(2019,12,25), 250.f);
		
		this.checkin = LocalDate.of(2019,11,03);
		this.checkout = LocalDate.of(2019,11,07);
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
		 * El dueño acepta la reserva
		 */
		System.out.println("reserva solicitadas" + unPropietario.getReservasSolicitadas().size());
		
		List<Reserva> lista = unPropietario.getReservasSolicitadas();
		unPropietario.aceptarReserva(lista.get(0));
		
		/*for(Reserva r : lista){
			unPropietario.aceptarReserva(r);
		}
				*/
		assertTrue(unInquilino.getReservas().size() == 1);
		
	}
}






