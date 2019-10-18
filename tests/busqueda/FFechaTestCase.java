package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import publicacion.Publicacion;

public class FFechaTestCase {

	private FFecha filtro;
	private LocalDate fecha_inicio;
	private LocalDate fecha_fin;
	private Publicacion publicacionUno;
	private Publicacion publicacionDos;
	private Publicacion publicacionTres;
	@Before
	public void setUp() throws Exception {
		//una fecha dentro de 5 meses
		fecha_inicio =  LocalDate.now().plusMonths(5);
		//una fecha dentro de 5 meses y 15 dias
		fecha_fin =LocalDate.now().plusMonths(5).plusDays(15);
		filtro = new FFecha(fecha_inicio, fecha_fin);
		publicacionUno  = mock(Publicacion.class);
		publicacionDos  = mock(Publicacion.class);
		publicacionTres  = mock(Publicacion.class);
	}

	@Test
	public void testAplicarFiltroDeListaVaciaDePublicaciones() {
		assert(filtro.aplicar(new ArrayList<Publicacion>()).isEmpty());
	}
	@Test
	public void testAplicarFiltroDeListaDeUnaPublicacionLaCualNoSeEncuentraDisponibleDentroDelRango() {
		when(publicacionUno.estaDisponibleEnRango(fecha_inicio, fecha_fin)).thenReturn(false);
		
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);
		
		publicaciones = filtro.aplicar(publicaciones);
	
		verify(publicacionUno).estaDisponibleEnRango(fecha_inicio, fecha_fin);
		assertEquals(0, publicaciones.size());
		assert(!publicaciones.contains(publicacionUno));
	}
	@Test
	public void testAplicarFiltroDeListaDeUnaPublicacionLaCualSeEncuentraDisponibleDentroDelRangoMatchea() {
		when(publicacionUno.estaDisponibleEnRango(fecha_inicio, fecha_fin)).thenReturn(true);
		
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);
		
		publicaciones = filtro.aplicar(publicaciones);
	
		verify(publicacionUno).estaDisponibleEnRango(fecha_inicio, fecha_fin);
		assertEquals(1, publicaciones.size());
		assert(publicaciones.contains(publicacionUno));
	}
	@Test
	public void testAplicarFiltroDeListaConMultiplesPublicacionesSoloMatcheanLasCorrectas() {
		when(publicacionUno.estaDisponibleEnRango(fecha_inicio, fecha_fin)).thenReturn(true);
		when(publicacionDos.estaDisponibleEnRango(fecha_inicio, fecha_fin)).thenReturn(true);
		when(publicacionTres.estaDisponibleEnRango(fecha_inicio, fecha_fin)).thenReturn(false);
		
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);
		publicaciones.add(publicacionDos);
		publicaciones.add(publicacionTres);
		
		publicaciones = filtro.aplicar(publicaciones);
		
		verify(publicacionUno).estaDisponibleEnRango(fecha_inicio, fecha_fin);
		verify(publicacionDos).estaDisponibleEnRango(fecha_inicio, fecha_fin);
		verify(publicacionTres).estaDisponibleEnRango(fecha_inicio, fecha_fin);
		assertEquals(2, publicaciones.size());
		assert(publicaciones.contains(publicacionUno));
		assert(publicaciones.contains(publicacionDos));
		assert(!publicaciones.contains(publicacionTres));
	}
	@Test
	public void testAplicarFiltroDeListaConMultiplesPublicacionesSinMatcheos() {
		when(publicacionUno.estaDisponibleEnRango(fecha_inicio, fecha_fin)).thenReturn(false);
		when(publicacionDos.estaDisponibleEnRango(fecha_inicio, fecha_fin)).thenReturn(false);
		when(publicacionTres.estaDisponibleEnRango(fecha_inicio, fecha_fin)).thenReturn(false);
		
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(publicacionUno);
		publicaciones.add(publicacionDos);
		publicaciones.add(publicacionTres);
		
		publicaciones = filtro.aplicar(publicaciones);
		
		verify(publicacionUno).estaDisponibleEnRango(fecha_inicio, fecha_fin);
		verify(publicacionDos).estaDisponibleEnRango(fecha_inicio, fecha_fin);
		verify(publicacionTres).estaDisponibleEnRango(fecha_inicio, fecha_fin);
		assert( publicaciones.isEmpty());
		assert(!publicaciones.contains(publicacionUno));
		assert(!publicaciones.contains(publicacionDos));
		assert(!publicaciones.contains(publicacionTres));
	}
}
