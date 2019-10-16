package interfaces_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import inmueble.Inmueble;
import inmueble.TipoInmueble;
import interfaces.Visualizable;
import usuario.Usuario;

/**
 * 
 * TDD de interface Visualizar, al cual implementan Usuario y Inmueble (hasta ahora)
 *
 */

class VisualizarTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	
	private Visualizable inmueble, dueño;

	private TipoInmueble mockTipoInmueble = mock(TipoInmueble.class);
		
	@BeforeEach
	void setUp() throws Exception {
		
		//setup de stream

		System.setOut(new PrintStream(outContent));
		
		//config
		when(this.mockTipoInmueble.getNombre()).thenReturn("tipo_inmueble");
		when(this.mockTipoInmueble.getDescripcion()).thenReturn("desc_inmueble");
		
	
		this.dueño = new Usuario("nombre_usuario", "email_usuario", "telefono_usuario");		
		this.inmueble = new Inmueble(mockTipoInmueble, "pais_inmueble", "ciudad_inmueble", "direccion_inmueble", 0, null);
		
	}
	
	@After
	public void restaurarStream() {
	    System.setOut(originalOut);
	}

	@Test
	// flujo propuesto: inmueble ejecutara su implementacion de visualizar, luego inmueble ejecutara la implementacion de usuario.
	
	void testVisualizar(){
	    	this.dueño.visualizarDatos();
			assertTrue(outContent.toString().contains("nombre_usuario"));
			
			this.inmueble.visualizarDatos();
			assertTrue(outContent.toString().contains("tipo_inmueble"));
	}

}
