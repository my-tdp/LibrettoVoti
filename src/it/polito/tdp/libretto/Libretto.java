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
	
	/**
	 * Restituisce una lista di tutti i corsi in cui il voto è pari al voto inserito
	 * 
	 * @param voto da ricercare
	 * @return lista di {@link Voto} aventi il voto inserito (eventualmente vuota)
	 */
	public List<Voto> getList(int voto) {
		List<Voto> result = new ArrayList<Voto>();
		
		for(Voto v : this.voti) {
			if(v.getVoto() == voto) {
				result.add(v);
			}
		}
		return result;
	}
}
