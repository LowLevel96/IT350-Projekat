
import database.CRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DodajNabavljacaController implements Initializable {
    CRUD crud = new CRUD();

    @FXML private TextField txtIme;
    @FXML private TextField txtPrezime;
    @FXML private TextField txtEmail;
    @FXML private TextField txtBroj;
    @FXML private TextField txtAdresa;    
    @FXML private Button btnDodaj;
    @FXML private Label labelMessage;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }   



    @FXML public void dodajNabavljaca(ActionEvent evenet){

        String ime = txtIme.getText();
        String prezime = txtPrezime.getText();
        String email = txtEmail.getText();
        String broj = txtBroj.getText();
        String adresa = txtAdresa.getText();


        String message = crud.insertIntoNabavljac(ime, prezime, email, broj, adresa);
        labelMessage.setText(message);
    }

    
}
