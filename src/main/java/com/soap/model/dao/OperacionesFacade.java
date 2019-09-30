/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.model.dao;

import com.soap.model.entities.Operaciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos Fernando
 */
@Stateless
public class OperacionesFacade extends AbstractFacade<Operaciones> implements OperacionesFacadeLocal {

    @PersistenceContext(unitName = "PruebasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperacionesFacade() {
        super(Operaciones.class);
    }
    
}
