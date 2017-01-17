/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author dusan
 */
public class Nabavljac {
    
    private SimpleBooleanProperty nabavljaccheck = new SimpleBooleanProperty(false);
    private IntegerProperty nabavljac_id;
    private StringProperty nabavljac_ime;
    private StringProperty nabavljac_prezime;
    private StringProperty nabavljac_email;
    private StringProperty nabavljac_broj;
    private StringProperty nabavljac_adresa;

    public Nabavljac(int nabavljac_id, String nabavljac_ime, String nabavljac_prezime, String nabavljac_email, String nabavljac_broj, String nabavljac_adresa) {
        this.nabavljac_id = new SimpleIntegerProperty(nabavljac_id);
        this.nabavljac_ime = new SimpleStringProperty(nabavljac_ime);
        this.nabavljac_prezime = new SimpleStringProperty(nabavljac_prezime);
        this.nabavljac_email = new SimpleStringProperty(nabavljac_email);
        this.nabavljac_broj = new SimpleStringProperty(nabavljac_broj);
        this.nabavljac_adresa = new SimpleStringProperty(nabavljac_adresa);
    }
    
    public SimpleBooleanProperty nabavljaccheckProperty(){
        return nabavljaccheck;
    }
    
    public IntegerProperty nabavljacIdProperty(){
        return nabavljac_id;
    }
    
    public StringProperty nabavljacImeProperty(){
        return nabavljac_ime;
    }
    
    public StringProperty nabavljacPrezimeProperty(){
        return nabavljac_prezime;
    }
    
    public StringProperty nabavljacEmailProperty(){
        return nabavljac_email;
    }
    
    public StringProperty nabavljacBrojProperty(){
        return nabavljac_broj;
    }
    
    public StringProperty nabavljacAdresaProperty(){
        return nabavljac_adresa;
    }
    
    // Getter's and Setter's
    public Boolean getNabavljaccheck() {
        return nabavljaccheck.get();
    }

    public void setNabavljaccheck(Boolean nabavljac_check) {
        this.nabavljaccheck.set(nabavljac_check);
    }

    public int getNabavljac_id() {
        return nabavljac_id.get();
    }

    public void setNabavljac_id(int nabavljac_id) {
        this.nabavljac_id.set(nabavljac_id);
    }

    public String getNabavljac_ime() {
        return nabavljac_ime.get();
    }

    public void setNabavljac_ime(String nabavljac_ime) {
        this.nabavljac_ime.set(nabavljac_ime);
    }

    public String getNabavljac_prezime() {
        return nabavljac_prezime.get();
    }

    public void setNabavljac_prezime(String nabavljac_prezime) {
        this.nabavljac_prezime.set(nabavljac_prezime);
    }

    public String getNabavljac_email() {
        return nabavljac_email.get();
    }

    public void setNabavljac_email(String nabavljac_email) {
        this.nabavljac_email.set(nabavljac_email);
    }

    public String getNabavljac_broj() {
        return nabavljac_broj.get();
    }

    public void setNabavljac_broj(String nabavljac_broj) {
        this.nabavljac_broj.set(nabavljac_broj);
    }

    public String getNabavljac_adresa() {
        return nabavljac_adresa.get();
    }

    public void setNabavljac_adresa(String nabavljac_adresa) {
        this.nabavljac_adresa.set(nabavljac_adresa);
    }
    
    
    
    
    
}
