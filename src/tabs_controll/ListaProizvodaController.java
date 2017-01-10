/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabs_controll;

import database.CRUD;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import static javafx.scene.input.KeyCode.T;
import javafx.util.StringConverter;
import model.Proizvod;
import model.TextFieldListaProizvoda;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class ListaProizvodaController implements Initializable {

    CRUD crud = new CRUD();
    
    @FXML private TableView<Proizvod> tableViewLista;
    @FXML private TableColumn<Proizvod, Boolean> tableColumnCheck;
    @FXML private TableColumn<Proizvod, Integer> tableColumnId;
    @FXML private TableColumn<Proizvod, String> tableColumnTip;
    @FXML private TableColumn<Proizvod, Double> tableColumnCena;
    @FXML private TableColumn<Proizvod, Integer> tableColumnStanje;
    @FXML private TableColumn<Proizvod, Integer> tableColumnKolicina;
    @FXML private TableColumn<Proizvod, String> tableColumnNaziv;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Proizvod> listaProizvoda = crud.queryProizvod();
        listaProizvoda = listaProizvoda.stream().filter(p -> p.getProizvod_stanje() > 0).collect(Collectors.toCollection(FXCollections::observableArrayList));
        tableViewLista.setItems(listaProizvoda);
        
        tableViewLista.setEditable(true);
        
        tableColumnId.setCellValueFactory(new PropertyValueFactory("proizvod_id"));
        tableColumnTip.setCellValueFactory(new PropertyValueFactory("tip_id"));
        tableColumnCena.setCellValueFactory(new PropertyValueFactory("proizvod_cena"));
        tableColumnStanje.setCellValueFactory(new PropertyValueFactory("proizvod_stanje"));
        tableColumnKolicina.setCellValueFactory(new PropertyValueFactory("proizvod_kolicina"));
        tableColumnNaziv.setCellValueFactory(new PropertyValueFactory("proizvod_naziv"));
        
        tableColumnKolicina.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<String>() {
            @Override
            public String toString(String object) {
                 return object.toString();
            }

            @Override
            public String fromString(String string) {
                return (String) string;
            }
        }));
    }
    }
