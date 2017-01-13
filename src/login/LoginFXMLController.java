/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import database.CRUD;
import it.pkg350.projekat.LoginStage;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainstage.MainStageJava;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class LoginFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private TextField textFieldEmail;
    @FXML private PasswordField passwordFieldPassword;
    @FXML private Label labelMessage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //buttonSignIn.setText("Dusan");
//         buttonSignIn.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("That was easy, wasn't it?");
//            }
//        });
    }
    
    public String returnEmpty(String email, String password){
        
        if(email.isEmpty()){
            return "Morate uneti email";
        }else if(password.isEmpty()){
            return "Morate uneti sifru";
        }
        
        return "";
    }
    
    public boolean isEmpty(String email, String password){
        
        if(email.isEmpty() || password.isEmpty()){
            return true;
        }else{
            return false;
        }
        
    }
   
    @FXML
    public void verifyUser(ActionEvent event){
        CRUD crud = new CRUD();
        String email = textFieldEmail.getText();
        String password = passwordFieldPassword.getText();
        
        if(!isEmpty(email, password)){
            int zaposleni_id = crud.verifyUser(email ,password);
            if(zaposleni_id != 0){
                UserFactory userFactory = UserFactory.getInstance();
                userFactory.setUser(crud.findUserById(zaposleni_id));
                //System.out.println(userFactory.getId() + "\n" + userFactory.getName() + "\n" + userFactory.getLastname());
                //System.out.println(userFactory.getTasks_list());
                MainStageJava msj = new MainStageJava(userFactory.getUser().getId(), userFactory.getUser().getIme(), userFactory.getUser().getPrezime(), userFactory.getUser().getLista());
                try {
                    msj.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
                LoginStage.classStage.close();
            }else{
                System.out.println("Pogresna mejl adresa ili sifra");
            }
        }else{
            labelMessage.setText(returnEmpty(email, password));
        }
    }
    
}
