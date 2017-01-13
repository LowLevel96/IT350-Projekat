/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pkg350.projekat;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author dusan
 */
public class LoginStage extends Application{

    public static Stage classStage = new Stage();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        classStage = primaryStage;
        
        Parent root = FXMLLoader.load(getClass().getResource("/login/LoginFXML.fxml"));
        primaryStage.setTitle("Welcome to POS");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
