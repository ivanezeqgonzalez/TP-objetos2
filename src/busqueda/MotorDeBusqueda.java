package busqueda;

import java.util.ArrayList;
import java.util.stream.Collectors;

import exceptions.SinFiltrosObligatoriosException;
import publicacion.Publicacion;
import sistema.Sistema;

public class MotorDeBusqueda {
	private Sistema sistema;
	public MotorDeBusqueda(Sistema sistema) {
		this.sistema = sistema;
	}
	public ArrayList<Publicacion> buscarPublicaciones(ArrayList<Filtro> filtros) throws SinFiltrosObligatoriosException {

		this.verificarFiltrosObligatorios(filtros);
		
		ArrayList<Publicacion> publicaciones = sistema.getAllPublicaciones();
		filtros.forEach(filtro -> {
			filtro.aplicar(publicaciones);
		});
		return publicaciones;
	}
	private void verificarFiltrosObligatorios(ArrayList<Filtro> filtros) throws SinFiltrosObligatoriosException {
		if (filtros.isEmpty() || !this.verifyFilterFecha(filtros) || !this.verifyFilterCiudad(filtros)) {
			throw new SinFiltrosObligatoriosException("Sin Filtros Obligatorios");
		}
	}
	private boolean verifyFilterFecha(ArrayList<Filtro> filtros) {
		return filtros.stream().filter(filtro -> filtro.isFilterFecha()).collect(Collectors.toCollection(ArrayList::new)).size() > 0;
	}
	private boolean verifyFilterCiudad(ArrayList<Filtro> filtros) {
		return filtros.stream().filter(filtro -> filtro.isFilterCiudad()).collect(Collectors.toCollection(ArrayList::new)).size() > 0;
	}

}
