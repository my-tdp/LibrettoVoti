package it.polito.tdp.libretto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class LibrettoController {
	
	Libretto model = new Libretto();
	boolean ricercaPerCorso;
	boolean ricercaPerPunteggio;
	boolean librettoNormale;
	boolean librettoMigliorato;
	boolean ordinamentoAlfabetico;
	boolean ordinamentoVotiDecrescenti;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCorso;

    @FXML
    private TextField txtPunteggio;

    @FXML
    private DatePicker dateData;

    @FXML
    private ToggleGroup toggleRicerca;
    
    @FXML
    private RadioButton radioRicercaPerCorso;
    
    @FXML
    private RadioButton radioRicercaPerPunteggio;

    @FXML
    private TextField txtCorsoRicerca;

    @FXML
    private TextField txtPunteggioRicerca;

    @FXML
    private ToggleGroup toggleTipoLibretto;

    @FXML
    private RadioButton radioLibrettoNormale;
    
    @FXML
    private RadioButton radioLibrettoMigliorato;

    @FXML
    private ToggleGroup toggleOrdinamento;
    
    @FXML
    private RadioButton radioOrdinamentoAlfabetico;
    
    @FXML
    private RadioButton radioOrdinamentoVotiDecrescenti;

    @FXML
    private TextArea txtOutput;
    
    

    @FXML
    void handleCancellaVotiScarsi(ActionEvent event) {
    	model.cancellaVotiScarsi();
    }

    @FXML
    void handleInserisciVoto(ActionEvent event) {
    	String punteggio = txtPunteggio.getText().trim();
    	String corso = txtCorso.getText().trim();
    	LocalDate data = dateData.getValue();
    	
    	if(punteggio.equals("") || corso.equals("") || data == null){
    		txtOutput.appendText("Errore: campi vuoti.\n");
    		return;
    	}
    	if(!punteggio.matches("[0-9]*")) {
    		txtOutput.appendText("Errore: campo 'Punteggio' non corretto.\n");
    		return;
    	}
    	
    	Voto v = new Voto(Integer.parseInt(punteggio), corso, data);
    	if(model.add(v))
    		txtOutput.appendText("Voto inserito!\n");
    	else
    		txtOutput.appendText("Errore: voto già presente e/o in conflitto.\n");
    }

    @FXML
    void handleReset(ActionEvent event) {
    	this.txtCorso.clear();
    	this.txtPunteggio.clear();
    	// this.dateData ?
    	this.txtCorsoRicerca.clear();
    	this.txtPunteggioRicerca.clear();
    	this.txtOutput.clear();
    }

    @FXML
    void handleRicercaVoto(ActionEvent event) {
    	if(ricercaPerCorso) {
    		String corso = txtCorsoRicerca.getText().trim();
    		
    		if(corso.equals("")) {
        		txtOutput.appendText("Errore: campi vuoti.\n");
        		return;
        	}
    		
    		Voto v = model.cercaEsame(corso);
    		if(v == null)
    			txtOutput.appendText("Voto non trovato!\n");
    		else
    			txtOutput.appendText("Voto trovato --> " + v.toString());
    		
    	} else if(ricercaPerPunteggio) {
    		String punteggio = txtPunteggioRicerca.getText().trim();
    		
    		if(punteggio.equals("")) {
        		txtOutput.appendText("Errore: campi vuoti.\n");
        		return;
        	}
    		if(!punteggio.matches("[0-9]*")){
        		txtOutput.appendText("Errore: campo 'Punteggio' non corretto.\n");
        		return;
        	}
    		
    		List<Voto> v = model.cercaVoto(Integer.parseInt(punteggio));
    		if(v.isEmpty())
    			txtOutput.appendText("Nessun voto trovato!\n");
    		else
    			txtOutput.appendText(v.size() + " voto/i trovato/i:\n" + formattaLista(v));
    	}
    }

    @FXML
    void handleVisualizzaLibretto(ActionEvent event) {
    	List<Voto> v = new ArrayList<Voto>();   	
    	
    	if(librettoNormale) {
    		if(ordinamentoAlfabetico)
    			v = model.ordinaVoti(model.getList(), "Alfabetico");
    		else if(ordinamentoVotiDecrescenti)
    			v = model.ordinaVoti(model.getList(), "VotiDecrescenti");
    			
    	} else if(librettoMigliorato) {
    		Libretto migliorato = model.librettoMigliorato();
    		
    		if(ordinamentoAlfabetico)
    			v = model.ordinaVoti(migliorato.getList(), "Alfabetico");
    		else if(ordinamentoVotiDecrescenti)
    			v = model.ordinaVoti(migliorato.getList(), "VotiDecrescenti");
    	}
    	
    	if(v.size() == 0)
    		txtOutput.setText("Libretto vuoto!");
    	else
    		txtOutput.setText(formattaLista(v));
    }
    
    @FXML
    void switchOrdinamentoToggle(ActionEvent event) {
    	if(radioOrdinamentoAlfabetico.isSelected()) {
    		ordinamentoAlfabetico = true;
    		ordinamentoVotiDecrescenti = false;
    	} else if(radioOrdinamentoVotiDecrescenti.isSelected()) {
    		ordinamentoAlfabetico = false;
    		ordinamentoVotiDecrescenti = true;
    	}
    }

    @FXML
    void switchRicercaToggle(ActionEvent event) {
    	if(radioRicercaPerCorso.isSelected()) {
    		ricercaPerCorso = true;
    		txtCorsoRicerca.setDisable(false);
    		ricercaPerPunteggio = false;
    		txtPunteggioRicerca.setDisable(true);
    	} else if(radioRicercaPerPunteggio.isSelected()) {
    		ricercaPerCorso = false;
    		txtCorsoRicerca.setDisable(true);
    		ricercaPerPunteggio = true;
    		txtPunteggioRicerca.setDisable(false);
    	}
    }

    @FXML
    void switchTipoLibrettoToggle(ActionEvent event) {
    	if(radioLibrettoNormale.isSelected()) {
    		librettoNormale = true;
    		librettoMigliorato = false;
    	} else if(radioLibrettoMigliorato.isSelected()) {
    		librettoNormale = false;
    		librettoMigliorato = true;
    	}
    }

    @FXML
    void initialize() {
    	assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'View.fxml'.";
        assert txtPunteggio != null : "fx:id=\"txtPunteggio\" was not injected: check your FXML file 'View.fxml'.";
        assert dateData != null : "fx:id=\"dateData\" was not injected: check your FXML file 'View.fxml'.";
        assert radioRicercaPerCorso != null : "fx:id=\"radioRicercaPerCorso\" was not injected: check your FXML file 'View.fxml'.";
        assert toggleRicerca != null : "fx:id=\"toggleRicerca\" was not injected: check your FXML file 'View.fxml'.";
        assert radioRicercaPerPunteggio != null : "fx:id=\"radioRicercaPerPunteggio\" was not injected: check your FXML file 'View.fxml'.";
        assert txtCorsoRicerca != null : "fx:id=\"txtCorsoRicerca\" was not injected: check your FXML file 'View.fxml'.";
        assert txtPunteggioRicerca != null : "fx:id=\"txtPunteggioRicerca\" was not injected: check your FXML file 'View.fxml'.";
        assert radioLibrettoNormale != null : "fx:id=\"radioLibrettoNormale\" was not injected: check your FXML file 'View.fxml'.";
        assert toggleTipoLibretto != null : "fx:id=\"toggleTipoLibretto\" was not injected: check your FXML file 'View.fxml'.";
        assert radioLibrettoMigliorato != null : "fx:id=\"radioLibrettoMigliorato\" was not injected: check your FXML file 'View.fxml'.";
        assert radioOrdinamentoAlfabetico != null : "fx:id=\"radioOrdinamentoAlfabetico\" was not injected: check your FXML file 'View.fxml'.";
        assert toggleOrdinamento != null : "fx:id=\"toggleOrdinamento\" was not injected: check your FXML file 'View.fxml'.";
        assert radioOrdinamentoVotiDecrescenti != null : "fx:id=\"radioOrdinamentoVotiDecrescenti\" was not injected: check your FXML file 'View.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'View.fxml'.";

    }

	public void setModel(Libretto model) {
		this.model = model;
		this.ricercaPerCorso = true;
		this.ricercaPerPunteggio = false;
		this.librettoNormale = true;
		this.librettoMigliorato = false;
		this.ordinamentoAlfabetico = true;
		this.ordinamentoVotiDecrescenti = false;
	}
	
	String formattaLista(List<Voto> l) {
    	String elencoFormattato = new String("");
		for(int i=0; i<l.size(); i++) 
			elencoFormattato+=l.get(i).toString();

    	return elencoFormattato;
    }
}
