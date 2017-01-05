/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dusan
 */
public class MysqlDatabase {

    private static Connection instance;
    
    private MysqlDatabase() {
        
    }
    
    public static Connection getConnection(){
        
        if(instance == null){
            try {
            Class.forName("com.mysql.jdbc.Driver");
            instance = DriverManager.getConnection("jdbc:mysql://localhost:3306/it350-noviprojekat?autoReconnect=true&useSSL=false","root","");
            
            } catch (ClassNotFoundException ex) {

            } catch (SQLException ex) {
                Logger.getLogger(MysqlDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return instance;
    }
    


}
