/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabs_controll;

import database.CRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import mainstage.MainStageController;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class DodajProdajniObjekatController implements Initializable {

    
    @FXML private TextField txtNaziv;
    @FXML private TextField txtBrojKasa;
    @FXML private Button btnDodaj;
    @FXML private Label labelMessage;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void dodajProdajniObjekat(){
        
        CRUD crud = new CRUD();
        
        String naziv = txtNaziv.getText();
        int brojKasa = Integer.parseInt(txtBrojKasa.getText());
        
        String message = crud.insertIntoProdajniObjekat(naziv, brojKasa);
        labelMessage.setText(message);
    }
    
}
