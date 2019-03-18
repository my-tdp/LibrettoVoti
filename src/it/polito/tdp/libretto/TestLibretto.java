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
		System.out.println(l.getList(25));
		
	} 

}
