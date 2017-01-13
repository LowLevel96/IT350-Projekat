/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.CRUD;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author dusan
 */
public class User {
    
    CRUD crud = new CRUD();
    
    private IntegerProperty id;
    private StringProperty privilegija_id;
    private StringProperty ime2;
    private StringProperty prezime;
    private StringProperty email;
    private StringProperty opstina;
    private StringProperty grad;
    private StringProperty ulica;
    private StringProperty adresa;
    private ObservableList<TaskModel> lista = FXCollections.observableArrayList();
    private int privilegija_idInteger;

    public User(int id, int privilegija_id, String ime, String prezime, String email, String opstina, String grad, String ulica, ObservableList<TaskModel> lista) {
        this.id = new SimpleIntegerProperty(id);
        this.privilegija_id = new SimpleStringProperty(crud.findNazivByIdInPrivilegija(privilegija_id));
        this.ime2 = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.email = new SimpleStringProperty(email);
        this.opstina = new SimpleStringProperty(opstina);
        this.grad = new SimpleStringProperty(grad);
        this.ulica = new SimpleStringProperty(ulica);
        this.adresa = new SimpleStringProperty(opstina + ", " + grad + ", " + ulica);
        this.privilegija_idInteger = privilegija_id;
        this.lista = lista;
    }
    
    // Properties
    public IntegerProperty idProperty(){
        return id;
    }
    
    public StringProperty privilegijaIdProperty(){
        return privilegija_id;
    }
    
    public StringProperty imeProperty(){
        return ime2;
    }
    
    public StringProperty prezimeProperty(){
        return prezime;
    }
    
    public StringProperty emailProperty(){
        return email;
    }
    
    public StringProperty opstinaProperty(){
        return opstina;
    }
    
    public StringProperty gradProperty(){
        return grad;
    }
    
    public StringProperty ulicaProperty(){
        return ulica;
    }
    
    public StringProperty adresaProperty(){
        return adresa;
    }
    
    // Getter and Setters
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getPrivilegija_id() {
        return privilegija_id.get();
    }
    
    public int getPrivilegija_idIntger(){
        return privilegija_idInteger;
    }

    public void setPrivilegija_id(String privilegija_id) {
        this.privilegija_id.set(privilegija_id);
    }

    public String getIme() {
        return ime2.get();
    }

    public void setIme(String ime) {
        this.ime2.set(ime);
    }

    public String getPrezime() {
        return prezime.get();
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getOpstina() {
        return opstina.get();
    }

    public void setOpstina(String opstina) {
        this.opstina.set(opstina);
    }

    public String getGrad() {
        return grad.get();
    }

    public void setGrad(String grad) {
        this.grad.set(grad);
    }

    public String getUlica() {
        return ulica.get();
    }

    public void setUlica(String ulica) {
        this.ulica.set(ulica);
    }
    
    public String getAdresa(){
        return adresa.get();
    }

    public ObservableList<TaskModel> getLista() {
        return lista;
    }

    public void setLista(ObservableList<TaskModel> lista) {
        this.lista = lista;
    }
    
}
