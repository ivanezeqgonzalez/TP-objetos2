package model;

import static org.junit.jupiter.api.Assertions.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

 

class PublicacionTest {

	private Publicacion publicacion;
	private Inmueble mockInmueble;
	private DateTime fecha_inicio_1, fecha_inicio_2, fecha_fin_1, fecha_fin_2;
	private Propietario unPropietario;
	private HandlerReserva handlerReserva;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.mockInmueble = mock (Inmueble.class);
		
		this.handlerReserva = mock(HandlerReserva.class);
		
		this.unPropietario = mock(Propietario.class);
		
		this.fecha_inicio_1 = DateTime.parse("01-02-2019", DateTimeFormat.forPattern("dd-MM-yyyy"));
		this.fecha_inicio_2 = DateTime.parse("01-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy"));
		this.fecha_fin_1 = DateTime.parse("15-02-2019", DateTimeFormat.forPattern("dd-MM-yyyy"));
		this.fecha_fin_2 = DateTime.parse("15-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy"));
		
	}

	@Test
	void testCreacion() {
		this.publicacion = new Publicacion(handlerReserva, unPropietario, mockInmueble, fecha_inicio_1, fecha_fin_1, 1200f);
		
		assertEquals(unPropietario, this.publicacion.getPropietario());
		assertEquals(mockInmueble, this.publicacion.getInmueble());
		assertEquals(1200f, this.publicacion.getPrecio());
		
		
	}
	@Test
	void estaDisponibleEnRangoDelegaResponsabilidadAlAdminDeFechas() {
		publicacion = new Publicacion(handlerReserva, unPropietario, mockInmueble, fecha_inicio_1, fecha_fin_1, 1200f);
		assertFalse(publicacion.estaDisponibleEnRango(fecha_inicio_2, fecha_fin_2));
	
	}
	
	
	
}
