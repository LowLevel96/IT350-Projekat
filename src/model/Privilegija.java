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
public class Privilegija {
    
    private IntegerProperty privilegija_id;
    private StringProperty privilegija_naziv;
    private StringProperty privilegija_opis;

    public Privilegija(int privilegija_id, String privilegija_naziv, String privilegija_opis) {
        this.privilegija_id = new SimpleIntegerProperty(privilegija_id);
        this.privilegija_naziv = new SimpleStringProperty(privilegija_naziv);
        this.privilegija_opis = new SimpleStringProperty(privilegija_opis);
    }
    
    public IntegerProperty privilegijaIdProperty(){
        return privilegija_id;
    }
    
    public StringProperty privilegijaNazivProperty(){
        return privilegija_naziv;
    }
    
    public StringProperty privilegijaOpisProperty(){
        return privilegija_opis;
    }

    public int getPrivilegija_id() {
        return privilegija_id.get();
    }

    public void setPrivilegija_id(int privilegija_id) {
        this.privilegija_id.set(privilegija_id);
    }

    public String getPrivilegija_naziv() {
        return privilegija_naziv.get();
    }

    public void setPrivilegija_naziv(String privilegija_naziv) {
        this.privilegija_naziv.set(privilegija_naziv);
    }

    public String getPrivilegija_opis() {
        return privilegija_opis.get();
    }

    public void setPrivilegija_opis(String privilegija_opis) {
        this.privilegija_opis.set(privilegija_opis);
    }
    
    @Override
    public String toString(){
        return privilegija_naziv.get();
    }
    
    
    
}
