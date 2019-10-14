package inmueble;

import java.util.ArrayList;
import java.util.List;


import iRanking.Rankeable;
import servicio.Servicio;

public class Inmueble implements Rankeable {
	
	private String tipo;
	private String descripcion;
	private int cantHuespedes;
	
	private int ranking;
	
	private List<Servicio> servicios;
	
	private List<Comentario> comentarios;
	
	public Inmueble(String tipo, String descripcion, int cantHuespedes) {
		super();
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.cantHuespedes = cantHuespedes;
		
		this.servicios = new ArrayList<Servicio>();
	}

	public void agregarServicio(Servicio servicio) {
		this.servicios.add(servicio);
		
	}
		
	public List<Servicio> getServicios() {
		return servicios;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getCantHuespedes() {
		return cantHuespedes;
	}

	@Override
	public void rankearse(int puntaje) {
		this.ranking = puntaje;
		
	}

	@Override
	public int getRanking() {
		return this.ranking;
	}

	public void agregarComentario(Comentario comentario) {
		this.comentarios.add(comentario);
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

		

}
