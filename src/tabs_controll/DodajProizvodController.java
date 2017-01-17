/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabs_controll;

import database.CRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.TipProizvoda;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class DodajProizvodController implements Initializable {

    CRUD crud = new CRUD();

    @FXML private TextField txtNaziv;
    @FXML private TextField txtCena;
    @FXML private TextField txtKolicina;
    @FXML private ComboBox<TipProizvoda> comboTip;
    @FXML private Button btnDodaj;
    @FXML private Label labelMessage;

/**
 * Initializes the controller class.
 */
@Override
public void initialize(URL url, ResourceBundle rb) {
    ObservableList<TipProizvoda> data = crud.queryTipProizvoda();
    comboTip.setItems(data);
}

@FXML public void dodajProizvod(){

    TipProizvoda tipProizvoda = comboTip.getSelectionModel().getSelectedItem();

    String naziv = txtNaziv.getText();
    double kolicina = Double.parseDouble(txtKolicina.getText());
    double cena = Double.parseDouble(txtCena.getText());

    String message = crud.insertIntoProizvod(tipProizvoda.getTip_id(), naziv,kolicina, cena);
    labelMessage.setText(message);
}
}
