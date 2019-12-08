package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HandlerInmueble {
	private HashMap <Propietario, ArrayList<Inmueble> > propietarioInmuebles;
	
	public HandlerInmueble() {
		this.propietarioInmuebles = new HashMap<Propietario, ArrayList<Inmueble>>();
	}
	
	public ArrayList<Inmueble> getInmueblesPropietario(Propietario propietario) {
		if(this.propietarioInmuebles.containsKey(propietario)) {
			return this.propietarioInmuebles.get(propietario);
		} else {
			return new ArrayList<Inmueble>();
		}
	}
	
	public void setInmueblePropietario(Inmueble inmueble, Propietario propietario) {
		ArrayList <Inmueble> inmuebles = this.getInmueblesPropietario(propietario);
		inmuebles.add(inmueble);
		this.propietarioInmuebles.put(propietario, inmuebles);
	}
	
	
	public ArrayList<Inmueble> getInmuebles() {
		ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();
		Set<Propietario> propietarios = this.propietarioInmuebles.keySet();
		for(Propietario p : propietarios) {
			inmuebles.addAll(this.propietarioInmuebles.get(p));
		}
		return inmuebles;
	}

}