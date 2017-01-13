/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import model.User;
import database.CRUD;
import java.util.ArrayList;
import javafx.scene.control.Tab;

/**
 *
 * @author dusan
 */
public class UserFactory {
    
    private User user;
    private static UserFactory instance = null;

    private UserFactory() {
        
    }
    
    public static UserFactory getInstance(){
        if(instance == null){
            instance = new UserFactory();
        }
        return instance;
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
    public User getUser(){
        return this.user;
    }
    

}
