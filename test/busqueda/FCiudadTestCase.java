package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import busqueda.FCiudad;
import publicacion.Publicacion;

public class FCiudadTestCase {
	private FCiudad filtro;
	private Publicacion publicacionUno;
	private Publicacion publicacionDos;
	private Publicacion publicacionTres;
	@Before
	public void setUp() throws Exception {
		filtro = new FCiudad("Buenos Aires");
		publicacionUno  = mock(Publicacion.class);
		publicacionDos  = mock(Publicacion.class);
		publicacionTres  = mock(Publicacion.class);
	}

	@Test
	public void testAplicarFiltroDeListaVaciaDePublicaciones() {
		assert(filtro.aplicar(new ArrayList<Publicacion>()).isEmpty());
	}
	@Test
	public void testAplicarFiltroDeListaConUnaPublicacionConCiudadDistintaNoHayMatcheos() {
		when(publicacionUno.getCiudad()).thenReturn("Rosario");
		
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);
		
		publicaciones = filtro.aplicar(publicaciones);
		
		assert(publicaciones.isEmpty());
	}
	@Test
	public void testAplicarFiltroDeListaConUnaPublicacionConCiudadIgualEstaMatchea() {
		when(publicacionUno.getCiudad()).thenReturn("Buenos Aires");
		
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);
		
		publicaciones = filtro.aplicar(publicaciones);
		
		assertEquals(1, publicaciones.size());
		assert(publicaciones.contains(publicacionUno));
	}
	@Test
	public void testAplicarFiltroDeListaConUnaPublicacionConCiudadIgualConCaseSensitiveEstaMatchea() {
		when(publicacionUno.getCiudad()).thenReturn("buenos aires");
		
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);
		
		publicaciones = filtro.aplicar(publicaciones);
		
		assertEquals(1, publicaciones.size());
		assert(publicaciones.contains(publicacionUno));
	}
	@Test
	public void testAplicarFiltroDeListaConMultiplesPublicacionesSoloMatcheanLasCorrectas() {
		when(publicacionUno.getCiudad()).thenReturn("buenos aires");
		when(publicacionDos.getCiudad()).thenReturn("rosario");
		when(publicacionTres.getCiudad()).thenReturn("bariloche");
		
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);
		publicaciones.add(publicacionDos);
		publicaciones.add(publicacionTres);
		
		publicaciones = filtro.aplicar(publicaciones);
		
		assertEquals(1, publicaciones.size());
		assert(publicaciones.contains(publicacionUno));
		assert(!publicaciones.contains(publicacionDos));
		assert(!publicaciones.contains(publicacionTres));
	}
	@Test
	public void testAplicarFiltroDeListaConMultiplesPublicacionesSinMatcheos() {
		when(publicacionUno.getCiudad()).thenReturn("Santiago Chile");
		when(publicacionDos.getCiudad()).thenReturn("rosario");
		when(publicacionTres.getCiudad()).thenReturn("bariloche");
		
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);
		publicaciones.add(publicacionDos);
		publicaciones.add(publicacionTres);
	
		publicaciones = filtro.aplicar(publicaciones);
		
		assertEquals(0, publicaciones.size());
		assert(!publicaciones.contains(publicacionUno));
		assert(!publicaciones.contains(publicacionDos));
		assert(!publicaciones.contains(publicacionTres));
	}
}
