/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author dusan
 */
public class Kasa {
    
    private IntegerProperty kasa_id;
    private IntegerProperty kasa_objekat;
    private IntegerProperty objekat_id;

    public Kasa(int kasa_id, int kasa_objekat, int objekat_id) {
        this.kasa_id = new SimpleIntegerProperty(kasa_id);
        this.kasa_objekat = new SimpleIntegerProperty(kasa_objekat);
        this.objekat_id = new SimpleIntegerProperty(objekat_id);
    }
    
    // Properties
    public IntegerProperty kasaIdProperty(){
        return kasa_id;
    }
    
    public IntegerProperty kasaObjekatProperty(){
        return kasa_objekat;
    }
    
    public IntegerProperty objekatIdProperty(){
        return objekat_id;
    }
    
    // Get
    public int getKasaId(){
        return kasa_id.get();
    }
    
    public int getKasaObjekat(){
        return kasa_objekat.get();
    }
    
    public int getObjekatId(){
        return objekat_id.get();
    }
    
    // Set
    public void setKasaId(int kasa_id){
        this.kasa_id.set(kasa_id);
    }
    
    public void setKasaObjekat(int kasa_objekat){
        this.kasa_objekat.set(kasa_objekat);
    }
    
    public void setObjekatId(int objekat_id){
        this.objekat_id.set(objekat_id);
    }
    
    @Override
    public String toString(){
        return "" + kasa_objekat.get();
    }
    
    
}
