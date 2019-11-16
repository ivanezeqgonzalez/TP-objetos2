package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
 

class PublicacionTest {

	private Publicacion publicacion;
	private Inmueble mockInmueble;
	//private Usuario mockUsuario;
	//private Fechas mockAdminFechas;
	private LocalDate fecha_inicio_1, fecha_inicio_2, fecha_fin_1, fecha_fin_2;
	private Propietario unPropietario;
	//private DateTime fecha_inicio_2;
	//private DateTime fecha_fin_1;
	//private DateTime fecha_fin_2;
	
	@BeforeEach
	void setUp() throws Exception {
		//this.mockUsuario = mock(Usuario.class);
		this.mockInmueble = mock (Inmueble.class);
		//this.mockAdminFechas = mock (Fechas.class);
		this.unPropietario = mock(Propietario.class);
		
		this.fecha_inicio_1 = LocalDate.parse("2019-01-01");
		this.fecha_inicio_2 = LocalDate.parse("2019-01-01");
		this.fecha_fin_1 = LocalDate.parse("2019-01-15");
		this.fecha_fin_2 = LocalDate.parse("2019-01-15");
		
	}

	@Test
	void testCreacion() {
		//this.publicacion = new Publicacion(unPropietario, mockInmueble, DateTime.now().plusMonths(5), DateTime.now().plusMonths(5).plusDays(15), 1200f);
		this.publicacion = new Publicacion(unPropietario, mockInmueble, fecha_inicio_1, fecha_fin_1, 1200f);
		
	}
	@Test
	void estaDisponibleEnRangoDelegaResponsabilidadAlAdminDeFechas() {
		//fecha_inicio_1 = DateTime.now().plusMonths(5);
		//fecha_inicio_2 = DateTime.now().plusMonths(6);
		//fecha_fin_1 =  DateTime.now().plusMonths(5).plusDays(15);
		//fecha_fin_2 =  DateTime.now().plusMonths(6).plusDays(15);
				
		publicacion = new Publicacion(unPropietario, mockInmueble, fecha_inicio_1, fecha_fin_1, 1200f);
		assertFalse(publicacion.estaDisponibleEnRango(fecha_inicio_2, fecha_fin_2));
		
		
		
		//when(mockAdminFechas.fechasSeSobreponen(fecha_inicio_1,fecha_fin_1, fecha_inicio_2, fecha_fin_2)).thenReturn(true);
		//publicacion.setAdminFechas(mockAdminFechas);
		
	}
	
	
	
}
