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
	//private List<Inmueble> inmuebles = new ArrayList<Inmueble>();
	
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
	
	public ArrayList<Inmueble> getInmuebles(Propietario propietario) {
		return this.propietarioInmuebles.get(propietario);
	}
	
	public ArrayList<Inmueble> getInmuebles() {
		ArrayList inmuebles = new ArrayList<Inmueble>();
		Set<Propietario> propietarios = this.propietarioInmuebles.keySet();
		for(Propietario p : propietarios) {
			inmuebles.addAll(this.propietarioInmuebles.get(p));
		}
		return inmuebles;
	}
	
	public Propietario getPropietario(Inmueble inmueble) {
		return this.getKeysFromValue(this.propietarioInmuebles, inmueble).get(0);
				
	
	}
	
	private List<Propietario> getKeysFromValue(HashMap<Propietario, ArrayList<Inmueble>> hm, Inmueble value){
	    List <Propietario> list = new ArrayList<Propietario>();
	    for(Propietario o:hm.keySet()){
	        if(hm.get(o).equals(value)) {
	            list.add(o);
	        }
	    }
	    return list;
	  }

}