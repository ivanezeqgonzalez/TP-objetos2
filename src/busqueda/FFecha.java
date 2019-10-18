package busqueda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import publicacion.Publicacion;

public class FFecha extends Filtro {
	
	private LocalDate fecha_fin;
	private LocalDate fecha_inicio;

	public FFecha(LocalDate fecha_inicio, LocalDate fecha_fin) {
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}
	public boolean isFilterFecha() {
		return true;
	}
	@Override
	public ArrayList<Publicacion> aplicar(ArrayList<Publicacion> publicaciones) {
		return publicaciones.stream().filter(publicacion -> publicacion.estaDisponibleEnRango(this.fecha_inicio, this.fecha_fin)).collect(Collectors.toCollection(ArrayList::new));

	}

}
