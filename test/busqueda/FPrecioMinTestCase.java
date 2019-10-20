package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import busqueda.FPrecioMin;
import publicacion.Publicacion;

public class FPrecioMinTestCase {
	private FPrecioMin filtro;
	private Publicacion publicacionUno;
	private Publicacion publicacionDos;
	private Publicacion publicacionTres;
	@Before
	public void setUp() throws Exception {
		filtro = new FPrecioMin(50);
		publicacionUno  = mock(Publicacion.class);
		publicacionDos  = mock(Publicacion.class);
		publicacionTres  = mock(Publicacion.class);
	}

	@Test
	public void testSiFiltroSeAplicaAUnArrayVacioDePublicacionesNoDevuelvePublicaciones() {
		assert(filtro.aplicar(new ArrayList<Publicacion>()).isEmpty());
	}
	@Test
	public void testSiFiltroSeAplicaAunArrayDeUnaPublicacionConPrecioMenorAlDelFiltroNoMatcheaNada() {
		when(publicacionUno.getPrecio()).thenReturn((double) 30);
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);
		
		publicaciones = filtro.aplicar(publicaciones);
		
		assertEquals(0, publicaciones.size());
	}
	@Test
	public void testSiFiltroSeAplicaAunArrayDeUnaPublicacionConPrecioIgualAlDelFiltroMatchea() {
		when(publicacionUno.getPrecio()).thenReturn((double) 50);
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);

		publicaciones = filtro.aplicar(publicaciones);
	
		assertEquals(1, publicaciones.size());
		assert(publicaciones.contains(publicacionUno));
	}
	@Test
	public void testSiFiltroSeAplicaAunArrayDeUnaPublicacionConPrecioMayorAlDelFiltroMatchea() {
		when(publicacionUno.getPrecio()).thenReturn((double) 70);
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);

		publicaciones = filtro.aplicar(publicaciones);
	
		assertEquals(1, publicaciones.size());
		assert(publicaciones.contains(publicacionUno));
	}
	@Test
	public void testSoloMatcheanPublicacionesQuePasenElFiltro() {
		when(publicacionUno.getPrecio()).thenReturn((double) 20);
		when(publicacionDos.getPrecio()).thenReturn((double) 50);
		when(publicacionTres.getPrecio()).thenReturn((double) 70);
		
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);
		publicaciones.add(publicacionDos);
		publicaciones.add(publicacionTres);

		publicaciones = filtro.aplicar(publicaciones);

		assertEquals(2, publicaciones.size());
		assert(!publicaciones.contains(publicacionUno));
		assert(publicaciones.contains(publicacionDos));
		assert(publicaciones.contains(publicacionTres));
	}
}
