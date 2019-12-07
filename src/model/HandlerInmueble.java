package model;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
		ArrayList inmuebles = new ArrayList<Inmueble>();
		Set<Propietario> propietarios = this.propietarioInmuebles.keySet();
		for(Propietario p : propietarios) {
			inmuebles.addAll(this.propietarioInmuebles.get(p));
		}
		return inmuebles;
	}
}