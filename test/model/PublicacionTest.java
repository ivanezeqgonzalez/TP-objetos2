package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
 

class PublicacionTest {

	private Publicacion publicacion;
	private Inmueble mockInmueble;
	private LocalDate fecha_inicio_1, fecha_inicio_2, fecha_fin_1, fecha_fin_2;
	private Propietario unPropietario;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.mockInmueble = mock (Inmueble.class);
		
		this.unPropietario = mock(Propietario.class);
		
		this.fecha_inicio_1 = LocalDate.parse("2019-01-01");
		this.fecha_inicio_2 = LocalDate.parse("2019-01-01");
		this.fecha_fin_1 = LocalDate.parse("2019-01-15");
		this.fecha_fin_2 = LocalDate.parse("2019-01-15");
		
	}

	@Test
	void testCreacion() {
		this.publicacion = new Publicacion(unPropietario, mockInmueble, fecha_inicio_1, fecha_fin_1, 1200f);
		
		assertEquals(unPropietario, this.publicacion.getPropietario());
		assertEquals(mockInmueble, this.publicacion.getInmueble());
		assertEquals(1200f, this.publicacion.getPrecio());
		
		
	}
	@Test
	void estaDisponibleEnRangoDelegaResponsabilidadAlAdminDeFechas() {
		publicacion = new Publicacion(unPropietario, mockInmueble, fecha_inicio_1, fecha_fin_1, 1200f);
		assertFalse(publicacion.estaDisponibleEnRango(fecha_inicio_2, fecha_fin_2));
	
	}
	
	
	
}
