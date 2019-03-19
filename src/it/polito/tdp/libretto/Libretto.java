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
	 * Restituisce una lista di tutti i corsi in cui il {@link Voto} è pari al punteggio inserito
	 * 
	 * @param punteggio da ricercare
	 * @return lista di {@link Voto} aventi il punteggio inserito (eventualmente vuota)
	 */
	public List<Voto> cercaVoto(int punteggio) {
		List<Voto> result = new ArrayList<Voto>();
		
		for(Voto v : this.voti) {
			if(v.getPunteggio() == punteggio) {
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
		int pos = this.voti.indexOf(new Voto(0, nomeEsame, null));
		
		if(pos == -1)
			return null;
		else
			return this.voti.get(pos);
	}
	
	/**
	 * Dato un {@link Voto}, determina se esiste già un voto con un uguale
	 * corso ed uguale punteggio
	 * @param v voto da inserire
	 * @return {@code true} se ha trovato un corso e punteggio uguali, 
	 * {@code false} se non ha trovato il corso oppure l'ha trovato con un punteggio di verso
	 */
	public boolean esisteGiaVoto(Voto v) {
		int pos = this.voti.indexOf(v);
		
		if(pos == -1)
			return false;
		else
			return (v.getPunteggio() == this.voti.get(pos).getPunteggio());
	}
	
	/**
	 * Mi dice se il {@link Voto} {@code v} è in conflitto con uno dei voti esistenti.
	 * Se il voto non esiste, non c'è conflitto. Se esiste ed ha punteggio diverso, c'è conflitto.
	 * @param {@code v} voto da ricercare
	 * @return {@code true} se il voto esiste ed ha un punteggio diverso,
	 * 		   {@code false} se il voto non esiste, oppure esiste ma ha lo stesso punteggio.
	 */
	public boolean votoConflitto(Voto v) {
		int pos = this.voti.indexOf(v);
		
		if(pos == -1)
			return false;
		else
			return (v.getPunteggio() != this.voti.get(pos).getPunteggio());
	}

}
