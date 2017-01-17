/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainstage;

import database.CRUD;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.TaskModel;
import register_computer.RegisterFile;

/**
 *
 * @author dusan
 */
public class MainStageJava extends Application {
    
    CRUD crud = new CRUD();
    
    private int id;
    private String name;
    private String lastname;
    private ObservableList<TaskModel> list;
    private String broj_kasa = new RegisterFile().readFromFile();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
               "MainStage.fxml"));
        TabPane root =  loader.load();
        MainStageController msc = loader.getController();
        
        
//        ArrayList<Integer> listaTaskova = new ArrayList<>();
//        listaTaskova.add(1);
//        listaTaskova.add(3);
//        listaTaskova.add(7);
        FXMLLoader loader2;
//        for (Iterator<TaskModel> iterator = list.iterator(); iterator.hasNext();) {
//            TaskModel next = iterator.next();
//            loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/" + next.getTask_file()));
//            Tab root2 =  loader2.load();
//            root.getTabs().add(root2);
//            
//        }
        
        
        loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/AddUserTab.fxml"));
        Tab root2 =  loader2.load();
        root.getTabs().add(root2);
        
        loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/ListaZaposlenihTab.fxml"));
        root2 = loader2.load();
        root.getTabs().add(root2);
         
        loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/DodajProizvodTab.fxml"));
        root2 = loader2.load();
        root.getTabs().add(root2);
        
        loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/DodajProdajniObjekatTab.fxml"));
        root2 = loader2.load();
        root.getTabs().add(root2);
        
        loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/ListaProdajnihObjekataTab.fxml"));
        root2 = loader2.load();
        root.getTabs().add(root2);
        
        loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/RegisterComputerTab.fxml"));
        root2 = loader2.load();
        root.getTabs().add(root2);
        
        loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/ListaTaskovaTab.fxml"));
        root2 = loader2.load();
        root.getTabs().add(root2);
        
        loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/DodajPrivilegijaTab.fxml"));
        root2 = loader2.load();
        root.getTabs().add(root2);
        
        loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/StanjeMagacinaTab.fxml"));
        root2 = loader2.load();
        root.getTabs().add(root2);
       
        loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/ListaProizvodaTab.fxml"));
        root2 = loader2.load();
        root.getTabs().add(root2);
    
        loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/DnevniIzvestajTab.fxml"));
        root2 = loader2.load();
        root.getTabs().add(root2);
        
        loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/NabavkaTab.fxml"));
        root2 = loader2.load();
        root.getTabs().add(root2);
//        
        loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/ListaProizvodaTab.fxml"));
        root2 = loader2.load();
        root.getTabs().add(root2);
        Object ottc = loader2.getController();
        
        loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/DodajNabavljacaTab.fxml"));
        root2 = loader2.load();
        root.getTabs().add(root2);
        
        loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/ZahtevaniUpitiTab.fxml"));
        root2 = loader2.load();
        root.getTabs().add(root2);
        
        loader2 = new FXMLLoader(getClass().getResource("/tabs_tasks/ProdajniObjekatPrihodTab.fxml"));
        root2 = loader2.load();
        root.getTabs().add(root2);
        
//        root.getTabs().add(root2);
//        
//        loader2 = new FXMLLoader(getClass().getResource("OneTabTest.fxml"));
//        root2 = loader2.load();
//        ottc = loader2.getController();
        
        
        
        
        primaryStage.setTitle("Welcome " + name + ", Kasa broj: " + broj_kasa);
        primaryStage.setScene(new Scene(root,1200,900));
        primaryStage.show();
        
    }

//    public MainStageJava(int id, String name, String lastname, ObservableList<TaskModel> list) {
//        this.id = id;
//        this.name = name;
//        this.lastname = lastname;
//        this.list = list;
//    }

    public static void main(String[] args) {
        launch(args);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
     
    
}
