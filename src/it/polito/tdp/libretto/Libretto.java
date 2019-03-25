package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	 * @return {@code true} nel caso normale, {@code false} se non è riuscito ad aggiungere il voto.
	 */
	public boolean add(Voto v) {
		if(!this.esisteGiaVoto(v) && !this.votoConflitto(v)) { 
			voti.add(v);
			return true;
		} else
			return false;
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
	 * {@code false} se il voto non esiste, oppure esiste ma ha lo stesso punteggio.
	 */
	public boolean votoConflitto(Voto v) {
		int pos = this.voti.indexOf(v);
		
		if(pos == -1)
			return false;
		else
			return (v.getPunteggio() != this.voti.get(pos).getPunteggio());
	}

	@Override
	public String toString() {
		return this.voti.toString();
	}
	
	public Libretto librettoMigliorato() {
		Libretto nuovo = new Libretto();
		
		for(Voto v : this.voti)
			nuovo.add(v.clone());
		
		for(Voto v : nuovo.voti) {
			if(v.getPunteggio() < 24)
				v.setPunteggio(v.getPunteggio()+1);
			else if(v.getPunteggio() <= 28)
				v.setPunteggio(v.getPunteggio()+2);
		}
			
		return nuovo;
	}
	
	public void cancellaVotiScarsi() {
		List<Voto> votiDaCancellare = new ArrayList<Voto>();
		for(Voto v : this.voti) {
			if(v.getPunteggio() < 24)
				votiDaCancellare.add(v);
		}
		
		this.voti.removeAll(votiDaCancellare);
	}
	
	public List<Voto> ordinaVoti(List<Voto> v, String tipoOrdinamento) {
		if(tipoOrdinamento.equals("Alfabetico"))
			Collections.sort(v, new OrdinamentoVotiAlfabetico());
		else if(tipoOrdinamento.equals("VotiDecrescenti"))
			Collections.sort(v, new OrdinamentoVotiPunteggioDecrescente());
		
		return v;
	}
	
	public class OrdinamentoVotiAlfabetico implements Comparator<Voto> {

		@Override
		public int compare(Voto v1, Voto v2) {
			return v1.getCorso().compareTo(v2.getCorso());
		}
	}
	
	public class OrdinamentoVotiPunteggioDecrescente implements Comparator<Voto> {

		@Override
		public int compare(Voto v1, Voto v2) {
			return v1.getPunteggio()-v2.getPunteggio();
		}
	}
}
