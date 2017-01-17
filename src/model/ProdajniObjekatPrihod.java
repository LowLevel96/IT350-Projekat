/* To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates and open the template in the editor.
*/
package model;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class ProdajniObjekatPrihod {
private IntegerProperty tip_id;
private StringProperty tip_naziv;
private DoubleProperty tip_prihod;
private DoubleProperty tip_porez;
public ProdajniObjekatPrihod(int tip_id, String tip_naziv, double tip_prihod, double tip_porez) {
    this.tip_id = new SimpleIntegerProperty(tip_id);
    this.tip_naziv = new SimpleStringProperty(tip_naziv);
    this.tip_prihod = new SimpleDoubleProperty(tip_prihod);
    this.tip_porez = new SimpleDoubleProperty(tip_porez);
}


//Properties

public IntegerProperty tipIdProperty(){
    return tip_id;
}
public StringProperty tipNazivProperty(){
    return tip_naziv;
}
public DoubleProperty tipPrihodProperty(){
    return tip_prihod;
}
public DoubleProperty tipPorezProperty(){
    return tip_porez;
} 

//getters and setters

public int getTip_id() {
    return tip_id.get();
}

public void setTip_id(int tip_id) {
    this.tip_id.set(tip_id);
}

public String getTip_naziv() {
    return tip_naziv.get();
}

public void setTip_naziv(String tip_naziv) {
    this.tip_naziv.set(tip_naziv);
}

public double getTip_prihod() {
    return tip_prihod.get();
}

public void setTip_prihod(double tip_prihod) {
    this.tip_prihod.set(tip_prihod);
}

public double getTip_porez() {
    return tip_porez.get();
}

public void setTip_porez(double tip_porez) {
    this.tip_porez.set(tip_porez);
}
}