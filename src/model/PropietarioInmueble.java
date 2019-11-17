package model;

import java.util.ArrayList;
import java.util.HashMap;

public class PropietarioInmueble {
	private HashMap <Usuario, ArrayList<Inmueble> > propietarioInmuebles;
	
	public PropietarioInmueble() {
		this.propietarioInmuebles = new HashMap<Usuario, ArrayList<Inmueble>>();
	}
	
	public ArrayList<Inmueble> getInmueblesPropietario(Usuario propietario) {
		return this.propietarioInmuebles.get(propietario);
	}
	
	public void setInmueblePropietario(Usuario propietario, Inmueble inmueble) {
		ArrayList <Inmueble> inmuebles = this.getInmueblesPropietario(propietario);
		inmuebles.add(inmueble);
		this.propietarioInmuebles.put(propietario, inmuebles);
	}
}