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
    private StringProperty proizvod_kolicina;
    private StringProperty proizvod_naziv;
    private BooleanProperty proizvod_check = new SimpleBooleanProperty(false);

    public Proizvod(int proizvod_id, int tip_id, double proizvod_cena, int proizvod_kolicina, String proizvod_naziv) {
        this.proizvod_id = new SimpleIntegerProperty(proizvod_id);
        this.tip_id = new SimpleStringProperty(crud.findNazivByIdInTipProizvoda(tip_id));
        this.tip_id_integer = new SimpleIntegerProperty(tip_id);
        this.proizvod_cena = new SimpleDoubleProperty(proizvod_cena);
        this.proizvod_kolicina = new SimpleStringProperty(""+0);
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
    
    public StringProperty proizvodKolicinaProperty(){
        return proizvod_kolicina;
    }
    
    public IntegerProperty proizvodStanjeProperty(){
        return proizvod_stanje;
    }
    
    public StringProperty proizvodNazivProperty(){
        return proizvod_naziv;
    }
    
    public BooleanProperty proizvodCheckProperty(){
        return proizvod_check;
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
    
    public String getProizvod_kolicina(){
        return this.proizvod_kolicina.get();
    }
    
    public void setProizvod_kolicina(String proizvod_kolicina){
        this.proizvod_kolicina.set(proizvod_kolicina);
    }

    public String getProizvod_naziv() {
        return proizvod_naziv.get();
    }

    public void setProizvod_naziv(String proizvod_naziv) {
        this.proizvod_naziv.set(proizvod_naziv);
    }
    
    public void setProizvod_check(Boolean proizvod_check){
        this.proizvod_check.set(proizvod_check);
    }
    
    public Boolean getProizvod_check(){
        return proizvod_check.get();
    }
    
       
}

