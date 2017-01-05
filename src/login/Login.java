/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import database.CRUD;

/**
 *
 * @author dusan
 */
public class Login {
    
    private String user_email;
    private String user_password;

    public Login() {
    
    }
    
    public boolean verifyUser(String email, String password){
        
        CRUD crud = new CRUD();
        
        if(crud.verifyUser(email, password) != 0){
            System.out.println("Uspesno ste se ulogovali");
        }else{
            System.out.println("Pogresna mejl adresa ili sifra. Molimo pokusajte ponovo!");
        }
        
        return true;
    }

    public Login(String user_email, String user_password) {
        this.user_email = user_email;
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
    
}
