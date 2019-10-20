package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
 

class PublicacionTest {

	private Publicacion publicacion;
	private Inmueble mockInmueble;
	private Usuario mockUsuario;
	
	@BeforeEach
	void setUp() throws Exception {
		//setup
		this.mockUsuario = mock(Usuario.class);
		this.mockInmueble = mock (Inmueble.class);
		
		//config
		
		
	}

	@Test
	void testCreacion() {
		this.publicacion = new Publicacion(mockInmueble, LocalDate.of(2019, 8, 25), LocalDate.of(2019, 11, 25), 1200f);
		
	}

}
