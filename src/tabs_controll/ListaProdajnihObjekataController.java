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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ProdajniObjekat;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class ListaProdajnihObjekataController implements Initializable {

    CRUD crud = new CRUD();
    
    @FXML private TableView tableViewLista;
    @FXML private TableColumn<ProdajniObjekat, Integer> tableColumnId;
    @FXML private TableColumn<ProdajniObjekat, String> tableColumnNaziv;
    @FXML private TableColumn<ProdajniObjekat, Integer> tableColumnBrojKasa;
                                                        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshScene();
    }
    
    @FXML
    public void refreshScene(){
        ObservableList<ProdajniObjekat> data = crud.queryTipProdajnogObjekta();
        tableViewLista.setItems(data);
        
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("objekat_id"));
        tableColumnNaziv.setCellValueFactory(new PropertyValueFactory<>("objekat_naziv"));
        tableColumnBrojKasa.setCellValueFactory(new PropertyValueFactory<>("objekat_brojKasa"));
    }
    
}
