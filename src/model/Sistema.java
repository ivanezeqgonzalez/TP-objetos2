package model;

import java.util.ArrayList;

import org.joda.time.DateTime;

import busqueda.Filtro;
import busqueda.MotorDeBusqueda;
import exceptions.SinFiltrosObligatoriosException;

public class Sistema {
	private ArrayList<Publicacion> publicaciones;
	private MotorDeBusqueda buscador;
	
	public Sistema() {
		this.publicaciones = new ArrayList<Publicacion>();
		this.buscador = new MotorDeBusqueda();
	}
	
	public ArrayList<Publicacion> getAllPublicaciones() {
		return this.publicaciones;
	}
	
	public void publicar(Propietario unPropietario, Inmueble unInmueble, DateTime fechaInicio, DateTime fechaFin, float precio) {
		this.publicaciones.add(new Publicacion(unPropietario, unInmueble, fechaInicio, fechaFin, precio));
	}
	
	public ArrayList<Publicacion> buscarPublicaciones(ArrayList<Publicacion> publicaciones, ArrayList<Filtro> filtros) throws SinFiltrosObligatoriosException {
		return this.buscador.buscarPublicaciones(publicaciones, filtros);
	}
}
