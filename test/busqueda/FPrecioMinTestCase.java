package busqueda;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import busqueda.FPrecioMin;
import model.Publicacion;

public class FPrecioMinTestCase {
	private FPrecioMin filtro;
	private Publicacion unaPublicacion;
	@Before
	public void setUp() throws Exception {
		filtro = new FPrecioMin((double) 100);
		unaPublicacion  = mock(Publicacion.class);
	}


	@Test
	public void testFiltroPrecioMinConPrecioDePublicacionMenorAlDelFiltroRetornaFalse() {
		when(unaPublicacion.getPrecio()).thenReturn((double) 50);

		assert(!filtro.aplicar(unaPublicacion));
		verify(unaPublicacion).getPrecio();
	}
	@Test
	public void testFiltroPrecioMinConPrecioDePublicacionMayorAlDelFiltroRetornaTrue() {
		when(unaPublicacion.getPrecio()).thenReturn((double) 150);

		assert(filtro.aplicar(unaPublicacion));
		verify(unaPublicacion).getPrecio();
	}
	@Test
	public void testFiltroPrecioMinConPrecioDePublicacionIgualAlDelFiltroRetornaTrue() {
		when(unaPublicacion.getPrecio()).thenReturn((double) 100);

		assert(filtro.aplicar(unaPublicacion));
		verify(unaPublicacion).getPrecio();
	}
}
