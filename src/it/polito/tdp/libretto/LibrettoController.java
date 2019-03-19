package it.polito.tdp.libretto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class LibrettoController {
	
	Libretto model = new Libretto();

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
    private TextField txtCorsoRicerca;

    @FXML
    private TextField txtPunteggioRicerca;

    @FXML
    private ToggleGroup toggleTipoLibretto;

    @FXML
    private ToggleGroup toggleOrdinamento;

    @FXML
    private TextArea txtOutput;

    @FXML
    void handleCancellaVotiScarsi(ActionEvent event) {

    }

    @FXML
    void handleInserisciVoto(ActionEvent event) {

    }

    @FXML
    void handleReset(ActionEvent event) {

    }

    @FXML
    void handleRicercaVoto(ActionEvent event) {

    }

    @FXML
    void handleVisualizzaLibretto(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'View.fxml'.";
        assert txtPunteggio != null : "fx:id=\"txtPunteggio\" was not injected: check your FXML file 'View.fxml'.";
        assert dateData != null : "fx:id=\"dateData\" was not injected: check your FXML file 'View.fxml'.";
        assert toggleRicerca != null : "fx:id=\"toggleRicerca\" was not injected: check your FXML file 'View.fxml'.";
        assert txtCorsoRicerca != null : "fx:id=\"txtCorsoRicerca\" was not injected: check your FXML file 'View.fxml'.";
        assert txtPunteggioRicerca != null : "fx:id=\"txtPunteggioRicerca\" was not injected: check your FXML file 'View.fxml'.";
        assert toggleTipoLibretto != null : "fx:id=\"toggleTipoLibretto\" was not injected: check your FXML file 'View.fxml'.";
        assert toggleOrdinamento != null : "fx:id=\"toggleOrdinamento\" was not injected: check your FXML file 'View.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'View.fxml'.";

    }

	public void setModel(Libretto model) {
		this.model = model;
	}
}
