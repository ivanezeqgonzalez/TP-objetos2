package busqueda;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import model.Publicacion;

public class FFechaTestCase {

	private FFecha filtro;
	private LocalDate fecha_inicio, fecha_fin;
	private Publicacion unaPublicacion;
	
	@Before
	public void setUp() throws Exception {
		//una fecha dentro de 5 meses
		fecha_inicio = LocalDate.parse("2019-01-01");
		//una fecha dentro de 5 meses y 15 dias
		fecha_fin = LocalDate.parse("2019-01-20");
		filtro = new FFecha(fecha_inicio, fecha_fin);
		unaPublicacion  = mock(Publicacion.class);
	}

	@Test
	public void testAplicarFiltroDeFechaDePublicacionEnLaCualNoSeEncuentraDisponibleDentroDelRangoDevuelveFalse() {
		when(unaPublicacion.estaDisponibleEnRango(fecha_inicio, fecha_fin)).thenReturn(false);
		
		assert(!filtro.aplicar(unaPublicacion));
		verify(unaPublicacion).estaDisponibleEnRango(fecha_inicio, fecha_fin);
	}
	@Test
	public void testAplicarFiltroDeFechaDePublicacionEnLaCualSeEncuentraDisponibleDentroDelRangoDevuelveTrue() {
		when(unaPublicacion.estaDisponibleEnRango(fecha_inicio, fecha_fin)).thenReturn(true);
		
		assert(filtro.aplicar(unaPublicacion));
		verify(unaPublicacion).estaDisponibleEnRango(fecha_inicio, fecha_fin);
	}
	@Test
	public void testIsFilterFechaRetornaTrue() {
		assert(filtro.isFilterFecha());
	}
}
