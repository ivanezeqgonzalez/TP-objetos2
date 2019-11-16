/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RankingTest {

	private Rankeable usuario;
	private Rankeable inmueble;
	
	@BeforeEach
	void setUp() throws Exception {
		this.usuario = new Usuario ("nombre_usuario1", "email_usuario1", "tel_usuario1");
		this.inmueble = new Inmueble (null, "pais_inmueble", "ciudad_inmueble", "direccion_inmueble", 0, null); //tipo; desc; cant huespedes; dueño 
	}

	@Test
	void testRankingUsuario() {
		//una vez
		//excercice
		this.usuario.rankearse(10);		
		
		//asserting
		assertEquals(10, this.usuario.getRanking());
		
		//n veces (promediable)
		this.usuario.rankearse(6);
		assertEquals(8, this.usuario.getRanking());
	}
	
	@Test
	void testRankingInmueble() {
		//una vez
		//excercice
		this.inmueble.rankearse(10);		
				
		//asserting
		assertEquals(10, this.inmueble.getRanking());
				
		//n veces (promediable)
		this.inmueble.rankearse(6);
		assertEquals(8, this.inmueble.getRanking());
	}
	
	@Test
	void testRankearObjeto() {
		//excercice
		this.usuario.rankear(this.inmueble, 8);
		//asserting
		assertEquals(8, this.inmueble.getRanking());
	}
}
