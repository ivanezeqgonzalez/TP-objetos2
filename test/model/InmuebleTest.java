package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


class InmuebleTest {
	
	private Inmueble inmueble;
	
	//setup
	
	private Servicio mockServicio1 = mock (Servicio.class);
	private Servicio mockServicio2 = mock (Servicio.class);
	
	private Comentario mockComentario1 = mock (Comentario.class);
	private Comentario mockComentario2 = mock (Comentario.class);
	
	private Propietario mockPropietario = mock (Propietario.class);
	
	private TipoInmueble mockTipoInmueble = mock (TipoInmueble.class);

	@BeforeEach
	void setUp() throws Exception {
		this.inmueble = new Inmueble (mockTipoInmueble, "pais_inmueble", "ciudad_inmueble", "direccion_inmueble", 6, mockPropietario); //Tipo; Cantidad de huespedes; dueño
		
	}

	//tests basicos de creacion
	@Test
	void testCreacion() {
		//config
		when(mockTipoInmueble.getNombre()).thenReturn("tipo_inmueble");
		when(mockTipoInmueble.getDescripcion()).thenReturn("desc_inmueble");
		
		//asserting		
		assertEquals ("tipo_inmueble", this.inmueble.getTipo());
		assertEquals ("desc_inmueble", this.inmueble.getDescripcion());
		assertEquals ("pais_inmueble", this.inmueble.getPais());
		assertEquals("ciudad_inmueble", this.inmueble.getCiudad());
		assertEquals("direccion_inmueble", this.inmueble.getDireccion());
		assertEquals (6, this.inmueble.getCantHuespedes());		
		
	}
	
	//tests de contenidos
	@Test
	void testMockServicios() {
		//config
		when(mockServicio1.getNombreServicio()).thenReturn("nombre_servicio1");
		when(mockServicio1.getDescripcion()).thenReturn("desc_servicio1");
		when(mockServicio2.getNombreServicio()).thenReturn("nombre_servicio2");
		when(mockServicio2.getDescripcion()).thenReturn("desc_servicio2");
		
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
	
	@Test
	void testMockDueño() {
		//config
		when(mockPropietario.getNombreCompleto()).thenReturn("nombre_usuario1");
		
		//asserting
		assertEquals("nombre_usuario1", this.inmueble.getDueño().getNombreCompleto());
	}
	
		

}
