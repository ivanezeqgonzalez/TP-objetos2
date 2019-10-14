/**
 * 
 */
package ranking_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iRanking.Rankeable;
import inmueble.Inmueble;
import usuario.Usuario;


/**
 * @author Angelo Padron
 *
 */
class RankingTest {

	private Rankeable usuario;
	private Rankeable inmueble;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.usuario = new Usuario ("Angelo Padron", "padron891@gmail.com", "42745404");
		this.inmueble = new Inmueble ("Casa", "Descripcion", 6); //tipo; desc; cant huespedes
		
	}

	@Test
	void testRankingUsuario() {
		//excercice
		this.usuario.rankearse(10);		
		//asserting
		assertEquals(10, this.usuario.getRanking());
	}
	
	@Test
	void testRankingInmueble() {
		//excercice
		this.inmueble.rankearse(5);
		assertEquals(5, this.inmueble.getRanking());
	}

}
