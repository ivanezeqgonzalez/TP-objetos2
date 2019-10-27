package busqueda;

import model.Publicacion;

public class FCiudad extends Filtro {
	private String ciudad;
	public FCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public boolean isFilterCiudad() {
		return true;
	}
	@Override
	public boolean aplicar(Publicacion unaPublicacion) {
		return this.ciudad.equalsIgnoreCase(unaPublicacion.getCiudad());
	}

}
