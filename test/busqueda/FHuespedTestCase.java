package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import busqueda.FHuesped;
import publicacion.Publicacion;

public class FHuespedTestCase {
	private FHuesped filtroHuesped;
	private Publicacion publicacionUno;
	private Publicacion publicacionDos;
	private Publicacion publicacionTres;
	@Before
	public void setUp() throws Exception {
		filtroHuesped = new FHuesped(0);
		publicacionUno  = mock(Publicacion.class);
		publicacionDos  = mock(Publicacion.class);
		publicacionTres  = mock(Publicacion.class);
	}

	@Test
	public void testAplicarFiltroDeListaVaciaDePublicaciones() {
		assert(filtroHuesped.aplicar(new ArrayList<Publicacion>()).isEmpty());
	}
	@Test
	public void testAplicarFiltroDeHuespedesConValorDeFiltroEnCeroNoFiltraNingunaPublicacion() {
		when(publicacionUno.getHuespedes()).thenReturn(1);
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);

		assertEquals(1, filtroHuesped.aplicar(publicaciones).size());
	}
	@Test
	public void testAplicarFiltroDeHuespedesConValorDeFiltroEnUnoSoloFiltraPublicacionesConMenosDeUnHuesped() {
		when(publicacionUno.getHuespedes()).thenReturn(0);
		when(publicacionDos.getHuespedes()).thenReturn(1);
		when(publicacionTres.getHuespedes()).thenReturn(2);
		filtroHuesped = new FHuesped(1);
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);
		publicaciones.add(publicacionDos);
		publicaciones.add(publicacionTres);

		publicaciones = filtroHuesped.aplicar(publicaciones);

		assertEquals(2, publicaciones.size());
		assert(!publicaciones.contains(publicacionUno));
		assert(publicaciones.contains(publicacionDos));
		assert(publicaciones.contains(publicacionTres));
	}
	@Test
	public void testFiltroSiNingunaPublicacionCumpleConLosHuespedesSeRetornaUnaListaVacia() {
		when(publicacionUno.getHuespedes()).thenReturn(0);
		when(publicacionDos.getHuespedes()).thenReturn(1);
		when(publicacionTres.getHuespedes()).thenReturn(2);
		filtroHuesped = new FHuesped(4);
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);
		publicaciones.add(publicacionDos);
		publicaciones.add(publicacionTres);

		publicaciones = filtroHuesped.aplicar(publicaciones);

		assertEquals(0, publicaciones.size());
	}
}
