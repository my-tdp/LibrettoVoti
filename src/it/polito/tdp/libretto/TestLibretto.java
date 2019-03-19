package it.polito.tdp.libretto;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto l = new Libretto();
		
		// 1
		l.add(new Voto(29,"Informatica",LocalDate.of(2017,6,23)));
		l.add(new Voto(27,"Sistemi di produzione",LocalDate.of(2018,7,17)));
		l.add(new Voto(27,"Programmazione a oggetti",LocalDate.of(2019,1,31)));
		l.add(new Voto(25,"Analisi matematica II",LocalDate.of(2018,6,18)));
		l.add(new Voto(22,"Economia e organizzazione aziendale",LocalDate.of(2018,6,25)));
		l.add(new Voto(25,"Statistica",LocalDate.of(2018,9,20)));
		l.add(new Voto(20,"Algebra lineare e geometria",LocalDate.of(2017,6,27)));
		l.add(new Voto(20,"Analisi matematica I",LocalDate.of(2017,9,18)));
		l.add(new Voto(25,"Elementi di diritto privato",LocalDate.of(2019,2,5)));
		l.add(new Voto(18,"Ricerca operativa",LocalDate.of(2018,7,13)));

		// 2
		System.out.println(l.cercaVoto(25));
		
		// 3
		System.out.println(l.cercaEsame("Analisi matematica I"));
		System.out.println(l.cercaEsame("Analisi matematica III"));
		
		// 4
		Voto giusto = new Voto(29, "Informatica", LocalDate.now());
		Voto sbagliato = new Voto(18, "Informatica", LocalDate.now());
		Voto mancante  = new Voto(30, "Merendine", LocalDate.now());
		
		System.out.format("Il voto %s è %s\n", giusto.toString(), l.esisteGiaVoto(giusto));
		System.out.format("Il voto %s è %s\n", sbagliato.toString(), l.esisteGiaVoto(sbagliato));
		System.out.format("Il voto %s è %s\n", mancante.toString(), l.esisteGiaVoto(mancante));
		
		// 5
		System.out.format("Il voto %s è %s\n", giusto.toString(), l.votoConflitto(giusto));
		System.out.format("Il voto %s è %s\n", sbagliato.toString(), l.votoConflitto(sbagliato));
		System.out.format("Il voto %s è %s\n", mancante.toString(), l.votoConflitto(mancante));
		
	} 

}
