package model;

public class Inmueble {

	private Propietario dueño;

	public Inmueble(Propietario propietario) {
		this.dueño = propietario;
		
	}

	public Propietario getDueño() {
		return this.dueño;
	}


}
