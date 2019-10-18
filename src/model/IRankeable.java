package model;
import java.util.*;

public interface IRankeable {
	public Map<String, Integer> calificaciones = new HashMap<String, Integer>();
	
	public void recibirCalificaciones(String categoria, int puntuacion);
}
