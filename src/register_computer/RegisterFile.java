/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register_computer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dusan
 */
public class RegisterFile {
    
    File file;
    BufferedWriter bw;
    BufferedReader br;

    public RegisterFile() {
        
    }
    
    public void writeToFile(String text){
        try {
            bw = new BufferedWriter(new FileWriter("register.txt"));
            bw.write(text);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String readFromFile(){
        String line = null;
        try {
            br = new BufferedReader(new FileReader("register.txt"));
            line = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(RegisterFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return line;
    }
    
}
