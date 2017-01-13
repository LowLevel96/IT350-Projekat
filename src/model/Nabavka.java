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
public class Nabavka {
    
    private IntegerProperty nabavka_id;
    private IntegerProperty nabavljac_id;
    private IntegerProperty nabavka_kolicina;
    private StringProperty nabavka_datum;

    public Nabavka(int nabavka_id, int nabavljac_id,int nabavka_kolicina, String nabavka_datum) {
        this.nabavka_id = new SimpleIntegerProperty(nabavka_id);
        this.nabavljac_id = new SimpleIntegerProperty(nabavljac_id);
        this.nabavka_kolicina = new SimpleIntegerProperty(nabavka_kolicina);
        this.nabavka_datum = new SimpleStringProperty(nabavka_datum);
    }
    public IntegerProperty nabavkaIdProperty(){
        return nabavka_id;
    }
    public IntegerProperty nabavljacIdProperty(){
        return nabavljac_id;
    }
    public IntegerProperty nabavkaKolicinaProperty(){
        return nabavka_kolicina;
    }
    public StringProperty nabavkaDatumProperty(){
        return nabavka_datum;
    } 
    //getters and setters
    public int getNabavka_id() {
        return nabavka_id.get();
    }
    public void setNabavka_id(int nabavka_id) {
        this.nabavka_id.set(nabavka_id);
    }

    public int getNabavljac_id() {
        return nabavljac_id.get();
    }

    public void setNabavljac_id(int nabavljac_id) {
        this.nabavljac_id.set(nabavljac_id);
    }

    public int getNabavka_kolicina() {
        return nabavka_kolicina.get();
    }

    public void setNabavka_kolicina(int nabavka_kolicina) {
        this.nabavka_kolicina.set(nabavka_kolicina);
    }

    public String getNabavka_datum() {
        return nabavka_datum.get();
    }

    public void setNabavka_datum(String nabavka_datum) {
        this.nabavka_datum.set(nabavka_datum);
    }

    
}
