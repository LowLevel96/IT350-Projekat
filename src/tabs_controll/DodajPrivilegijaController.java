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
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import model.TaskModel;
import java.lang.Boolean;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class DodajPrivilegijaController implements Initializable {

    @FXML private TextField txtNaziv;
    @FXML private TextField txtOpis;
    @FXML private Button btnDodaj;
    
    CRUD crud = new CRUD();
    
    @FXML private TableView<TaskModel> tableViewTask;
    @FXML private TableColumn<TaskModel, Integer> tableColumnId;
    @FXML private TableColumn<TaskModel, String> tableColumnNaziv;
    @FXML private TableColumn<TaskModel, String> tableColumnFile;
    @FXML private TableColumn<TaskModel, Boolean> tableColumnCheck;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<TaskModel> data = crud.queryTask();
        
        //System.out.println(data.get(1).taskcheckProperty());
        
        tableViewTask.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableViewTask.getSelectionModel().setCellSelectionEnabled(true);
        //ObservableList selectedCells = tableViewTask.getSelectionModel().getSelectedCells();

        
        tableViewTask.setItems(data);
        tableViewTask.setEditable(true);
        
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("task_id"));
        tableColumnNaziv.setCellValueFactory(new PropertyValueFactory<>("task_naziv"));
        tableColumnFile.setCellValueFactory(new PropertyValueFactory<>("task_file"));
        
        //tableColumnCheck.setCellValueFactory(new PropertyValueFactory<>("taskcheck")); 
        //tableColumnCheck.setCellFactory(CheckBoxTableCell.forTableColumn(tableColumnCheck)); 
        //tableColumnCheck.setCellValueFactory(new PropertyValueFactory<TaskModel, Boolean>("taskcheck"));
        //tableColumnCheck.setCellFactory(CheckBoxCellFactory.forTableColumn(tableColumnCheck));
    }    
    
    @FXML
    public void dodajPrivilegija(){
        ArrayList<TaskModel> list = new ArrayList<>();
        for(TaskModel task : tableViewTask.getItems()){
            if(task.getTaskcheck()){
                list.add(task);
            }
        }   
        crud.insertInPrivilegija(txtNaziv.getText(), txtOpis.getText(), list);
    }
    
}


// <TableColumn fx:id="tableColumnCheck" prefWidth="75.0" />
//<PropertyValueFactory property="taskcheck" />



//<TableColumn fx:id="checkBoxTableColumn" maxWidth="34.0" minWidth="26.0" prefWidth="34.0" resizable="false" sortable="false">   
//                    <cellValueFactory><PropertyValueFactory property="taskcheck" /></cellValueFactory>
//                    <cellFactory><model.CheckBoxCellFactory /></cellFactory>
//                    </TableColumn>