package model;

import java.util.ArrayList;
import java.util.HashMap;

public class PropietarioInmueble {
	private HashMap <Usuario, ArrayList<Inmueble> > propietarioInmuebles;
	
	public PropietarioInmueble() {
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
	
	
}