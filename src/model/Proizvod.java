/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.CRUD;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author dusan
 */
public class Proizvod {
    CRUD crud = new CRUD();
    private IntegerProperty proizvod_id;
    private StringProperty tip_id;
    private IntegerProperty tip_id_integer;
    private DoubleProperty proizvod_cena;
    private IntegerProperty proizvod_stanje;
    private String proizvodkolicina;
    private StringProperty proizvod_naziv;
    private SimpleBooleanProperty proizvodcheck = new SimpleBooleanProperty(false);

    public Proizvod() {
    
    }

    public Proizvod(int proizvod_id, int tip_id, double proizvod_cena, int proizvod_kolicina, String proizvod_naziv) {
        this.proizvod_id = new SimpleIntegerProperty(proizvod_id);
        this.tip_id = new SimpleStringProperty(crud.findNazivByIdInTipProizvoda(tip_id));
        this.tip_id_integer = new SimpleIntegerProperty(tip_id);
        this.proizvod_cena = new SimpleDoubleProperty(proizvod_cena);
        //this.proizvodkolicina = new SimpleStringProperty(""+1);
        this.proizvodkolicina = ""+1;
        this.proizvod_stanje= new SimpleIntegerProperty(proizvod_kolicina);
        this.proizvod_naziv = new SimpleStringProperty(proizvod_naziv);
    }

    // Properties
    public IntegerProperty proizvodIdProperty(){
        return proizvod_id;
    }
    
    public StringProperty tipIdProperty(){
        return tip_id;
    }
    
    public IntegerProperty tipIdIntegerProperty(){
        return tip_id_integer;
    }
    
    public DoubleProperty proizvodCenaProperty(){
        return proizvod_cena;
    }
    
    public String proizvodkolicinaProperty(){
        return proizvodkolicina;
    }
    
    public IntegerProperty proizvodStanjeProperty(){
        return proizvod_stanje;
    }
    
    public StringProperty proizvodNazivProperty(){
        return proizvod_naziv;
    }
    
    public SimpleBooleanProperty proizvodcheckProperty(){
        return proizvodcheck;
    }
    
    // Getters and Setters
    public int getProizvod_id() {
        return proizvod_id.get();
    }

    public void setProizvod_id(int proizvod_id) {
        this.proizvod_id.set(proizvod_id);
    }

    public String getTip_id() {
        return tip_id.get();
    }

    public void setTip_id(String tip_id) {
        this.tip_id.set(tip_id);
    }

    public double getProizvod_cena() {
        return proizvod_cena.get();
    }

    public void setProizvod_cena(double proizvod_cena) {
        this.proizvod_cena.set(proizvod_cena);
    }

    public int getProizvod_stanje() {
        return proizvod_stanje.get();
    }

    public void setProizvod_stanje(int proizvod_stanje) {
        this.proizvod_stanje.set(proizvod_stanje);
    }
    
    public String getProizvodkolicina(){
        return this.proizvodkolicina;
    }
    
    public void setProizvodkolicina(String proizvod_kolicina){
        this.proizvodkolicina = proizvod_kolicina;
    }

    public String getProizvod_naziv() {
        return proizvod_naziv.get();
    }

    public void setProizvod_naziv(String proizvod_naziv) {
        this.proizvod_naziv.set(proizvod_naziv);
    }
    
    public void setProizvodcheck(Boolean proizvod_check){
        this.proizvodcheck.set(proizvod_check);
    }
    
    public Boolean getProizvodcheck(){
        return proizvodcheck.get();
    }
    
    
       
}

