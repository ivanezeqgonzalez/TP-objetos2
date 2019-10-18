package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import exceptions.SinFiltrosObligatoriosException;
import publicacion.Publicacion;
import sistema.Sistema;

public class MotorDeBusquedaTestCase {
	private Sistema sistema;
	private MotorDeBusqueda unBuscador;
	private ArrayList<Filtro> unArrayDeFiltrosBasicos;
	private ArrayList<Filtro> unArrayDeFiltrosNoBasicos;
	private FCiudad unFiltroCiudad;
	private FFecha unFiltroFecha;
	private FPrecioMax unFiltroPrecioMax;
	private FPrecioMin unFiltroPrecioMin;
	private Publicacion unaPublicacion;
	@Before
	public void setUp() throws Exception {
		sistema  = mock(Sistema.class);
		unBuscador = new MotorDeBusqueda(sistema);
		unaPublicacion = mock(Publicacion.class);
		unFiltroCiudad =  mock(FCiudad.class);
		when(unFiltroCiudad.isFilterCiudad()).thenReturn(true);
		unFiltroFecha =  mock(FFecha.class);
		when(unFiltroFecha.isFilterFecha()).thenReturn(true);
		unFiltroPrecioMax =  mock(FPrecioMax.class);
		unFiltroPrecioMin =  mock(FPrecioMin.class);
		unArrayDeFiltrosBasicos = new ArrayList<Filtro>();
		unArrayDeFiltrosBasicos.add(unFiltroCiudad);
		unArrayDeFiltrosBasicos.add(unFiltroFecha);
		unArrayDeFiltrosNoBasicos = new ArrayList<Filtro>();
		unArrayDeFiltrosBasicos.add(unFiltroPrecioMax);
		unArrayDeFiltrosBasicos.add(unFiltroPrecioMin);
		
		
	}

	@Test(expected = SinFiltrosObligatoriosException.class)
	public void testNoSePuedeRealizarBusquedaSinFiltros() throws SinFiltrosObligatoriosException {
	    unBuscador.buscarPublicaciones(new ArrayList<Filtro>());

	}
	@Test(expected = SinFiltrosObligatoriosException.class)
	public void testNoSePuedeRealizarBusquedaSinFiltrosObligatorios() throws SinFiltrosObligatoriosException {
		
	    unBuscador.buscarPublicaciones(unArrayDeFiltrosNoBasicos);

	}
	@Test
	public void testConFiltrosObligatoriosYSinPublicacionesActivas() throws SinFiltrosObligatoriosException {
		when(sistema.getAllPublicaciones()).thenReturn(new ArrayList<Publicacion>());
		
		
		ArrayList<Publicacion> publicaciones = unBuscador.buscarPublicaciones(unArrayDeFiltrosBasicos);
		
		assert(publicaciones.isEmpty());
	}
	@Test
	public void testConFiltrosObligatoriosConUnaPublicacionActivasSinMatch() throws SinFiltrosObligatoriosException {
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(unaPublicacion);
		when(unFiltroCiudad.aplicar(publicaciones)).thenReturn(new ArrayList<Publicacion>());
		when(unFiltroFecha.aplicar(publicaciones)).thenReturn(new ArrayList<Publicacion>());
		when(sistema.getAllPublicaciones()).thenReturn(publicaciones);
		
		
		publicaciones = unBuscador.buscarPublicaciones(unArrayDeFiltrosBasicos);
		
		assert(publicaciones.isEmpty());
	}
	public void testConFiltrosObligatoriosConUnaPublicacionActivasConMatch() {
		fail("Not yet implemented");
	}
	public void testConFiltrosObligatoriosConMultiplesPublicacionActivasSinMatch() {
		fail("Not yet implemented");
	}
	public void testConFiltrosObligatoriosConMultiplesPublicacionActivasConUnMatch() {
		fail("Not yet implemented");
	}
	public void testConFiltrosObligatoriosConMultiplesPublicacionActivasConMultiplesMatchs() {
		fail("Not yet implemented");
	}
}
