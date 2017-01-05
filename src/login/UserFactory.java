/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import model.User;
import database.CRUD;
import database.Task;
import java.util.ArrayList;
import javafx.scene.control.Tab;

/**
 *
 * @author dusan
 */
public class UserFactory {
    
    private int id;
    private String name;
    private String lastname;
    private int privilegija_id;
    private ArrayList<String> tasks_list = new ArrayList<String>();
    
    public UserFactory(User user) {
        this.name = user.getIme();
        this.lastname = user.getPrezime();
        this.id = user.getId();
        this.privilegija_id = user.getPrivilegija_idIntger();
        //this.tasks_list = getListOfTasksCRUD();
    }
    
    private ArrayList<Tab> getListOfTasksCRUD(){
        CRUD crud = new CRUD();
        Task task = new Task();
        
        System.out.println(privilegija_id);
        return task.deserializeTasks(privilegija_id);
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Tab> getTasks_list() {
        return tasks_list;
    }

    public void setTasks_list(ArrayList<Tab> tasks_list) {
        this.tasks_list = tasks_list;
    }

}
