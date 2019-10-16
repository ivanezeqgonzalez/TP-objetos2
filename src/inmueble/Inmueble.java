package inmueble;

import java.util.ArrayList;
import java.util.List;

import interfaces.Rankeable;
import interfaces.Visualizable;
import servicio.Servicio;
import usuario.Usuario;

public class Inmueble implements Rankeable, Visualizable {
	
	private TipoInmueble tipo;
	private int cantHuespedes;
	private String pais, ciudad, direccion;
	
	private int ranking;
	
	private List<Servicio> servicios;
	
	private List<Comentario> comentarios;
	
	private Usuario dueño;
	
	public Inmueble(TipoInmueble tipo, String pais, String ciudad, String direccion, int cantHuespedes, Usuario dueño) {
		super();
		this.tipo = tipo;
		this.pais = pais;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.cantHuespedes = cantHuespedes;
		this.dueño = dueño;
		
		this.servicios = new ArrayList<Servicio>();
	}

	public void agregarServicio(Servicio servicio) {
		this.servicios.add(servicio);
		
	}
	
	public String getPais() {
		return pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getDireccion() {
		return direccion;
	}
		
	public Usuario getDueño() {
		return dueño;
	}
		
	public List<Servicio> getServicios() {
		return servicios;
	}

	public String getTipo() {
		return tipo.getNombre();
	}

	public String getDescripcion() {
		return tipo.getDescripcion();
	}

	public int getCantHuespedes() {
		return cantHuespedes;
	}

	
	

	public void agregarComentario(Comentario comentario) {
		this.comentarios.add(comentario);
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	//interfaces
	
	@Override
	public int getRanking() {
		return this.ranking;
	}
	
	@Override
	public void rankear(Rankeable inmueble, int i) {
		//NOP		
	}

	@Override
	public void visualizarDatos() {
		//experimental
		
		System.out.println("Tipo de inmueble: " + this.tipo.getNombre());
		System.out.println(this.tipo.getDescripcion());
		
		
	}
	
	@Override
	public void rankearse(int puntaje) {
		this.ranking = puntaje;
		
	}

	

		

}
