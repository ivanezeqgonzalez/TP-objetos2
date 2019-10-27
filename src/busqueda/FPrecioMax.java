package busqueda;

public class FPrecioMax extends FPrecio {

	public FPrecioMax(double i) {
		this.precio = i;
	}

	@Override
	public Boolean matchPrecio(double p) {
		return p <= this.precio;
	}

}
