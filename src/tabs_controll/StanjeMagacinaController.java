/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabs_controll;

import database.CRUD;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Proizvod;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class StanjeMagacinaController implements Initializable {

    @FXML private TableView tableViewWithStanje;
    @FXML private TableView tableViewWithoutStanje;
    @FXML private TableColumn tableColumnId;
    @FXML private TableColumn tableColumnTip;
    @FXML private TableColumn tableColumnCena;
    @FXML private TableColumn tableColumnKolicina;
    @FXML private TableColumn tableColumnNaziv;
    @FXML private TableColumn tableColumnId2;
    @FXML private TableColumn tableColumnTip2;
    @FXML private TableColumn tableColumnCena2;
    @FXML private TableColumn tableColumnKolicina2;
    @FXML private TableColumn tableColumnNaziv2;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        CRUD crud = new CRUD();
        
        ObservableList<Proizvod> listaProizvoda = crud.queryProizvod();
        
        ObservableList<Proizvod> withStanje = listaProizvoda.stream()
                .filter(p -> p.getProizvod_kolicina() > 0)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        
        ObservableList<Proizvod> withoutStanje = listaProizvoda.stream()
                .filter(p -> p.getProizvod_kolicina() == 0)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        
        tableViewWithStanje.setItems(withStanje);
        tableViewWithoutStanje.setItems(withoutStanje);
        
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("proizvod_id"));
        tableColumnTip.setCellValueFactory(new PropertyValueFactory<>("proizvod_tip"));
        tableColumnCena.setCellValueFactory(new PropertyValueFactory<>("proizvod_cena"));
        tableColumnKolicina.setCellValueFactory(new PropertyValueFactory<>("proizvod_kolicina"));
        tableColumnNaziv.setCellValueFactory(new PropertyValueFactory<>("proizvod_naziv"));
        
        tableColumnId2.setCellValueFactory(new PropertyValueFactory<>("proizvod_id"));
        tableColumnTip2.setCellValueFactory(new PropertyValueFactory<>("proizvod_tip"));
        tableColumnCena2.setCellValueFactory(new PropertyValueFactory<>("proizvod_cena"));
        tableColumnKolicina2.setCellValueFactory(new PropertyValueFactory<>("proizvod_kolicina"));
        tableColumnNaziv2.setCellValueFactory(new PropertyValueFactory<>("proizvod_naziv"));
        
    }    
    
}
