/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.control.TableCell;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.util.Callback;

/**
 *
 * @author dusan
 */
public class CheckBoxListaProizvoda implements Callback{

    @Override
    public TableCell call(Object param) {
        CheckBoxTableCell<Proizvod,Boolean> checkBoxCell = new CheckBoxTableCell<>();
        return checkBoxCell;
    }
    
}
