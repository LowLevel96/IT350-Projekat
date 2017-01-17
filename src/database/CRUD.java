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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import model.User;
import model.Kasa;
import model.Nabavka;
import model.Nabavljac;
import model.Privilegija;
import model.Prodaja;
import model.ProdajniObjekat;
import model.ProdajniObjekatPrihod;
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
    
    public String findNazivByIdInTipProizvoda(int tip_id){
        try {
            String sql = "SELECT tip_ime FROM tipproizvoda WHERE tip_id=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, tip_id);

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                return rs.getString("tip_ime");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
                return new User(user_id, privilegija_id, name, lastname, email, state, city, street, findTaskListaInPrivilegijaListaById(privilegija_id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ObservableList<TaskModel> findTaskListaInPrivilegijaListaById(int tip_id){
        ObservableList<TaskModel> data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT task_id FROM privilegijalista WHERE privilegija_id=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, tip_id);

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                data.add(findTaskById(rs.getInt("task_id")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public TaskModel findTaskById(int task_id){
        try {
            String sql = "SELECT * FROM task WHERE task_id=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, task_id);

            ResultSet rs = statement.executeQuery();
            if(rs.next()){
               return new TaskModel(rs.getInt("task_id"), rs.getString("task_naziv"), rs.getString("task_fajl"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String insertIntoProizvod(int tip_id, String naziv, double kolicina, double cena){
        try {
        String sql = "INSERT INTO Proizvod (tip_id, proizvod_naziv, proizvod_cena, proizvod_kolicina) VALUES (?, ?, ?, ?)";
             PreparedStatement statement = con.prepareStatement(sql);
             statement.setInt(1, tip_id);
             statement.setString(2, naziv);
             statement.setDouble(3, kolicina);
             statement.setDouble(4, cena);

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
                
                data.add(new User(id, privilegija, ime, prezime, email, opstina, grad, ulica, null));
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
    
        public ObservableList<Nabavka> queryNabavka() {
            ObservableList<Nabavka> data = FXCollections.observableArrayList();
            try {
            String sql = "SELECT * FROM nabavka";
                PreparedStatement statement = con.prepareStatement(sql);

                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    data.add(new Nabavka(rs.getInt("nabavka_id"), rs.getInt("nabavljac_id"), rs.getInt("nabavka_kolicina"), rs.getString("nabavka_datum")));
                }
                return data;
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }

            return null;
        }
        
        public ObservableList<Nabavka> queryNabavkaToday() {
            ObservableList<Nabavka> data = FXCollections.observableArrayList();
            try {
            String sql = "SELECT * FROM nabavka WHERE nabavka_datum=?";
                PreparedStatement statement = con.prepareStatement(sql);
                LocalDate today = LocalDate.now();
                statement.setString(1, today.toString());

                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    data.add(new Nabavka(rs.getInt("nabavka_id"), rs.getInt("nabavljac_id"), rs.getInt("nabavka_kolicina"), rs.getString("nabavka_datum")));
                }
                return data;
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }

            return null;
        }

    //insertIntoProdaja!!
    public String insertIntoProdaja(int zaposleni_id,int kasa_id,int prodaja_kolicina,double prodaja_cena,String prodaja_datum,double prodaja_porez, ArrayList<Proizvod> lista_proizvoda){
        try {
                 String sql = "INSERT INTO prodaja (zaposleni_id, kasa_id, prodaja_kolicina, prodaja_cena,prodaja_datum,prodaja_porez) VALUES (?, ?, ?, ?, ?, ?)";

                 PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                 statement.setInt(1,zaposleni_id);
                 statement.setInt(2, kasa_id);
                 statement.setInt(3, prodaja_kolicina);
                 statement.setDouble(4, prodaja_cena);
                 statement.setString(5, prodaja_datum);
                 statement.setDouble(6, prodaja_porez);
                 

                 int rowsInserted = statement.executeUpdate();
                 if (rowsInserted > 0) {
                     ResultSet row_id = statement.getGeneratedKeys();
                     if(row_id.next()){
                        for (Iterator<Proizvod> iterator = lista_proizvoda.iterator(); iterator.hasNext();) {
                            Proizvod next = iterator.next();
                            insertIntoProdajaLista(next.getProizvod_id(), row_id.getInt(1));
                        }
                        return "Uspesno dodavanje!";
                     }
                 }
            } catch (SQLException ex) {
                 Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return "Doslo je do greske, molimo pokusajte ponovo";
    }

    //insertIntoProdajaLista
    public void insertIntoProdajaLista(int proizvod_id, int prodaja_id){
        try {
                 String sql = "INSERT INTO prodajalista (proizvod_id,prodaja_id) VALUES (?, ?)";

                 PreparedStatement statement = con.prepareStatement(sql);
                 statement.setInt(1, proizvod_id);
                 statement.setInt(2, prodaja_id);

                 int rowsInserted = statement.executeUpdate();
            } catch (SQLException ex) {
                 Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public int insertIntoNabavka(int nabavljac_id, int nabavka_kolicina, String nabavka_datum){
        try {
            
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            Date startDate = df.parse(nabavka_datum);
            
                String sql = "INSERT INTO Nabavka (nabavljac_id, nabavka_kolicina, nabavka_datum) VALUES (?, ?, ?)";
                PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                 
                 statement.setInt(1, nabavljac_id);
                 statement.setInt(2, nabavka_kolicina);
                 statement.setString(3, nabavka_datum);

                 int rowsInserted = statement.executeUpdate();
                 if (rowsInserted > 0) {
                     ResultSet nabavka_id = statement.getGeneratedKeys();
                     if(nabavka_id.next()){
                        return nabavka_id.getInt(1);
                     }
                     
                 }
            } catch (SQLException ex) {
                 Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public int findKolicinaInProizvodById(int id){
        try {
             String sql = "SELECT proizvod_kolicina FROM proizvod WHERE proizvod_id=?";

             PreparedStatement statement = con.prepareStatement(sql);
             statement.setInt(1, id);

             ResultSet rs = statement.executeQuery();
             if(rs.next()){
                 return rs.getInt("proizvod_kolicina");
             }

        } catch (SQLException ex) {
             Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }    
    
    public ObservableList<Prodaja> queryProdajaToday(){
        ObservableList<Prodaja> data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM prodaja WHERE prodaja_datum=?";

            PreparedStatement statement = con.prepareStatement(sql);
            
            LocalDate today = LocalDate.now();
            statement.setString(1, today.toString());
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                data.add(new Prodaja(rs.getInt("prodaja_id"), rs.getInt("zaposleni_id"), rs.getInt("kasa_id"), rs.getInt("prodaja_kolicina"), rs.getDouble("prodaja_cena"), rs.getString("prodaja_datum"), rs.getDouble("prodaja_porez")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ObservableList<Nabavljac> queryNabavljac(){
        ObservableList<Nabavljac> data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM nabavljac";

            PreparedStatement statement = con.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                data.add(new Nabavljac(rs.getInt("nabavljac_id"), rs.getString("nabavljac_ime"), rs.getString("nabavljac_prezime"), rs.getString("nabavljac_email"), rs.getString("nabavljac_broj"), rs.getString("nabavljac_adresa")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public String findUkupnoInProdajaForToday(){
        try {
            String sql = "SELECT SUM(PRODAJA_CENA) AS ukupno FROM prodaja WHERE PRODAJA_DATUM=?";

            PreparedStatement statement = con.prepareStatement(sql);
            
            LocalDate today = LocalDate.now();
            statement.setString(1, today.toString());
            
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return ""+rs.getString("ukupno");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public Proizvod findProizvodById(int proizvod_id){
        try {
            String sql = "SELECT * FROM proizvod WHERE proizvod_id=?";

            PreparedStatement statement = con.prepareStatement(sql);
            
            LocalDate today = LocalDate.now();
            statement.setInt(1, proizvod_id);
            
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                return new Proizvod(rs.getInt("proizvod_id"), rs.getInt("tip_id"), rs.getDouble("proizvod_cena"), rs.getInt("proizvod_kolicina"), rs.getString("proizvod_naziv"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void updateKolicinaInProizvodById(int id, int kolicina){
        try {
            
            String sql = "UPDATE proizvod SET proizvod_kolicina=? WHERE proizvod_id=?";
            int newKolicina = findKolicinaInProizvodById(id) - kolicina;
                 PreparedStatement statement = con.prepareStatement(sql);
                 statement.setInt(1, newKolicina);
                 statement.setInt(2, id);

                 int rowsInserted = statement.executeUpdate();
            } catch (SQLException ex) {
            
            }
    }
    
    public String findZaposleniImeById(int zaposleni_id){
         try {
            String sql = "SELECT zaposleni_ime, zaposleni_prezime FROM zaposleni WHERE zaposleni_id=?";

            PreparedStatement statement = con.prepareStatement(sql);
            
            LocalDate today = LocalDate.now();
            statement.setInt(1, zaposleni_id);
            
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                return rs.getString("zaposleni_ime") + " " + rs.getString("zaposleni_prezime");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
//    public int naruceniProizvodiUdanu(String naziv){
//        try {
//        String sql = "";
//                PreparedStatement statement = con.prepareStatement(sql);
//                statement.setString(1, naziv);
//
//                ResultSet rs = statement.executeQuery();
//                while(rs.next()){
//                    return rs.getInt("proizvod_id");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        sreturn 0;
//    }

    public void insertIntoNabavkaLista(int proizvod_id, int nabavka_id) {
        try {
                 String sql = "INSERT INTO nabavkalista (proizvod_id, nabavka_id, nabavkalista_kolicina) VALUES (?, ?, ?)";

                 PreparedStatement statement = con.prepareStatement(sql);
                 statement.setInt(1, proizvod_id);
                 statement.setInt(2, nabavka_id);
                 statement.setInt(3, 5);

                 int rowsInserted = statement.executeUpdate();
            } catch (SQLException ex) {
                 Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public double findUkupnoInProizvod(){
        try {
        String sql = "SELECT SUM(proizvod_cena*proizvod_kolicina) as 'Vrednost' FROM proizvod WHERE proizvod_kolicina > 0";
        PreparedStatement statement = con.prepareStatement(sql);
        //statement.setString(1, vrednost);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                return rs.getDouble("Vrednost");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    return 0;
    }
    
    public double findUkupnoInNabavkaToday(){
        double sum = 0;
        try {
        String sql = "SELECT nabavka.NABAVKA_ID, nabavka.NABAVKA_KOLICINA,nabavkalista.NABAVKA_ID,nabavkalista.PROIZVOD_ID,proizvod.PROIZVOD_ID,proizvod.PROIZVOD_CENA,nabavka.NABAVKA_DATUM,SUM(proizvod.PROIZVOD_CENA*nabavkalista.NABAVKALISTA_KOLICINA) AS nabavka_ukupno FROM nabavka,nabavkalista,proizvod WHERE (proizvod.PROIZVOD_ID=nabavkalista.PROIZVOD_ID && nabavka.NABAVKA_ID=nabavkalista.NABAVKA_ID) AND nabavka.NABAVKA_DATUM = ? GROUP BY nabavkalista.PROIZVOD_ID, nabavka.NABAVKA_ID";
        PreparedStatement statement = con.prepareStatement(sql);
        LocalDate today = LocalDate.now();
        statement.setString(1, today.toString());
        
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                sum += rs.getDouble("nabavka_ukupno");
            }
            return sum;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    return sum;
    }
   
    public String insertIntoNabavljac(String nabavljac_ime, String nabavljac_prezime, String nabavljac_email, String nabavljac_broj, String nabavljac_adresa) {

    try {
        String sql = "INSERT INTO nabavljac (nabavljac_ime, nabavljac_prezime, nabavljac_email,nabavljac_broj,nabavljac_adresa) VALUES ( ?, ?, ?, ?, ?)";

        PreparedStatement statement = con.prepareStatement(sql);

        statement.setString(1, nabavljac_ime);
        statement.setString(2, nabavljac_prezime);
        statement.setString(3, nabavljac_email);
        statement.setString(4, nabavljac_broj);
        statement.setString(5, nabavljac_adresa);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {


            return "Uspesno dodavanje!";
        }
    } catch (SQLException ex) {
        Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
    }

    return "Doslo je do greske, molimo pokusajte ponovo";
}
    
    public int findNabavljacNajprodavanijeProizvoda(){
        try {
        String sql = "SELECT nabavljac.NABAVLJAC_ID,prodajalista.PROIZVOD_ID,SUM(PRODAJA_KOLICINA) FROM nabavljac,prodaja,prodajalista,nabavkalista,nabavka WHERE prodaja.PRODAJA_ID=prodajalista.PRODAJA_ID AND prodajalista.PROIZVOD_ID=nabavkalista.PROIZVOD_ID AND nabavkalista.NABAVKA_ID=nabavka.NABAVKA_ID AND nabavka.NABAVLJAC_ID=nabavljac.NABAVLJAC_ID GROUP BY nabavljac.NABAVLJAC_ID, prodajalista.PROIZVOD_ID LIMIT 1";
        PreparedStatement statement = con.prepareStatement(sql);
        LocalDate today = LocalDate.now();

        
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return rs.getInt("nabavljac_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public String findNabavljacById(int nabavljac_id){
        try {
        String sql = "SELECT * FROM Nabavljac WHERE nabavljac_id=?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, nabavljac_id);
        LocalDate today = LocalDate.now();

        
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return rs.getString("nabavljac_ime") + " " + rs.getString("nabavljac_prezime");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public ObservableList<ProdajniObjekatPrihod> findProdajniObjekatPrihod(){
        ObservableList<ProdajniObjekatPrihod> data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT tipprodajnogobjekta.OBJEKAT_ID,tipprodajnogobjekta.OBJEKAT_NAZIV,SUM(prodaja.PRODAJA_CENA) AS UKUPAN_PRIHOD,SUM(prodaja.PRODAJA_CENA*0.20) AS UKUPAN_POREZ FROM prodaja,kasa,tipprodajnogobjekta WHERE MONTH(prodaja.PRODAJA_DATUM) = '01' AND prodaja.KASA_ID=kasa.KASA_ID AND kasa.OBJEKAT_ID=tipprodajnogobjekta.OBJEKAT_ID GROUP BY kasa.OBJEKAT_ID";
            PreparedStatement statement = con.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();

        while(rs.next()){
            data.add(new ProdajniObjekatPrihod(rs.getInt("objekat_id"), rs.getString("objekat_naziv"),rs.getDouble("ukupan_prihod"),rs.getDouble("ukupan_porez")));
        }
        return data;
    } catch (SQLException ex) {
        Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
    }

    return null;
}
    
    public int findNajboljiProdavacUmesecu(){
        try {
        String sql = "SELECT ZAPOSLENI_ID,PRODAJA_DATUM,SUM(PRODAJA_CENA) FROM prodaja AS novalista WHERE MONTH(PRODAJA_DATUM) = '01' GROUP BY ZAPOSLENI_ID,MONTH(PRODAJA_DATUM),PRODAJA_DATUM ORDER BY SUM(PRODAJA_CENA)DESC LIMIT 0,1";
        PreparedStatement statement = con.prepareStatement(sql);
        LocalDate today = LocalDate.now();

        
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return rs.getInt("zaposleni_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}