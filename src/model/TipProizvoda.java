/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author dusan
 */
public class TipProizvoda {
    
    private IntegerProperty tip_id;
    private StringProperty tip_ime;

    public TipProizvoda(int tip_id, String tip_ime) {
        this.tip_id = new SimpleIntegerProperty(tip_id);
        this.tip_ime = new SimpleStringProperty(tip_ime);
    }

    public int getTip_id() {
        return tip_id.get();
    }

    public void setTip_id(int tip_id) {
        this.tip_id.set(tip_id);
    }

    public String getTip_ime() {
        return tip_ime.get();
    }

    public void setTip_ime(String tip_ime) {
        this.tip_ime.set(tip_ime);
    }
    
    @Override
    public String toString(){
        return tip_ime.get();
    }
    
}
