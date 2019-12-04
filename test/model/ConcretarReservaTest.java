package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConcretarReservaTest {
	
	private Publicacion unaPublicacion;
	private Inmueble unInmueble;
	private Inquilino unInquilino;
	private Propietario unPropietario;
	private DateTime checkin, checkout;
	private HandlerReserva handlerReserva;
	private TipoInmueble mockTipoInmueble;
	private Sistema mockSistema;
	
	@BeforeEach
	
	void setUp() throws Exception {
		mockTipoInmueble = mock(TipoInmueble.class);
		mockSistema = mock(Sistema.class);
		handlerReserva = new HandlerReserva();
		
		unInquilino = new Inquilino("Ivan Gonzalez", "email", "15663", mockSistema);
		unPropietario = new Propietario("Roman", "email", "155", mockSistema);
		unInmueble = new Inmueble(mockTipoInmueble, "Argentina", "Berazategui", "Calle 22", 5, unPropietario);
		
		this.checkin = DateTime.parse("03-11-2019", DateTimeFormat.forPattern("dd-MM-yyyy"));
		this.checkout = DateTime.parse("07-11-2019", DateTimeFormat.forPattern("dd-MM-yyyy"));
		
		unaPublicacion = new Publicacion(handlerReserva, unPropietario, unInmueble, checkin, checkout, 250.f);
		
		
	}
	
	@Test 
	void testConcretarReserva() {
		
		//Reserva pendiente
		unaPublicacion.reservar(unInquilino, checkin, checkout);
		List<Reserva> resultadoFiltro = handlerReserva.getReservasPendientes().stream().
				filter(r -> r.getInquilino() == unInquilino).collect(Collectors.toList());
		
		assertEquals(1, resultadoFiltro.size());
		
		//Reserva concretada
		assertTrue(handlerReserva.getReservasActivas().isEmpty());
		
		Reserva reservaPendiente = resultadoFiltro.get(0);
		unPropietario.aceptarReserva(reservaPendiente);
		verify(mockSistema).registrarReservaDe(reservaPendiente, unPropietario);
	}
	
	
}






