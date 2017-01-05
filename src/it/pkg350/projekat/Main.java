/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pkg350.projekat;

import database.CRUD;
import database.Task;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.control.Tab;

/**
 *
 * @author dusan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LoginStage mainStage = new LoginStage();
        
        ArrayList<Tab> al = new ArrayList<Tab>();
        //al.add(new UsersList());
        
        CRUD crud = new CRUD();
        crud.insertInZaposleni(1, "Zoki", "Zokic", "zoki@gmail.com", "123456", "Zokanovac", "Zokce", "7. Zokcic 8/6");
        crud.insertInPrivilegija("Administrator", "Administrator ima dozvole za dodavanje novih privilegija, kao i zaposlenih.", al);
        
        // This would go in Login Controll class
//        if(crud.verifyUser("zoki@gmail.com2", "123456")){
//            System.out.println("User is logged in!");
//        }else{
//            System.out.println("Wrong email or password. Try again, please!");
//        }
        
        
        
        /*
        ArrayList<Tab> al = new ArrayList<Tab>();
        al.add(new UsersList());
        //al.add("Dusan");
        //al.add("Aleksandar");
        
        //Tab ds = (UsersList)new UsersList();
        
        Task so = new Task();
        
        //so.setList(al);
        //so.saveTasks();
        
        ArrayList<Tab> al2 = so.getTasks();
        if(al2.isEmpty()){
            System.out.println("Prazno");
        }else{
            System.out.println("Nije prazno");
            for (Iterator<Tab> iterator = al2.iterator(); iterator.hasNext();) {
                Tab next = iterator.next();
            }
        }
        */
    }
    
}
