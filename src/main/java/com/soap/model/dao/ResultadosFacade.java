/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.model.dao;

import com.soap.model.entities.Resultados;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos Fernando
 */
@Stateless
public class ResultadosFacade extends AbstractFacade<Resultados> implements ResultadosFacadeLocal {

    @PersistenceContext(unitName = "com.zeus.app_PruebaWebServiceSOAP_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResultadosFacade() {
        super(Resultados.class);
    }
    
}
