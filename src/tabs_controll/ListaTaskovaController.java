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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.TaskModel;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class ListaTaskovaController implements Initializable {

    CRUD crud = new CRUD();
    
    @FXML private TableView<TaskModel> tableViewTask;
    @FXML private TableColumn<TaskModel, Integer> tableColumnId;
    @FXML private TableColumn<TaskModel, String> tableColumnNaziv;
    @FXML private TableColumn<TaskModel, String> tableColumnFile;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<TaskModel> data = crud.queryTask();
        
        tableViewTask.setItems(data);
        
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("task_id"));
        tableColumnNaziv.setCellValueFactory(new PropertyValueFactory<>("task_naziv"));
        tableColumnFile.setCellValueFactory(new PropertyValueFactory<>("task_file"));
        
    }    
    
}
