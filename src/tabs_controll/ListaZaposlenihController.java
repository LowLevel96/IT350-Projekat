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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.User;
import model.ProdajniObjekat;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class ListaZaposlenihController implements Initializable {
    
    CRUD crud = new CRUD();

    @FXML private TableView<User> tableViewZaposleni;
    @FXML private TableColumn<User, Integer> tableColumnId;
    @FXML private TableColumn<User, String> tableColumnIme;
    @FXML private TableColumn<User, String> tableColumnPrezime;
    @FXML private TableColumn<User, String> tableColumnPrivilegija;
    @FXML private TableColumn<User, String> tableColumnEmail;
    @FXML private TableColumn<User, String> tableColumnAdresa;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         initMethod();
    }
    
    public void initMethod(){
        ObservableList<User> data = crud.queryZaposleni();
        tableViewZaposleni.setItems(data);
        
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        tableColumnPrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        tableColumnPrivilegija.setCellValueFactory(new PropertyValueFactory<>("privilegija_id"));
        tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableColumnAdresa.setCellValueFactory(new PropertyValueFactory<>("adresa")); 
    }
    
    @FXML
    public void refreshScene(){
        initMethod();
    }
    
    
    
}
