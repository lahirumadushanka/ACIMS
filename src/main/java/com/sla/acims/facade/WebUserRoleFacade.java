/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sla.acims.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.sla.acims.entity.WebUserRole;

/**
 *
 * @author Lt APLM
 */
@Stateless
public class WebUserRoleFacade extends AbstractFacade<WebUserRole> {

    @PersistenceContext(unitName = "wlPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WebUserRoleFacade() {
        super(WebUserRole.class);
    }
    
}
