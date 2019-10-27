package busqueda;

import org.joda.time.DateTime;

import model.Publicacion;

public class FFecha extends Filtro {
	
	private DateTime fecha_fin;
	private DateTime fecha_inicio;

	public FFecha(DateTime fecha_inicio2, DateTime fecha_fin2) {
		this.fecha_inicio = fecha_inicio2;
		this.fecha_fin = fecha_fin2;
	}
	public boolean isFilterFecha() {
		return true;
	}
	@Override
	public boolean aplicar(Publicacion unaPublicacion) {
		return unaPublicacion.estaDisponibleEnRango(this.fecha_inicio, this.fecha_fin);

	}

}
