package busqueda;

import java.util.ArrayList;
import java.util.stream.Collectors;

import publicacion.Publicacion;

public class FCiudad extends Filtro {
	private String ciudad;
	public FCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public boolean isFilterCiudad() {
		return true;
	}
	@Override
	public ArrayList<Publicacion> aplicar(ArrayList<Publicacion> publicaciones) {
		return publicaciones.stream().filter(publicacion -> this.ciudad.equalsIgnoreCase(publicacion.getCiudad())).collect(Collectors.toCollection(ArrayList::new));
	}

}
