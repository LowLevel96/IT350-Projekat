/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainstage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class OneTabTestController implements Initializable {

    @FXML
    public Tab tabtest;
    @FXML private Button btnClick;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Jeste->"+tabtest);
    }

    @FXML
    public void printHello(ActionEvent event){
        System.out.println("Hello World!");
    }
    
    public Tab getTab(){
        if(tabtest==null){
            System.out.println("Null je");
            return null;
        }
        System.out.println("Nije null");
        return tabtest;
    }
    
}
