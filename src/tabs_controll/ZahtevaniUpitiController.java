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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class ZahtevaniUpitiController implements Initializable {

    CRUD crud = new CRUD();
    
    @FXML private Label labelNajboljiProdavacUMesecu;
    @FXML private Label labelUkupanPrihodZaSvakiObjekatZaMesecDana;
    @FXML private Label labelNabavljacNajprodavanijegProizvoda;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       labelNajboljiProdavacUMesecu.setText(crud.findZaposleniImeById(crud.findNajboljiProdavacUmesecu()));
       labelNabavljacNajprodavanijegProizvoda.setText(crud.findNabavljacById(crud.findNabavljacNajprodavanijeProizvoda()));
    }    
    
}
