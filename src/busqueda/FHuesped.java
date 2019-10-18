package busqueda;

import java.util.ArrayList;
import java.util.stream.Collectors;

import publicacion.Publicacion;

public class FHuesped extends Filtro {

	private int cantidad;

	public FHuesped(int cant) {
		this.cantidad = cant;
	}

	@Override
	public ArrayList<Publicacion> aplicar(ArrayList<Publicacion> publicaciones) {
		//return publicaciones;
		return publicaciones.stream().filter(publicacion -> publicacion.getHuespedes() >= this.cantidad).collect(Collectors.toCollection(ArrayList::new));
	}

}
