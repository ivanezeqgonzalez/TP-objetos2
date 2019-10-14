package comentarios_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmueble.Comentario;
import usuario.Usuario;

import static org.mockito.Mockito.*;

class ComentarioTest {
	
	private Comentario comentario;
	private Usuario mockUsuario;
	

	@BeforeEach
	void setUp() throws Exception {
		//setup
		this.mockUsuario = mock(Usuario.class);
		
		//config
		when(mockUsuario.getNombreCompleto()).thenReturn("nombre_usuario");
		
	}

	@Test
	void testCreacion() {
		//excercice
		this.comentario = new Comentario (mockUsuario, "comentario_inmueble");
		
		//asserting
		assertEquals("nombre_usuario", this.comentario.getNombreUsuario());
		assertEquals("comentario_inmueble", this.comentario.getComentario());
		
	}

}
