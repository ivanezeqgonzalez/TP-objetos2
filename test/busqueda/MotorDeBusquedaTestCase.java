package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import exceptions.SinFiltrosObligatoriosException;
import model.Sistema;
import model.Publicacion;

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
	private Publicacion publicacion2;
	private Publicacion publicacion3;
	@Before
	public void setUp() throws Exception {
		sistema  = mock(Sistema.class);
		unBuscador = new MotorDeBusqueda(sistema);
		unaPublicacion = mock(Publicacion.class);
		publicacion2 = mock(Publicacion.class);
		publicacion3 = mock(Publicacion.class);
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
		unArrayDeFiltrosNoBasicos.add(unFiltroPrecioMax);
		unArrayDeFiltrosNoBasicos.add(unFiltroPrecioMin);
	}
	@Test
	public void testNoSePuedeRealizarBusquedaSinFiltros()  {
		try {
			unBuscador.buscarPublicaciones(new ArrayList<Filtro>());
			fail("Se esperaba excepcion SinFiltrosObligatoriosException");
		} catch(SinFiltrosObligatoriosException e) {}
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
		when(unFiltroCiudad.aplicar(unaPublicacion)).thenReturn(true);
		when(unFiltroFecha.aplicar(unaPublicacion)).thenReturn(false);
		when(sistema.getAllPublicaciones()).thenReturn(publicaciones);
		
		
		publicaciones = unBuscador.buscarPublicaciones(unArrayDeFiltrosBasicos);
		
		assert(publicaciones.size() == 0);
	}
	@Test
	public void testConFiltrosObligatoriosConUnaPublicacionActivasConMatch() throws SinFiltrosObligatoriosException {
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(unaPublicacion);
		when(unFiltroCiudad.aplicar(unaPublicacion)).thenReturn(true);
		when(unFiltroFecha.aplicar(unaPublicacion)).thenReturn(true);
		when(sistema.getAllPublicaciones()).thenReturn(publicaciones);
		
		publicaciones = unBuscador.buscarPublicaciones(unArrayDeFiltrosBasicos);
		
		assertEquals(publicaciones.size(), 1);
		assert(publicaciones.contains(unaPublicacion));
	}
	@Test
	public void testConFiltrosObligatoriosConMultiplesPublicacionActivasSinMatch() throws SinFiltrosObligatoriosException {
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(unaPublicacion);
		publicaciones.add(publicacion2);
		publicaciones.add(publicacion3);
		when(unFiltroCiudad.aplicar(unaPublicacion)).thenReturn(false);
		when(unFiltroCiudad.aplicar(publicacion2)).thenReturn(false);
		when(unFiltroCiudad.aplicar(publicacion3)).thenReturn(false);
		when(unFiltroFecha.aplicar(unaPublicacion)).thenReturn(false);
		when(unFiltroFecha.aplicar(publicacion2)).thenReturn(false);
		when(unFiltroFecha.aplicar(publicacion3)).thenReturn(false);
		when(sistema.getAllPublicaciones()).thenReturn(publicaciones);
		
		publicaciones = unBuscador.buscarPublicaciones(unArrayDeFiltrosBasicos);
		
		assertEquals(publicaciones.size(), 0);
	}
	@Test
	public void testConFiltrosObligatoriosConMultiplesPublicacionActivasConUnMatch() throws SinFiltrosObligatoriosException {
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(unaPublicacion);
		publicaciones.add(publicacion2);
		publicaciones.add(publicacion3);
		when(unFiltroCiudad.aplicar(unaPublicacion)).thenReturn(true);
		when(unFiltroCiudad.aplicar(publicacion2)).thenReturn(false);
		when(unFiltroCiudad.aplicar(publicacion3)).thenReturn(false);
		when(unFiltroFecha.aplicar(unaPublicacion)).thenReturn(true);
		when(unFiltroFecha.aplicar(publicacion2)).thenReturn(false);
		when(unFiltroFecha.aplicar(publicacion3)).thenReturn(false);
		when(sistema.getAllPublicaciones()).thenReturn(publicaciones);
		
		publicaciones = unBuscador.buscarPublicaciones(unArrayDeFiltrosBasicos);
		
		assertEquals(publicaciones.size(), 1);
		assert(publicaciones.contains(unaPublicacion));
	}
	@Test
	public void testConFiltrosObligatoriosConMultiplesPublicacionActivasConMultiplesMatchs() throws SinFiltrosObligatoriosException {
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(unaPublicacion);
		publicaciones.add(publicacion2);
		publicaciones.add(publicacion3);
		when(unFiltroCiudad.aplicar(unaPublicacion)).thenReturn(true);
		when(unFiltroCiudad.aplicar(publicacion2)).thenReturn(true);
		when(unFiltroCiudad.aplicar(publicacion3)).thenReturn(false);
		when(unFiltroFecha.aplicar(unaPublicacion)).thenReturn(true);
		when(unFiltroFecha.aplicar(publicacion2)).thenReturn(true);
		when(unFiltroFecha.aplicar(publicacion3)).thenReturn(false);
		when(sistema.getAllPublicaciones()).thenReturn(publicaciones);
		
		publicaciones = unBuscador.buscarPublicaciones(unArrayDeFiltrosBasicos);
		
		assertEquals(publicaciones.size(), 2);
		assert(publicaciones.contains(unaPublicacion));
		assert(publicaciones.contains(publicacion2));
	}
	@Test
	public void testVerifyFilterCiudadConFiltrosVacios() {
		ArrayList<Filtro> filtros = new ArrayList<Filtro>();

		assert(!unBuscador.verifyFilterCiudad(filtros));
	}
	@Test
	public void testVerifyFilterCiudadConFiltroCiudad() {
		assert(unBuscador.verifyFilterCiudad(unArrayDeFiltrosBasicos));
	}
	@Test
	public void testVerifyFilterCiudadConFiltrosSinCiudad() {
		assert(!unBuscador.verifyFilterCiudad(unArrayDeFiltrosNoBasicos));
	}
	@Test
	public void testVerificarFiltrosObligatoriosSinFiltros() {
		try {
			unBuscador.verificarFiltrosObligatorios(new ArrayList<Filtro>());
			fail("Se esperaba excepcion SinFiltrosObligatoriosException");
		} catch(SinFiltrosObligatoriosException e) {}
	}
	@Test
	public void testVerificarFiltrosObligatoriosConFiltrosSinObligatorios() {
		try {
			unBuscador.verificarFiltrosObligatorios(unArrayDeFiltrosNoBasicos);
			fail("Se esperaba excepcion SinFiltrosObligatoriosException");
		} catch(SinFiltrosObligatoriosException e) {}
	}
}
