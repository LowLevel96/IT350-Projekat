/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainstage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class MainStageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML TabPane tabPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //tabPane.getTabs().add(new Tab("First"));
        System.out.println("Uslo");
    }

    public void addTab(Tab tab){
        System.out.println("Uslo2");
        //tabPane.getTabs().add(tab);
    }
    
}
