/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author dusan
 */
public class TaskModel {
    
    private SimpleBooleanProperty taskcheck = new SimpleBooleanProperty(false);;
    private IntegerProperty task_id;
    private StringProperty task_naziv;
    private StringProperty task_file;

    public TaskModel(int task_id, String task_naziv, String task_file) {
        this.task_id = new SimpleIntegerProperty(task_id);
        this.task_naziv = new SimpleStringProperty(task_naziv);
        this.task_file = new SimpleStringProperty(task_file);
    }
    
    // Properties
    public IntegerProperty taskIdProperty(){
        return task_id;
    }
    
    public StringProperty taskNazivProperty(){
        return task_naziv;
    }
    
    public StringProperty taskFileProperty(){
        return task_file;
    }
    
    public SimpleBooleanProperty taskcheckProperty(){
        return taskcheck;
    }
    
    // Getter And Setter
    public int getTask_id() {
        return task_id.get();
    }

    public void setTask_id(int task_id) {
        this.task_id.set(task_id);
    }

    public String getTask_naziv() {
        return task_naziv.get();
    }

    public void setTask_naziv(String task_naziv) {
        this.task_naziv.set(task_naziv);
    }

    public String getTask_file() {
        return task_file.get();
    }

    public void setTask_file(String task_file) {
        this.task_file.set(task_file);
    }
    
    public Boolean getTaskcheck(){
        return taskcheck.get();
    }
    
    public void setTaskcheck(Boolean checked){
        taskcheck.set(checked);
    }

}
