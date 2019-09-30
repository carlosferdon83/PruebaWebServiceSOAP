/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.model.dao;

import com.soap.model.entities.Resultados;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos Fernando
 */
@Local
public interface ResultadosFacadeLocal {

    void create(Resultados resultados);

    void edit(Resultados resultados);

    void remove(Resultados resultados);

    Resultados find(Object id);

    List<Resultados> findAll();

    List<Resultados> findRange(int[] range);

    int count();
    
}
