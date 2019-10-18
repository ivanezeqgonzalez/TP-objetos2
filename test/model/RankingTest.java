/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interfaces.Rankeable;
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
		
		this.usuario = new Usuario ("nombre_usuario1", "email_usuario1", "tel_usuario1");
		this.inmueble = new Inmueble (null, "pais_inmueble", "ciudad_inmueble", "direccion_inmueble", 0, null); //tipo; desc; cant huespedes; dueño 

		
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
	
	@Test
	void testRankearObjeto() {
		//excercice
		this.usuario.rankear(this.inmueble, 8);
		//asserting
		assertEquals(8, this.inmueble.getRanking());
	}
	
	

}
