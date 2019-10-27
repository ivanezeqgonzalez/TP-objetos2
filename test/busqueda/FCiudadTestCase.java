package busqueda;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import busqueda.FCiudad;
import model.Publicacion;

public class FCiudadTestCase {
	private FCiudad filtro;
	private Publicacion unaPublicacion;
	@Before
	public void setUp() throws Exception {
		filtro = new FCiudad("Buenos Aires");
		unaPublicacion = mock(Publicacion.class);
	}


	@Test
	public void testAplicarFiltroDeCiudadConPublicacionConCiudadDistintaReturnFalse() {
		when(unaPublicacion.getCiudad()).thenReturn("Rosario");

		assert(!filtro.aplicar(unaPublicacion));

	}

	@Test
	public void testAplicarFiltroDeCiudadConPublicacionConCiudadIgualReturnTrue() {
		when(unaPublicacion.getCiudad()).thenReturn("Buenos Aires");
		
		assert(filtro.aplicar(unaPublicacion));
	}
	@Test
	public void testAplicarFiltroDeCiudadConPublicacionConCiudadIgualConCaseSensitiveReturnTrue() {
		when(unaPublicacion.getCiudad()).thenReturn("buenos aires");
		
		assert(filtro.aplicar(unaPublicacion));
	}
	@Test
	public void testIsFIlterCiudadRetornaTrue() {
		assert(filtro.isFilterCiudad());
	}
}
