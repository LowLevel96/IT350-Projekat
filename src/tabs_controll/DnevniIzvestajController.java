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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Nabavka;
import model.Prodaja;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class DnevniIzvestajController implements Initializable {

    CRUD crud = new CRUD();


    @FXML private TableView tableViewProdaja;
    @FXML private TableView tableViewNabavka;
    
    @FXML private TableColumn tableColumnProdajaId;
    @FXML private TableColumn tableColumnProdajaZaposleni;
    @FXML private TableColumn tableColumnProdajaKasa;
    @FXML private TableColumn tableColumnProdajaKolicina;
    @FXML private TableColumn tableColumnProdajaCena;
    @FXML private TableColumn tableColumnProdajaDatum;
    @FXML private TableColumn tableColumnProdajaPorez;

    @FXML private TableColumn tableColumnNabavkaId;
    @FXML private TableColumn tableColumnNabavkaNabavljac;
    @FXML private TableColumn tableColumnNabavkaKolicina;
    @FXML private TableColumn tableColumnNabavkaDatum;
    
    @FXML private Label labelProdajaUkupno;
/**
 * Initializes the controller class.
 */
@Override
public void initialize(URL url, ResourceBundle rb) {

    ObservableList<Nabavka> nabavka = crud.queryNabavka();
    ObservableList<Prodaja> prodaja = crud.queryProdajaToday();
    
    tableViewProdaja.setItems(prodaja);
    tableViewNabavka.setItems(nabavka);
    
    tableColumnProdajaId.setCellValueFactory(new PropertyValueFactory<>("prodaja_id"));
    tableColumnProdajaZaposleni.setCellValueFactory(new PropertyValueFactory<>("prodaja_zaposleni"));
    tableColumnProdajaKasa.setCellValueFactory(new PropertyValueFactory<>("kasa_id"));
    tableColumnProdajaKolicina.setCellValueFactory(new PropertyValueFactory<>("prodaja_kolicina"));
    tableColumnProdajaCena.setCellValueFactory(new PropertyValueFactory<>("prodaja_cena"));
    tableColumnProdajaDatum.setCellValueFactory(new PropertyValueFactory<>("prodaja_datum"));
    tableColumnProdajaPorez.setCellValueFactory(new PropertyValueFactory<>("prodaja_porez"));
    
    tableColumnNabavkaId.setCellValueFactory(new PropertyValueFactory<>("nabavka_id"));
    tableColumnNabavkaNabavljac.setCellValueFactory(new PropertyValueFactory<>("nabavljac_id"));
    tableColumnNabavkaKolicina.setCellValueFactory(new PropertyValueFactory<>("nabavka_kolicina"));
    tableColumnNabavkaDatum.setCellValueFactory(new PropertyValueFactory<>("nabavka_datum"));
    
    labelProdajaUkupno.setText(crud.findUkupnoInProdajaForToday());
    
    // TODO
} 
    
}
