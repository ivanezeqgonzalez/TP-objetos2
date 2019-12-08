package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HandlerPublicacionesTest {

	private HandlerPublicacion handlerPublicacion;
	private Inmueble unInmueble;
	private Publicacion unaPublicacion;
	private Publicacion otraPublicacion;
	 
	
	@BeforeEach
	void setUp() throws Exception {
		
		handlerPublicacion = new HandlerPublicacion();
		unInmueble = mock(Inmueble.class);
		unaPublicacion = mock(Publicacion.class);
		otraPublicacion = mock(Publicacion.class);
		
	}

	@Test
	void testHandlerSinPublicaciones() {
		//asserting
		assertTrue(this.handlerPublicacion.getPublicaciones().isEmpty());
	
	}
	@Test
	void testHandlerConPublicaciones() {
		//excercice
		this.handlerPublicacion.crearPublicacion(unInmueble, DateTime.parse("01-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy")), 
				DateTime.parse("20-01-2019", DateTimeFormat.forPattern("dd-MM-yyyy")), 5);
		//asserting
		assertEquals(1, this.handlerPublicacion.getPublicaciones().size());
	}
	@Test
	void testGetPublicacionesActivasFiltraCorrectamente() {
		List<Publicacion> allPublicaciones = new ArrayList<Publicacion>();
		when(unaPublicacion.esActiva()).thenReturn(true);
		when(otraPublicacion.esActiva()).thenReturn(false);
		allPublicaciones.add(unaPublicacion);
		allPublicaciones.add(otraPublicacion);
		handlerPublicacion.setPublicaciones(allPublicaciones);

		
		List<Publicacion> publicaciones = handlerPublicacion.getPublicacionesActivas();

		assert(publicaciones.contains(unaPublicacion));
		assert(!publicaciones.contains(otraPublicacion));
	}
	
}
