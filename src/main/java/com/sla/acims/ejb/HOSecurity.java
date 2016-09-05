/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sla.acims.ejb;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author Lt APLM
 */
@Named
@SessionScoped
public class HOSecurity  implements Serializable {

    /**
     * Creates a new instance of HOSecurity
     */
    public HOSecurity() {
    }

    public static String encrypt(String word) {
        BasicTextEncryptor en = new BasicTextEncryptor();
        en.setPassword("health");
        try {
            return en.encrypt(word);
        } catch (Exception ex) {
            return null;
        }
    }
    
    public static String hash(String word){
        try{
            BasicPasswordEncryptor en = new BasicPasswordEncryptor();
            return en.encryptPassword(word);
        }catch(Exception e){
            return null;
        }
    }
    
    
    public static boolean matchPassword(String planePassword,String encryptedPassword ){
        BasicPasswordEncryptor en = new BasicPasswordEncryptor();
        return en.checkPassword(planePassword, encryptedPassword);
    }
    
    public static String decrypt(String word){
        BasicTextEncryptor en = new BasicTextEncryptor();
        en.setPassword("health");
        try {
            return en.decrypt(word);
        } catch (Exception ex) {
            return null;
        }
        
    }
    
    
}
