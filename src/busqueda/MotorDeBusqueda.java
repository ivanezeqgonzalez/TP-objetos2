package busqueda;

import java.util.ArrayList;
import java.util.stream.Collectors;

import exceptions.SinFiltrosObligatoriosException;
import model.Publicacion;

public class MotorDeBusqueda {
	
	public MotorDeBusqueda() {
		
	}
	public ArrayList<Publicacion> buscarPublicaciones(ArrayList<Publicacion> publicaciones, ArrayList<Filtro> filtros) throws SinFiltrosObligatoriosException {
		this.verificarFiltrosObligatorios(filtros);
		return publicaciones.stream().filter(publicacion -> this.publicacionPasaFiltros(filtros, publicacion)).collect(Collectors.toCollection(ArrayList::new));
	}
	
	private boolean publicacionPasaFiltros(ArrayList<Filtro> filtros, Publicacion unaPublicacion) {
		boolean pasa = true;
		for (int i = 0; filtros.size() > i; i++ ) {
			pasa = pasa && filtros.get(i).aplicar(unaPublicacion);
		}	
		return pasa;
	}
	
	public void verificarFiltrosObligatorios(ArrayList<Filtro> filtros) throws SinFiltrosObligatoriosException {
		if (filtros.isEmpty() || !this.verifyFilterFecha(filtros) || !this.verifyFilterCiudad(filtros)) {
			throw new SinFiltrosObligatoriosException("Sin Filtros Obligatorios");
		}
	}
	public boolean verifyFilterFecha(ArrayList<Filtro> filtros) {
		return filtros.stream().filter(filtro -> filtro.isFilterFecha()).collect(Collectors.toCollection(ArrayList::new)).size() > 0;
	}
	public boolean verifyFilterCiudad(ArrayList<Filtro> filtros) {
		return filtros.stream().filter(filtro -> filtro.isFilterCiudad()).collect(Collectors.toCollection(ArrayList::new)).size() > 0;
	}

}
