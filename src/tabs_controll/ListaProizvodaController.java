/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabs_controll;

import database.CRUD;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observable;
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
import javafx.scene.control.cell.TextFieldTableCell;
import static javafx.scene.input.KeyCode.T;
import javafx.util.StringConverter;
import login.UserFactory;
import model.Proizvod;
import model.TextFieldListaProizvoda;
import register_computer.RegisterFile;

/**
 * FXML Controller class
 *
 * @author dusan
 */
public class ListaProizvodaController implements Initializable {

    CRUD crud = new CRUD();
    
    @FXML private TableView<Proizvod> tableViewLista;
    @FXML private TableColumn<Proizvod, Boolean> tableColumnCheck;
    @FXML private TableColumn<Proizvod, Integer> tableColumnId;
    @FXML private TableColumn<Proizvod, String> tableColumnTip;
    @FXML private TableColumn<Proizvod, Double> tableColumnCena;
    @FXML private TableColumn<Proizvod, Integer> tableColumnStanje;
    @FXML private TableColumn<Proizvod, Number> tableColumnKolicina;
    @FXML private TableColumn<Proizvod, String> tableColumnNaziv;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Proizvod> listaProizvoda = crud.queryProizvod();
        listaProizvoda = listaProizvoda.stream().filter(p -> p.getProizvod_stanje() > 0).collect(Collectors.toCollection(FXCollections::observableArrayList));
        tableViewLista.setItems(listaProizvoda);
        
        tableViewLista.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableViewLista.getSelectionModel().setCellSelectionEnabled(true);
        
        tableViewLista.setEditable(true);
        
        tableColumnId.setCellValueFactory(new PropertyValueFactory("proizvod_id"));
        tableColumnTip.setCellValueFactory(new PropertyValueFactory("tip_id"));
        tableColumnCena.setCellValueFactory(new PropertyValueFactory("proizvod_cena"));
        tableColumnStanje.setCellValueFactory(new PropertyValueFactory("proizvod_stanje"));
        //tableColumnKolicina.setCellValueFactory(new PropertyValueFactory("proizvodkolicina"));
        tableColumnNaziv.setCellValueFactory(new PropertyValueFactory("proizvod_naziv"));
       
    }
    
    @FXML
    public void stampajRacun(){
        
        ArrayList<Proizvod> lista = new ArrayList<>();
        for(Proizvod proizvod : tableViewLista.getItems()){
            if(proizvod.getProizvodcheck()){
                System.out.println(proizvod.getProizvod_naziv());
                //System.out.println(proizvod.getProizvodkolicina());
                lista.add(proizvod);
            }
        }
        
        ArrayList<Integer> lista_id = new ArrayList<>();
        double prodaja_cena = 0;
        for(Proizvod id : lista) {
            lista_id.add(id.getProizvod_id());
            prodaja_cena += id.getProizvod_cena();
        }
        
        int kasa_id = Integer.parseInt(new RegisterFile().readFromFile());
//        int zaposleni_id = UserFactory.getInstance().getUser().getId
        int zaposleni_id = 1;
        int prodaja_kolicina = lista.size();
        String prodaja_datum = LocalDate.now().toString();
        
        double prodaja_porez = prodaja_cena * 0.2;
        
        
        System.out.println(crud.insertIntoProdaja(zaposleni_id, kasa_id, 5, prodaja_cena, prodaja_datum, prodaja_porez, lista));        
        
    }
    
    
}


/*

                  <TableColumn fx:id="tableColumnKolicina" prefWidth="103.0" text="Kolicina">
                     <cellValueFactory>
                        <PropertyValueFactory property="proizvod_kolicina" />
                     </cellValueFactory>
                     <cellFactory>
                        <model.TextFieldListaProizvoda />
                     </cellFactory>
                  </TableColumn>

*/