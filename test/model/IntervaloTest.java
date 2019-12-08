package model;

import static org.junit.jupiter.api.Assertions.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntervaloTest {
	private DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");	
	private DateTime fecha1;
	private DateTime fecha2;
	private DateTime fecha3;
	private DateTime fecha4;
	private DateTime fecha5;
	private DateTime fecha6;
	private Intervalo unIntervaloMultiple;
	
	@BeforeEach
	void setUp() throws Exception {
		fecha1 = formatter.parseDateTime("01-01-2020");
		fecha2 = formatter.parseDateTime("15-01-2020");
		fecha3 = formatter.parseDateTime("20-01-2020");
		fecha6 = formatter.parseDateTime("22-01-2020");
		fecha4 = formatter.parseDateTime("30-01-2020");
		fecha5 = formatter.parseDateTime("15-02-2020");
		unIntervaloMultiple = new Intervalo(fecha2, fecha4);
	}

	@Test
	void testAlCrearUnIntervaloMultipleSoloCuentaConUnIntervalo() {
		
		assertEquals(unIntervaloMultiple.getIntervalos().size(), 1);
		assertEquals(unIntervaloMultiple.getIntervalos().get(0).getStart(), fecha2);
		assertEquals(unIntervaloMultiple.getIntervalos().get(0).getEnd(), fecha4);		
	}
	@Test
	void testEstaDisponibleConIntervalosIguales() {
		assert(unIntervaloMultiple.estaDisponible(fecha2, fecha4));
	}
	@Test
	void testNoEstaDisponibleConIntervaloPosterior() {
		assert(!unIntervaloMultiple.estaDisponible(fecha2, fecha5));
	}
	@Test
	void testNoEstaDisponibleConIntervaloAnterior() {
		assert(!unIntervaloMultiple.estaDisponible(fecha1, fecha3));
	}
	@Test
	void testEstaDisponibleConIntervaloContenido() {
		assert(unIntervaloMultiple.estaDisponible(fecha2, fecha3));
		assert(unIntervaloMultiple.estaDisponible(fecha3, fecha4));
	}
	@Test
	void testRestarIntervaloConTotalDeIntervalo() {
		unIntervaloMultiple.restarIntervalo(fecha2, fecha4);
		
		assertEquals(unIntervaloMultiple.getIntervalos().size(), 0);
	}
	@Test
	void testRestarIntervaloConRestoPosterior() {
		unIntervaloMultiple.restarIntervalo(fecha2, fecha3);
		
		assertEquals(unIntervaloMultiple.getIntervalos().size(), 1);
		assertEquals(unIntervaloMultiple.getIntervalos().get(0).getStart(), fecha3.plusDays(1));
		assertEquals(unIntervaloMultiple.getIntervalos().get(0).getEnd(), fecha4);		

	}
	@Test
	void testRestarIntervaloConRestoAnterior() {
		unIntervaloMultiple.restarIntervalo(fecha3, fecha4);
		
		assertEquals(unIntervaloMultiple.getIntervalos().size(), 1);

		assertEquals(unIntervaloMultiple.getIntervalos().get(0).getStart(), fecha2);
		assertEquals(unIntervaloMultiple.getIntervalos().get(0).getEnd(), fecha3.minusDays(1));	
	}
	@Test
	void testRestarIntervaloConRestoAnteriorYPosterior() {
		unIntervaloMultiple.restarIntervalo(fecha3, fecha6);

		assertEquals(unIntervaloMultiple.getIntervalos().size(), 2);
		assertEquals(unIntervaloMultiple.getIntervalos().get(0).getStart(), fecha2);
		assertEquals(unIntervaloMultiple.getIntervalos().get(0).getEnd(), fecha3.minusDays(1));	
		assertEquals(unIntervaloMultiple.getIntervalos().get(1).getStart(), fecha6.plusDays(1));
		assertEquals(unIntervaloMultiple.getIntervalos().get(1).getEnd(), fecha4);	

	}
	@Test
	void testVerifyActConIntervalos() {
		assert(unIntervaloMultiple.verifyAct());
	}
	@Test
	void testVerifyActSinIntervalos() {
		unIntervaloMultiple.restarIntervalo(fecha2, fecha4);
		assert(!unIntervaloMultiple.verifyAct());
	}

}
