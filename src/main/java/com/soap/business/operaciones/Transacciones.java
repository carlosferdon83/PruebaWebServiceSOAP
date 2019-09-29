/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.business.operaciones;

import java.util.List;
import javax.ejb.Stateless;
import com.soap.model.entities.Operaciones;
import com.soap.model.servicesDao.IOperacionesService;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.persistence.PersistenceException;

/**
 *
 * @author Carlos Fernando
 */
@Stateless
public class Transacciones implements TransaccionesLocal {
    
    @EJB
    private IOperacionesService operaciones;

    @Override
    public List<Operaciones> listaOperaciones() {
        List<Operaciones> listaOperaciones = new ArrayList<Operaciones>(); 
        try{             
            listaOperaciones = operaciones.findAll();            
        }catch(PersistenceException ex){
            System.out.println("Un error ha ocurrido "+ex.getMessage());
        }   
        return listaOperaciones;
    }

    
}
