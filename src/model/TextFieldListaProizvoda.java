/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.control.TableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;

/**
 *
 * @author dusan
 */
public class TextFieldListaProizvoda implements Callback{

    @Override
    public TextFieldTableCell call(Object param){
        TextFieldTableCell<Proizvod, String> textFieldCell = new TextFieldTableCell<>();
        return textFieldCell;
    }
}
