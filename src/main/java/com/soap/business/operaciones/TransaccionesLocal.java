/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.business.operaciones;

import java.util.List;
import javax.ejb.Local;
import com.soap.model.entities.Operaciones;

/**
 *
 * @author Carlos Fernando
 */
@Local
public interface TransaccionesLocal {
    
    public List<Operaciones> listaOperaciones();
    
}
