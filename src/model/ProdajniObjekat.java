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
public class ProdajniObjekat {
    
    private IntegerProperty objekat_id;
    private StringProperty objekat_naziv;
    private IntegerProperty objekat_brojKasa;

    public ProdajniObjekat() {
        
    }

    public ProdajniObjekat(int objekat_id, String objekat_naziv, int objekat_brojKasa) {
        this.objekat_id = new SimpleIntegerProperty(objekat_id);
        this.objekat_naziv = new SimpleStringProperty(objekat_naziv);
        this.objekat_brojKasa = new SimpleIntegerProperty(objekat_brojKasa);
    }

    public IntegerProperty objekatIdProperty(){
        return objekat_id;
    }
    
    public int getObjekat_id() {
        return objekat_id.get();
    }

    public void setObjekat_id(int objekat_id) {
        this.objekat_id.set(objekat_id);
    }
    
    public StringProperty objekatNazivProperty(){
        return objekat_naziv;
    }

    public String getObjekat_naziv() {
        return objekat_naziv.get();
    }

    public void setObjekat_naziv(String objekat_naziv) {
        this.objekat_naziv.set(objekat_naziv);
    }
    
    public IntegerProperty objekatBrojKasaProperty(){
        return objekat_brojKasa;
    }

    public int getObjekat_brojKasa() {
        return objekat_brojKasa.get();
    }

    public void setObjekat_brojKasa(int objekat_brojKasa) {
        this.objekat_brojKasa.set(objekat_brojKasa);
    }
    
    @Override
    public String toString(){
        return objekat_naziv.get();
    }
    
}