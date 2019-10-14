package inmuebles_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmueble.Comentario;
import inmueble.Inmueble;
import servicio.Servicio;

import static org.mockito.Mockito.*;


class InmuebleTest {
	
	private Inmueble inmueble;
	
	//setuping (da fuck?) mock
	
	private Servicio mockServicio1 = mock (Servicio.class);
	private Servicio mockServicio2 = mock (Servicio.class);
	
	private Comentario mockComentario1 = mock (Comentario.class);
	private Comentario mockComentario2 = mock (Comentario.class);
	


	@BeforeEach
	void setUp() throws Exception {
		this.inmueble = new Inmueble ("Cabaña", "Descripcion", 6); //Tipo; Descripcion; Cantidad de huespedes
		
	}

	//tests basicos de creacion
	@Test
	void testCreacion() {
		assertEquals ("Cabaña", this.inmueble.getTipo());
		assertEquals ("Descripcion", this.inmueble.getDescripcion());
		assertEquals (6, this.inmueble.getCantHuespedes());		
		
	}
	
	//tests de contenidos
	@Test
	void testMockServicios() {
		//config
		when(mockServicio1.getNombreServicio()).thenReturn("Cable");
		when(mockServicio1.getDescripcion()).thenReturn("Descripcion1");
		when(mockServicio2.getNombreServicio()).thenReturn("Aire Acondicionado");
		when(mockServicio2.getDescripcion()).thenReturn("Descripcion2");
		
		//exercice
		this.inmueble.agregarServicio(mockServicio1);
		this.inmueble.agregarServicio(mockServicio2);
		
		//verify
		assertTrue (this.inmueble.getServicios().contains(mockServicio1) && this.inmueble.getServicios().contains(mockServicio2));
		
		
		
	}
	
	@Test
	void testMockComentarios() {
		//config
		when(mockComentario1.getNombreUsuario()).thenReturn("nombre_usuario1");
		when(mockComentario2.getNombreUsuario()).thenReturn("nombre_usuario2");
		when(mockComentario1.getComentario()).thenReturn("comentario_usuario1");
		when(mockComentario2.getComentario()).thenReturn("comentario_usuario2");
		
		//exercice
		this.inmueble.agregarComentario(mockComentario1);
		this.inmueble.agregarComentario(mockComentario2);
		
		//asserting
		assertTrue(this.inmueble.getComentarios().contains(mockComentario1) && this.inmueble.getComentarios().contains(mockComentario2));
	}
	
		

}
