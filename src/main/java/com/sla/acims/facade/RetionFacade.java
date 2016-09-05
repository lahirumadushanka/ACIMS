/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sla.acims.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.sla.acims.entity.Ration;

/**
 *
 * @author Lt APLM
 */
@Stateless
public class RetionFacade extends AbstractFacade<Ration> {

    @PersistenceContext(unitName = "wlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RetionFacade() {
        super(Ration.class);
    }
    
}
