package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	
	/**
	 * Aggiunge un nuovo voto al libretto
	 * 
	 * @param v il (@link Voto) da aggiungere
	 */
	public void add(Voto v) {
		voti.add(v);
	}
	
	public List<Voto> getList() {
		return voti;
	}
}
