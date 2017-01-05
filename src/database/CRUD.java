/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import model.User;
import model.Kasa;
import model.Privilegija;
import model.ProdajniObjekat;
import model.Proizvod;
import model.TaskModel;
import model.TipProizvoda;

/**
 *
 * @author dusan
 */
public class CRUD {
    
    Connection con = MysqlDatabase.getConnection();

    public CRUD() {
    
    }
    
    public int findPrivilegijaIdByUserId(int id){
        try {
            String sql = "SELECT privilegija_id FROM Zaposleni WHERE zaposleni_id=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                return rs.getInt("privilegija_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public String insertInZaposleni(int privilegija_id, String zaposleni_ime, String zaposleni_prezime, String zaposleni_email, String zaposleni_password, String zaposleni_opstina, String zaposleni_grad, String zaposleni_ulica){
        if(findByEmailInZaposleni(zaposleni_email) == 0){
            try {
                 String sql = "INSERT INTO Zaposleni (privilegija_id, zaposleni_ime, zaposleni_prezime, zaposleni_email, zaposleni_password, zaposleni_opstina, zaposleni_grad, zaposleni_ulica) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                 PreparedStatement statement = con.prepareStatement(sql);
                 statement.setInt(1, privilegija_id);
                 statement.setString(2, zaposleni_ime);
                 statement.setString(3, zaposleni_prezime);
                 statement.setString(4, zaposleni_email);
                 statement.setString(5, zaposleni_password);
                 statement.setString(6, zaposleni_opstina);
                 statement.setString(7, zaposleni_grad);
                 statement.setString(8, zaposleni_ulica);

                 int rowsInserted = statement.executeUpdate();
                 if (rowsInserted > 0) {
                     return "A new user was inserted successfully!";
                 }else{
                     return "Something happened!";
                 }
            } catch (SQLException ex) {
                 Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        return "User already exist!";
    }
    
    public void insertInPrivilegija(String privilegija_naziv, String privilegija_opis, ArrayList<TaskModel> listOfTasks){
        
        if(findByNazivInPrivilegija(privilegija_naziv) == 0){
        
        try {
            String sql = "INSERT INTO privilegija (privilegija_naziv, privilegija_opis) VALUES (?, ?)";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, privilegija_naziv);
            statement.setString(2, privilegija_opis);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if(generatedKeys.next()){
                    int privilegija_id = generatedKeys.getInt(1);
                    
                    for (Iterator<TaskModel> iterator = listOfTasks.iterator(); iterator.hasNext();) {
                        TaskModel next = iterator.next();
                        insertIntoPrivilegijaLista(next, privilegija_id);
                    }
                    System.out.println("A new role was inserted successfully!");
                }
                
            }else{
                System.out.println("Something happened!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            System.out.println("Role with this name already exist!");
        }
    }
    
    public void insertIntoPrivilegijaLista(TaskModel task, int privilegija_id){
        try {
            String sql = "INSERT INTO privilegijalista (task_id, privilegija_id) VALUES (?, ?)";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, task.getTask_id());
            statement.setInt(2, privilegija_id);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                
            }else{
                System.out.println("Something happened!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int findByEmailInZaposleni(String email){
        try {
            String sql = "SELECT * FROM Zaposleni WHERE zaposleni_email=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, email);

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                return rs.getInt("zaposleni_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int findByNazivInPrivilegija(String privilegija_naziv){
        try {
            String sql = "SELECT * FROM Privilegija WHERE privilegija_naziv=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, privilegija_naziv);

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                return rs.getInt("privilegija_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public String findNazivByIdInPrivilegija(int privilegija_id){
        try {
            String sql = "SELECT privilegija_naziv FROM Privilegija WHERE privilegija_id=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, privilegija_id);

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                return rs.getString("privilegija_naziv");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String findFileByTaskIdInPrivilegijaLista(int task_id){
        try {
            String sql = "SELECT task_fajl FROM task WHERE task_id=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, task_id);

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                return rs.getString("task_fajl");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int verifyUser(String email, String password){
        try {
            String sql = "SELECT zaposleni_id, privilegija_id FROM Zaposleni WHERE zaposleni_email=? AND zaposleni_password=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                return rs.getInt("zaposleni_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public User findUserById(int id){
        try {
            String sql = "SELECT * FROM Zaposleni WHERE zaposleni_id=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                int user_id = rs.getInt("zaposleni_id");
                int privilegija_id = rs.getInt("privilegija_id");
                String name = rs.getString("zaposleni_ime");
                String lastname = rs.getString("zaposleni_prezime");
                String email = rs.getString("zaposleni_email");
                String state = rs.getString("zaposleni_opstina");
                String city = rs.getString("zaposleni_grad");
                String street = rs.getString("zaposleni_ulica");
                return new User(user_id, privilegija_id, name, lastname, email, state, city, street);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String insertIntoProizvod(int tip_id, String naziv, double cena){
        try {
                 String sql = "INSERT INTO Proizvod (tip_id, proizvod_naziv, proizvod_cena, proizvod_kolicina) VALUES (?, ?, ?, ?)";

                 PreparedStatement statement = con.prepareStatement(sql);
                 statement.setInt(1, tip_id);
                 statement.setString(2, naziv);
                 statement.setDouble(3, cena);
                 statement.setInt(4, 0);

                 int rowsInserted = statement.executeUpdate();
                 if (rowsInserted > 0) {
                     return "Proizvod je dodat";
                 }
            } catch (SQLException ex) {
                 Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return "Doslo je do greske, molimo pokusajte ponovo";
    }
    
    public String insertIntoPrivilegija(String privilegija_naziv, String privilegija_opis){
        try {
                 String sql = "INSERT INTO privilegija (privilegija_naziv, privilegija_opis) VALUES (?, ?)";

                 PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                 statement.setString(1, privilegija_naziv);
                 statement.setString(2, privilegija_opis);

                 int rowsInserted = statement.executeUpdate();
                 if (rowsInserted > 0) { 
                    return "Privilegija je uspesno dodata";
                 }
            } catch (SQLException ex) {
                 Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        return "Doslo je do greske, molimo pokusajte ponovo";
    }
    
    public String insertIntoProdajniObjekat(String naziv, int broj_kasa){
        
        try {
                 String sql = "INSERT INTO tipprodajnogobjekta (objekat_naziv, objekat_brojKasa) VALUES (?, ?)";

                 PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                 statement.setString(1, naziv);
                 statement.setInt(2, broj_kasa);

                 int rowsInserted = statement.executeUpdate();
                 if (rowsInserted > 0) {
                     
                     ResultSet generatedKeys = statement.getGeneratedKeys();
                     if(generatedKeys.next()){
                        int count = 1;
                        int tip_id = generatedKeys.getInt(1);
                        while(count <= broj_kasa){
                            if(!insertIntoKasa(count, tip_id)){
                                return "Doslo je do greske, molimo pokusajte ponovo";
                            }
                            count++;
                        }
                     }
                     return "Prodajni Objekat je dodat";
                 }
            } catch (SQLException ex) {
                 Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        return "Doslo je do greske, molimo pokusajte ponovo";
        
    }
    
    public boolean insertIntoKasa(int kasa_objekat, int objekat_id){
        
        try {
                 String sql = "INSERT INTO kasa (kasa_objekat, objekat_id) VALUES (?, ?)";

                 PreparedStatement statement = con.prepareStatement(sql);
                 statement.setInt(1, kasa_objekat);
                 statement.setInt(2, objekat_id);

                 int rowsInserted = statement.executeUpdate();
                 if (rowsInserted > 0) {
                     return true;
                 }
            } catch (SQLException ex) {
                 Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
    }
    
    public ObservableList<ProdajniObjekat> queryTipProdajnogObjekta(){
        ObservableList<ProdajniObjekat> data = FXCollections.observableArrayList();
        
        try {
            String sql = "SELECT * FROM tipprodajnogobjekta";

            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            
            //StringProperty sp = rs.getString("objekat_naziv");
            
            while(rs.next()){
                data.add(new ProdajniObjekat(rs.getInt("objekat_id"), rs.getString("objekat_naziv"), rs.getInt("objekat_brojKasa")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ObservableList<Kasa> queryKasa(int objekat_id){
        ObservableList<Kasa> data = FXCollections.observableArrayList();
        
        try {
            String sql = "SELECT * FROM kasa WHERE objekat_id=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, objekat_id);
            
            ResultSet rs = statement.executeQuery();
            
            //StringProperty sp = rs.getString("objekat_naziv");
            
            while(rs.next()){
                data.add(new Kasa(rs.getInt("kasa_id"), rs.getInt("kasa_objekat"), rs.getInt("objekat_id")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ObservableList<User> queryZaposleni(){
        ObservableList<User> data = FXCollections.observableArrayList();
        
        try {
            String sql = "SELECT * FROM zaposleni";

            PreparedStatement statement = con.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            
            //StringProperty sp = rs.getString("objekat_naziv");
            
            while(rs.next()){
                int id = rs.getInt("zaposleni_id");
                int privilegija = rs.getInt("privilegija_id");
                String ime = rs.getString("zaposleni_ime");
                String prezime = rs.getString("zaposleni_prezime");
                String email = rs.getString("zaposleni_email");
                String opstina = rs.getString("zaposleni_opstina");
                String grad = rs.getString("zaposleni_grad");
                String ulica = rs.getString("zaposleni_ulica");
                
                data.add(new User(id, privilegija, ime, prezime, email, opstina, grad, ulica));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ObservableList<TaskModel> queryTask(){
        ObservableList<TaskModel> data = FXCollections.observableArrayList();
        
        try {
            String sql = "SELECT * FROM task";

            PreparedStatement statement = con.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            
            //StringProperty sp = rs.getString("objekat_naziv");
            
            while(rs.next()){
                data.add(new TaskModel(rs.getInt("task_id"), rs.getString("task_naziv"), rs.getString("task_fajl")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ObservableList<Privilegija> queryPrivilegija(){
        ObservableList<Privilegija> data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM privilegija";

            PreparedStatement statement = con.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                data.add(new Privilegija(rs.getInt("privilegija_id"), rs.getString("privilegija_naziv"), rs.getString("privilegija_opis")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ObservableList<TipProizvoda> queryTipProizvoda(){
        ObservableList<TipProizvoda> data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM tipproizvoda";

            PreparedStatement statement = con.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                data.add(new TipProizvoda(rs.getInt("tip_id"), rs.getString("tip_ime")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ObservableList<Proizvod> queryProizvod(){
        ObservableList<Proizvod> data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM proizvod";

            PreparedStatement statement = con.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                data.add(new Proizvod(rs.getInt("proizvod_id"), rs.getInt("tip_id"), rs.getDouble("proizvod_cena"), rs.getInt("proizvod_kolicina"), rs.getString("proizvod_naziv")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}