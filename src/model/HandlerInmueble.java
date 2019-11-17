package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HandlerInmueble {
	private HashMap <Usuario, ArrayList<Inmueble> > propietarioInmuebles;
	private List<Inmueble> inmuebles = new ArrayList<Inmueble>();
	
	public HandlerInmueble() {
		this.propietarioInmuebles = new HashMap<Usuario, ArrayList<Inmueble>>();
	}
	
	public ArrayList<Inmueble> getInmueblesPropietario(Usuario propietario) {
		if(this.propietarioInmuebles.containsKey(propietario)) {
			return this.propietarioInmuebles.get(propietario);
		} else {
			return new ArrayList<Inmueble>();
		}
	}
	
	public void setInmueblePropietario(Usuario propietario, Inmueble inmueble) {
		ArrayList <Inmueble> inmuebles = this.getInmueblesPropietario(propietario);
		inmuebles.add(inmueble);
		this.propietarioInmuebles.put(propietario, inmuebles);
	}
	
	public List<Inmueble> getInmuebles() {
		return this.inmuebles;
	}

	public void crearInmueble(TipoInmueble tipo, String pais, String ciudad, String direccion, int cantHuespedes, Propietario propietario) {
		this.inmuebles.add(new Inmueble(tipo, pais, ciudad, direccion, cantHuespedes, propietario));
	}
	

}