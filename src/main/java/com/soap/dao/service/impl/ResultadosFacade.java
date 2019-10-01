/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.dao.service.impl;

import com.soap.dao.service.ResultadosFacadeLocal;
import com.soap.dao.crud.CrudService;
import com.soap.model.entities.Resultados;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos Fernando
 */
@Stateless
public class ResultadosFacade extends CrudService<Resultados> implements ResultadosFacadeLocal {

    @PersistenceContext(unitName = "PruebasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResultadosFacade() {
        super(Resultados.class);
    }
    
}
