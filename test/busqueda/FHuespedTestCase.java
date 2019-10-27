package busqueda;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import busqueda.FHuesped;
import model.Publicacion;

public class FHuespedTestCase {
	private FHuesped filtroHuesped;
	private Publicacion unaPublicacion;
	@Before
	public void setUp() throws Exception {
		filtroHuesped = new FHuesped(5);
		unaPublicacion  = mock(Publicacion.class);
	}


	@Test
	public void testAplicarFiltroDeHuespedesConValorDeFiltroMayorALaPublicacion() {
		when(unaPublicacion.getHuespedes()).thenReturn(1);
		assert(!filtroHuesped.aplicar(unaPublicacion));
		verify(unaPublicacion).getHuespedes();
	}
	@Test
	public void testAplicarFiltroDeHuespedesConValorDeFiltroMenorALaPublicacion() {
		when(unaPublicacion.getHuespedes()).thenReturn(8);
		assert(!filtroHuesped.aplicar(unaPublicacion));
		verify(unaPublicacion).getHuespedes();
	}
	@Test
	public void testAplicarFIltroDeHuespedesConValorDeFiltroIgualALaPublicacion() {
		when(unaPublicacion.getHuespedes()).thenReturn(5);
		assert(filtroHuesped.aplicar(unaPublicacion));
		verify(unaPublicacion).getHuespedes();
	}
}
