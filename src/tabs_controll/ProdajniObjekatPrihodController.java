/* To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates and open the template in the editor.
*/
package tabs_controll;
import database.CRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ProdajniObjekatPrihod;
import model.User;
/* FXML Controller class
@author igor
*/
public class ProdajniObjekatPrihodController implements Initializable {
CRUD crud = new CRUD();

@FXML private TableView <ProdajniObjekatPrihod>   tableViewLista;
@FXML private TableColumn <ProdajniObjekatPrihod,Integer> tableColumnId;
@FXML private TableColumn <ProdajniObjekatPrihod,String> tableColumnNaziv;
@FXML private TableColumn<ProdajniObjekatPrihod,Double>  tableColumnPrihod;
@FXML private TableColumn <ProdajniObjekatPrihod,Double> tableColumnPorez;



@Override
public void initialize(URL url, ResourceBundle rb) {

    ObservableList<ProdajniObjekatPrihod> data = crud.findProdajniObjekatPrihod();
    tableViewLista.setItems(data);

    tableColumnId.setCellValueFactory(new PropertyValueFactory<>("tip_id"));
    tableColumnNaziv.setCellValueFactory(new PropertyValueFactory<>("tip_naziv"));
    tableColumnPrihod.setCellValueFactory(new PropertyValueFactory<>("tip_prihod"));
    tableColumnPorez.setCellValueFactory(new PropertyValueFactory<>("tip_porez"));
}    
}