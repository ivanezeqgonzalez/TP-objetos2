package busqueda;

import model.Publicacion;

public class FHuesped extends Filtro {

	private int cantidad;

	public FHuesped(int cant) {
		this.cantidad = cant;
	}

	@Override
	public boolean aplicar(Publicacion unaPublicacion) {
		return unaPublicacion.getHuespedes() == this.cantidad;
	}

}
