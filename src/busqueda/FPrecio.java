package busqueda;

import model.Publicacion;

public abstract class FPrecio extends Filtro {

	protected double precio;
	@Override
	public boolean aplicar(Publicacion unaPublicacion) {
		return this.matchPrecio(unaPublicacion.getPrecio());
	}

	public abstract Boolean matchPrecio(double precio);
	
}
