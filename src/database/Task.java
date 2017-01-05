/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Tab;

/**
 *
 * @author dusan
 */
public class Task {

    ArrayList<Tab> tasks = new ArrayList<Tab>();

    public Task() {
    
    }

    public ArrayList<Tab> getList(){
        return tasks;
    }


    public void setList(ArrayList<Tab> javaObject){
        this.tasks = javaObject;
    }


    public byte[] serializeTasks(){
        byte[] data = null;
        try{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(tasks);
        oos.flush();
        oos.close();
        bos.close();

        data = bos.toByteArray();

        }catch(Exception e){
            e.printStackTrace();
        }
        
        return data;
    }
    
     public ArrayList<Tab> deserializeTasks(int privilegija_id){
        ArrayList<Tab> tasks = null;
        try {
            
            Connection con = MysqlDatabase.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = null;
            //int id = 9; // Get this from somewhere
            
            sql = "select privilegija_lista from privilegija where privilegija_id = ?";
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, privilegija_id);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                ByteArrayInputStream bais;
                ObjectInputStream ins;
                
                try {
                    
                    bais = new ByteArrayInputStream(rs.getBytes("privilegija_lista"));
                    ins = new ObjectInputStream(bais);
                    
                    tasks = (ArrayList<Tab>)ins.readObject();
                    
                    //System.out.println("Object in value ::"+tasks.get());
                    ins.close();
                    
                }
                catch (Exception e) {
                    
                    e.printStackTrace();
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tasks;
    }
    
}

