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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Privilegija;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class AddUserController implements Initializable {

    CRUD crud = new CRUD();
    
    @FXML private ComboBox<Privilegija> comboPrivilegija;
    @FXML private TextField txtIme;
    @FXML private TextField txtPrezime;
    @FXML private TextField txtEmail;
    @FXML private PasswordField passSifra;
    @FXML private TextField txtOpstina;
    @FXML private TextField txtGrad;
    @FXML private TextField txtUlica;
    @FXML private Button btnDodaj;
    @FXML private Label labelMessage;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Privilegija> data = crud.queryPrivilegija();
        comboPrivilegija.setItems(data);
    }
    
    @FXML
    public void dodajZaposlenog(ActionEvent event){
        
        Privilegija selected = comboPrivilegija.getSelectionModel().getSelectedItem();

        int privilegija_id =  selected.getPrivilegija_id();
        String ime = txtIme.getText();
        String prezime = txtPrezime.getText();
        String email = txtEmail.getText();
        String password = passSifra.getText();
        String opstina = txtOpstina.getText();
        String grad = txtGrad.getText();
        String ulica = txtUlica.getText();
        
        String message = crud.insertInZaposleni(privilegija_id, ime, prezime, email, password, opstina, grad, ulica);
        labelMessage.setText(message);
        
    }
    
}
