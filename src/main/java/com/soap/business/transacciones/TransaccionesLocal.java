/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.business.transacciones;

import com.soap.model.entities.Operaciones;
import com.soap.model.entities.Resultados;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos Fernando
 */
@Local
public interface TransaccionesLocal {
    
    public List<Operaciones> listaOperaciones();
    public void insertarResultados(Resultados resultados);
}
