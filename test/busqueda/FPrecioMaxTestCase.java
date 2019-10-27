package busqueda;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.Before;
import org.junit.Test;

import busqueda.FPrecioMax;
import model.Publicacion;

public class FPrecioMaxTestCase {

	private FPrecioMax filtro;
	private Publicacion unaPublicacion;
	@Before
	public void setUp() throws Exception {
		filtro = new FPrecioMax((double) 100);
		unaPublicacion  = mock(Publicacion.class);
	}

	@Test
	public void testFiltroPrecioMaxConPrecioDePublicacionMenorAlDelFiltroRetornaTrue() {
		when(unaPublicacion.getPrecio()).thenReturn((double) 50);

		assert(filtro.aplicar(unaPublicacion));
		verify(unaPublicacion).getPrecio();
	}
	@Test
	public void testFiltroPrecioMaxConPrecioDePublicacionMayorAlDelFiltroRetornaFalse() {
		when(unaPublicacion.getPrecio()).thenReturn((double) 150);

		assert(!filtro.aplicar(unaPublicacion));
		verify(unaPublicacion).getPrecio();
	}
	@Test
	public void testFiltroPrecioMaxConPrecioDePublicacionIgualAlDelFiltroRetornaTrue() {
		when(unaPublicacion.getPrecio()).thenReturn((double) 100);

		assert(filtro.aplicar(unaPublicacion));
		verify(unaPublicacion).getPrecio();
	}

}
