package busqueda;

public class FPrecioMin extends FPrecio {

	public FPrecioMin(double i) {
		this.precio = i;
	}

	@Override
	public Boolean matchPrecio(double p) {
		return p >= this.precio;
	}

}
