package busqueda;


import java.time.LocalDate;

import model.Publicacion;

public class FFecha extends Filtro {
	
	private LocalDate fecha_fin, fecha_inicio;
	
	public FFecha(LocalDate fecha_inicio, LocalDate fecha_fin) {
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}
	public boolean isFilterFecha() {
		return true;
	}
	@Override
	public boolean aplicar(Publicacion unaPublicacion) {
		return unaPublicacion.estaDisponibleEnRango(this.fecha_inicio, this.fecha_fin);

	}

}
