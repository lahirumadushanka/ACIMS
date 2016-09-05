/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sla.acims.ejb;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Lt APLM
 */
@Named(value = "personController")
@SessionScoped
public class PersonController implements Serializable {

    /**
     * Creates a new instance of PersonController
     */
    public PersonController() {
    }
    
}
