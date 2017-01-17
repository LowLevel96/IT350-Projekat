/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabs_controll;

import database.CRUD;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Nabavljac;
import model.Proizvod;
import model.TaskModel;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class NabavkaController implements Initializable {

    CRUD crud = new CRUD();
    
    @FXML private TableView<Nabavljac> tableViewNabavljac;
    @FXML private TableView<Proizvod> tableViewProizvod;
    
    @FXML private TableColumn<Nabavljac, Boolean> tableColumnNabavljacCheck;
    @FXML private TableColumn tableColumnNabavljacId;
    @FXML private TableColumn tableColumnNabavljacIme;
    @FXML private TableColumn tableColumnNabavljacPrezime;
    @FXML private TableColumn tableColumnNabavljacEmail;
    @FXML private TableColumn tableColumnNabavljacBroj;
    @FXML private TableColumn tableColumnNabavljacAdresa;
    
    @FXML private TableColumn tableColumnProizvodCheck;
    @FXML private TableColumn tableColumnProizvodId;
    @FXML private TableColumn tableColumnProizvodTip;
    @FXML private TableColumn tableColumnProizvodCena;
    @FXML private TableColumn tableColumnProizvodStanje;
    @FXML private TableColumn tableColumnProizvodKolicina;
    @FXML private TableColumn tableColumnProizvodNaziv;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        ObservableList<Nabavljac> listaNabavljaca = crud.queryNabavljac();
        ObservableList<Proizvod> listaProizvoda = crud.queryProizvod();
        tableViewProizvod.setItems(listaProizvoda);
        tableViewNabavljac.setItems(listaNabavljaca);
        
        tableViewProizvod.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableViewProizvod.getSelectionModel().setCellSelectionEnabled(true);
        tableViewNabavljac.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableViewNabavljac.getSelectionModel().setCellSelectionEnabled(true);
        
        tableViewNabavljac.setEditable(true);
        tableViewProizvod.setEditable(true);
        tableColumnNabavljacCheck.setEditable(true);
        
        tableColumnNabavljacId.setCellValueFactory(new PropertyValueFactory("nabavljac_id"));
        tableColumnNabavljacIme.setCellValueFactory(new PropertyValueFactory("nabavljac_ime"));
        tableColumnNabavljacPrezime.setCellValueFactory(new PropertyValueFactory("nabavljac_prezime"));
        tableColumnNabavljacEmail.setCellValueFactory(new PropertyValueFactory("nabavljac_email"));
        tableColumnNabavljacBroj.setCellValueFactory(new PropertyValueFactory("nabavljac_broj"));
        tableColumnNabavljacAdresa.setCellValueFactory(new PropertyValueFactory("nabavljac_adresa"));
        
        
        tableColumnProizvodId.setCellValueFactory(new PropertyValueFactory("proizvod_id"));
        tableColumnProizvodTip.setCellValueFactory(new PropertyValueFactory("tip_id"));
        tableColumnProizvodCena.setCellValueFactory(new PropertyValueFactory("proizvod_cena"));
        tableColumnProizvodStanje.setCellValueFactory(new PropertyValueFactory("proizvod_stanje"));
        tableColumnProizvodKolicina.setCellValueFactory(new PropertyValueFactory("proizvod_kolicina"));
        tableColumnProizvodNaziv.setCellValueFactory(new PropertyValueFactory("proizvod_naziv"));
        
        
    }
    
    @FXML
    public void izvrsiNabavku(){
        int nabavljac_id = 0;
        for(Nabavljac nabavljac : tableViewNabavljac.getItems()){
            if(nabavljac.getNabavljaccheck()){
                nabavljac_id = nabavljac.getNabavljac_id();
            }
        }
        
        ArrayList<Proizvod> list2 = new ArrayList<>();
        for(Proizvod proizvod : tableViewProizvod.getItems()){
            if(proizvod.getProizvodcheck()){
                list2.add(proizvod);
            }
        }
        
        LocalDate today = LocalDate.now();
        int nabavka_id = crud.insertIntoNabavka(nabavljac_id, list2.size(), today.toString());
        
        for (Iterator<Proizvod> iterator = list2.iterator(); iterator.hasNext();) {
            Proizvod next = iterator.next();
            crud.insertIntoNabavkaLista(next.getProizvod_id(), nabavka_id);
            
        }
        
        System.out.println("Uspesno, valjda!");
        
        
        
    }
    
}
