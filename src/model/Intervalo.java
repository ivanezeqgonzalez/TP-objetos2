package model;

import java.awt.List;
import java.util.*;
import org.joda.time.DateTime;
import org.joda.time.Interval;

public class Intervalo {
	private ArrayList<Interval> intervalos;

	Intervalo(DateTime fecha_inicio, DateTime fecha_fin) {
		this.intervalos = new ArrayList<Interval>();
		this.intervalos.add(new Interval (fecha_inicio, fecha_fin));
	}
	public boolean estaDisponible(DateTime fecha_inicio, DateTime fecha_fin) {
		Interval intervalo = new Interval(fecha_inicio, fecha_fin);
		
		for(int i=0; i< this.intervalos.size(); i++) {
			
        	if(this.intervalos.get(i).contains(intervalo)) {
    			
        		return true;
        	}
        }
       return false;
	}
	// precondicion: se tiene que haber llamado a esta disponible ante
	public void restarIntervalo(DateTime fecha_inicio, DateTime fecha_fin) {
		Interval intervalo = new Interval(fecha_inicio, fecha_fin);
		for(int i=0; i< this.intervalos.size(); i++) {
			Interval intervaloDisponible = this.intervalos.get(i);
			if(intervaloDisponible.overlaps(intervalo)) {
				// 2 casos en los que tengo que agregar intervalos
				// La fecha de inicio del intervalo a borrar es posterio a la del intervalo disponibl
				if(intervaloDisponible.getStart().isBefore(intervalo.getStart())) {
					this.intervalos.add(new Interval(intervaloDisponible.getStart(), intervalo.getStart().minusDays(1)));
				}
				// La fecha de fin del intervalo a borrar es anterio a la del intervalo disponible
				if(intervaloDisponible.getEnd().isAfter(intervalo.getEnd())) {
					this.intervalos.add(new Interval(intervalo.getEnd().plusDays(1), intervaloDisponible.getEnd()));
				}
				this.intervalos.remove(i);
				break;
			}
		}
		
	}
	public ArrayList<Interval> getIntervalos() {
		// TODO Auto-generated method stub
		return this.intervalos;
	}
}
