package busqueda;

import model.Publicacion;

public abstract class Filtro {

	public  abstract boolean aplicar(Publicacion unaPublicacion);
	
	public boolean isFilterFecha() {
		return false;
	}
	public boolean isFilterCiudad() {
		return false;
	}
}
