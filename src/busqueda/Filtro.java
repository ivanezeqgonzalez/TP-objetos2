package busqueda;

import java.util.ArrayList;

import publicacion.Publicacion;

public abstract class Filtro {

	public abstract  ArrayList<Publicacion> aplicar(ArrayList<Publicacion> publicaciones);

	public boolean isFilterFecha() {
		return false;
	}
	public boolean isFilterCiudad() {
		return false;
	}
}
