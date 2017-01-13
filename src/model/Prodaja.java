/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.CRUD;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author dusan
 */
public class Prodaja {
    
    CRUD crud = new CRUD();
    
    private IntegerProperty prodaja_id;
    private IntegerProperty zaposleni_id;
    private IntegerProperty kasa_id;
    private IntegerProperty prodaja_kolicina;
    private DoubleProperty prodaja_cena;
    private StringProperty prodaja_datum;
    private DoubleProperty prodaja_porez;
    private StringProperty prodaja_zaposleni;

    public Prodaja(int prodaja_id, int zaposleni_id, int kasa_id, int prodaja_kolicina, double prodaja_cena, String prodaja_datum, double prodaja_porez) {
        this.prodaja_id = new SimpleIntegerProperty(prodaja_id);
        this.zaposleni_id = new SimpleIntegerProperty(zaposleni_id);
        this.kasa_id = new SimpleIntegerProperty(kasa_id);
        this.prodaja_kolicina = new SimpleIntegerProperty(prodaja_kolicina);
        this.prodaja_cena = new SimpleDoubleProperty(prodaja_cena);
        this.prodaja_datum = new SimpleStringProperty(prodaja_datum);;
        this.prodaja_porez = new SimpleDoubleProperty(prodaja_porez);
        this.prodaja_zaposleni = new SimpleStringProperty(crud.findZaposleniImeById(zaposleni_id));
    }
    
    // Properties
    
    public StringProperty getProdaja_zaosleni(){
        return prodaja_zaposleni;
    }

    public int getProdaja_id() {
        return prodaja_id.get();
    }

    public void setProdaja_id(int prodaja_id) {
        this.prodaja_id.set(prodaja_id);
    }

    public int getZaposleni_id() {
        return zaposleni_id.get();
    }

    public void setZaposleni_id(int zaposleni_id) {
        this.zaposleni_id.set(zaposleni_id);
    }

    public int getKasa_id() {
        return kasa_id.get();
    }

    public void setKasa_id(int kasa_id) {
        this.kasa_id.set(kasa_id);
    }

    public int getProdaja_kolicina() {
        return prodaja_kolicina.get();
    }

    public void setProdaja_kolicina(int prodaja_kolicina) {
        this.prodaja_kolicina.set(prodaja_kolicina);
    }

    public double getProdaja_cena() {
        return prodaja_cena.get();
    }

    public void setProdaja_cena(double prodaja_cena) {
        this.prodaja_cena.set(prodaja_cena);
    }

    public String getProdaja_datum() {
        return prodaja_datum.get();
    }

    public void setProdaja_datum(String prodaja_datum) {
        this.prodaja_datum.set(prodaja_datum);
    }

    public double getProdaja_porez() {
        return prodaja_porez.get();
    }

    public void setProdaja_porez(double prodaja_porez) {
        this.prodaja_porez.set(prodaja_porez);
    }
    
    public String getProdaja_zaposleni(){
        return prodaja_zaposleni.get();
    }
    
    public void setProdaja_zaposleni(String prodaja_zaposleni){
        this.prodaja_zaposleni.set(prodaja_zaposleni);
    }
    
}
