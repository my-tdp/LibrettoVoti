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
	 * @param v il {@link Voto} da aggiungere
	 */
	public void add(Voto v) {
		voti.add(v);
	}
	
	public List<Voto> getList() {
		return voti;
	}
	
	/**
	 * Restituisce una lista di tutti i corsi in cui il {@link Voto} è pari al voto inserito
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
	
	/**
	 * Ricerca un {@link Voto} relativo al corso di cui è specificato il nome
	 * 
	 * @param nomeEsame nome del corso da ricercare
	 * @return il {@link Voto} corrispondente, oppure {@link null}
	 */
	public Voto cercaEsame(String nomeEsame) {
		for(Voto v : this.voti) {
			if(v.getCorso().equals(nomeEsame))
				return v;
		}
		
		return null;
	}
}
