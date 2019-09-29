/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.view.controller;

import com.soap.utils.Constantes;
import com.soap.ws.client.Calculator;
import com.soap.ws.client.CalculatorSoap;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.xml.namespace.QName;


/**
 *
 * @author Carlos Fernando
 */
@Named(value = "calculadoraController")
@ViewScoped
public class CalculadoraController implements Serializable{   
    
    private static final long serialVersionUID = 1L;
    
    private String numero1;
    private String numero2;
    private String total;
    private String operacion;
    private URL url;
    private QName qname;
    

    @PostConstruct    
    public void init(){
        this.inicializarEndPoints();
    }
    
    public void inicializarEndPoints(){
        try {
            url = new URL(Constantes.URL_ENDPOINT_WSDL);
            qname = new QName(Constantes.TARGET_NAME_SPACE, Constantes.ACTION);        
            Calculator calculadora = new Calculator(url,qname);
            
            CalculatorSoap prueba = calculadora.getPort(CalculatorSoap.class);
            
            
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(CalculadoraController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public String getNumero1() {
        return numero1;
    }

    public void setNumero1(String numero1) {
        this.numero1 = numero1;
    }

    public String getNumero2() {
        return numero2;
    }

    public void setNumero2(String numero2) {
        this.numero2 = numero2;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public QName getQname() {
        return qname;
    }

    public void setQname(QName qname) {
        this.qname = qname;
    }
    
}
