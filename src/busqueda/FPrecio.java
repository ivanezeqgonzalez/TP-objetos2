package busqueda;

import java.util.ArrayList;
import java.util.stream.Collectors;

import publicacion.Publicacion;

public abstract class FPrecio extends Filtro {

	protected double precio;
	@Override
	public ArrayList<Publicacion> aplicar(ArrayList<Publicacion> publicaciones) {
		return publicaciones.stream().filter(publicacion -> this.matchPrecio(publicacion.getPrecio())).collect(Collectors.toCollection(ArrayList::new));
	}

	public abstract Boolean matchPrecio(double precio);
	
}
