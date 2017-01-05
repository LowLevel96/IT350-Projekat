/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabs_controll;

import database.CRUD;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import model.Kasa;
import model.ProdajniObjekat;
import register_computer.RegisterFile;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class RegisterComputerController implements Initializable {

    CRUD crud = new CRUD();
    RegisterFile file = new RegisterFile();
    int kasa_id;
    
    @FXML private ComboBox<ProdajniObjekat> comboBoxObjekat;
    @FXML private ComboBox<Kasa> comboBoxKasa;
    @FXML private Label labelMessage;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<ProdajniObjekat> objekatData = crud.queryTipProdajnogObjekta();
        comboBoxObjekat.setItems(objekatData);
        //comboBoxObjekat.getSelectionModel().selectedItemProperty().addListener(new ChangeListenerImpl());
    }
    
    @FXML
    public void izaberiObjekat(ActionEvent event){
        ProdajniObjekat selected = comboBoxObjekat.getSelectionModel().getSelectedItem();
        ObservableList<Kasa> kasaData = crud.queryKasa(selected.getObjekat_id());
        comboBoxKasa.setItems(kasaData);
    }
    
    @FXML void izaberiKasu(ActionEvent event){
        Kasa selected = comboBoxKasa.getSelectionModel().getSelectedItem();
        kasa_id = selected.getKasaId();
        System.out.println(kasa_id);
    }
    
    @FXML
    public void sacuvajObjekat(){
        file.writeToFile("" + kasa_id);
        labelMessage.setText("Uspesno ste sacuvali");
    }

    
}
