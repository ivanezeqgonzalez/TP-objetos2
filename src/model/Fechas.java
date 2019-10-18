package model;

import org.joda.time.DateTime;
import org.joda.time.Interval;


/*
 * simplemente verifica si dos rangos de fechas se sobreponen
 */

public class Fechas {

	public static boolean verificar(DateTime fechaInicio1, DateTime fechaFin1, DateTime fechaInicio2,
			DateTime fechaFin2) {
		
		Interval rangoCheckInOut1 = new Interval (fechaInicio1, fechaFin1);
		Interval rangoCheckOut2 = new Interval (fechaInicio2, fechaFin2);
		
		
		return (rangoCheckInOut1.overlaps(rangoCheckOut2));
	}
	
	

}
