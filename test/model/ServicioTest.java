package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import servicio.Servicio;

class ServicioTest {
	
	private Servicio servicio;

	@Test
	void test() {
		this.servicio = new Servicio ("Cable", "Descripcion");
		assertEquals ("Cable", this.servicio.getNombreServicio());
		assertEquals ("Descripcion", this.servicio.getDescripcion());
		
		
	}

}
