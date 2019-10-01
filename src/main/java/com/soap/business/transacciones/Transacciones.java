/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.business.transacciones;

import com.soap.dao.service.OperacionesFacadeLocal;
import com.soap.dao.service.ResultadosFacadeLocal;
import com.soap.model.entities.Operaciones;
import com.soap.model.entities.Resultados;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;

/**
 *
 * @author Carlos Fernando
 */
@Stateless
public class Transacciones implements TransaccionesLocal {

    @EJB
    private OperacionesFacadeLocal operacionesFacade;
    
    @EJB
    private ResultadosFacadeLocal resultadosFacade;
    
    @Override
    public List<Operaciones> listaOperaciones() {
        List<Operaciones> listaOperaciones = new ArrayList<Operaciones>();
        try{
            listaOperaciones = operacionesFacade.findAll();
        }catch(EJBException ex){
            System.out.println("Un error ha ocurrido "+ex.getMessage()+" en "+ex.getClass());
        }
        return listaOperaciones;
    }

    @Override
    public void insertarResultados(Resultados resultados) {
        try{
            resultadosFacade.create(resultados);
        }catch(EJBException ex){
            System.out.println("Un error ha ocurrido "+ex.getMessage()+" en "+ex.getClass());
        }
    }

   
}
