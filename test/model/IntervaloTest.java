package model;

import static org.junit.jupiter.api.Assertions.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import consultas.Fechas;

class IntervaloTest {
	
	/*
	 * TDD para analisis de intervalos de fechas
	 * 
	 */

	private DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");	
	
	private DateTime fechaInicio1;
	private DateTime fechaFin1;
	
	private DateTime fechaInicio2;
	private DateTime fechaFin2;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//setup
		
				
	}

	@Test
	void testFechasSePisan() {
		//excercice
		this.fechaInicio1 = formatter.parseDateTime("01-01-2020");
		this.fechaFin1 = formatter.parseDateTime("15-01-2020");
		
		this.fechaInicio2 = formatter.parseDateTime("07-01-2020");
		this.fechaFin2 = formatter.parseDateTime("15-01-2020");
		
		//asserting
		assertTrue(Fechas.verificar(fechaInicio1, fechaFin1, fechaInicio2, fechaFin2));
	}
	
	@Test
	void testFechasNoSePisan() {
		//excercice
		this.fechaInicio1 = formatter.parseDateTime("01-01-2020");
		this.fechaFin1 = formatter.parseDateTime("15-01-2020");
		
		this.fechaInicio2 = formatter.parseDateTime("16-01-2020");
		this.fechaFin2 = formatter.parseDateTime("30-01-2020");
		
		//asserting
		assertFalse(Fechas.verificar(fechaInicio1, fechaFin1, fechaInicio2, fechaFin2)); 
		
	}

}
