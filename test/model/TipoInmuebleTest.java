package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TipoInmuebleTest {

	@Test
	void test() {
		TipoInmueble tipo = new TipoInmueble ("tipo_inmueble", "desc_inmueble");
		assertEquals("tipo_inmueble", tipo.getNombre());
		assertEquals("desc_inmueble", tipo.getDescripcion()); 
		
	}

}
