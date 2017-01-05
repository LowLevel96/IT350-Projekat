/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mongodb.MongoClient;



/**
 *
 * @author dusan
 */
public class MongoDatabase {
    
    private static MongoClient instance;
    
    private MongoDatabase() {
        
    }
    
    public static MongoClient getConnection(){
        
        if(instance == null){
            instance = new MongoClient();
        }
        
        return instance;
    }
    
}
