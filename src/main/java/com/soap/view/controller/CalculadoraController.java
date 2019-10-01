/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.view.controller;

import com.soap.business.transacciones.TransaccionesLocal;
import com.soap.model.entities.Operaciones;
import com.soap.model.entities.Resultados;
import com.soap.utils.Constantes;
import com.soap.ws.client.Calculator;
import com.soap.ws.client.CalculatorSoap;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.xml.namespace.QName;

/**
 *
 * @author Carlos Fernando
 */
@Named(value = "calculadoraController")
@ViewScoped
public class CalculadoraController implements Serializable {

    private static final long serialVersionUID = 1L;

    private String numero1;
    private String numero2;
    private String total;
    private String operacion;
    private URL url;
    private QName qname;
    private List<Operaciones> listaOperaciones;
    private Resultados resultados;
    private Integer resultado;

    @EJB
    private TransaccionesLocal transacciones;

    @PostConstruct
    public void init() {
        resultados = new Resultados();
        this.inicializarEndPoints();
    }
    
    /**
     *
     * @author Carlos Fernando
     * @fecha 30/09/2019 - 9:37:26 p. m.
     * @metodo calcularOperacion
     * @descripcion valida el tipo de operacion para identificar el metodo a consumir en el web service
     */
    public void calcularOperacion() {
        Calculator calculadora = new Calculator(url, qname);
        CalculatorSoap prueba = calculadora.getPort(CalculatorSoap.class);
        int obtenerOperacion = Integer.parseInt(operacion);
        switch (obtenerOperacion) {
            case Constantes.SUMA: 
                resultado = prueba.add(resultados.getOperando1(), resultados.getOperando2());
                total = String.valueOf(resultado);
                this.guardarOperacion();
                break;
            case Constantes.RESTA:
                resultado = prueba.subtract(resultados.getOperando1(), resultados.getOperando2());
                total = String.valueOf(resultado);
                this.guardarOperacion();
                break;
            case Constantes.MULTIPLICACION:
                resultado = prueba.multiply(resultados.getOperando1(), resultados.getOperando2());
                total = String.valueOf(resultado);
                this.guardarOperacion();
                break;
            case Constantes.DIVISION:
                int comparacion = resultados.getOperando2().compareTo(Constantes.DIVISION_CERO);
                if (comparacion == 0) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Atencion", "Division por cero"));
                } else {
                    resultado = prueba.divide(resultados.getOperando1(), resultados.getOperando2());
                    total = String.valueOf(resultado.intValue());
                    this.guardarOperacion();
                }
                break;
            default:
                break;
        }
    }

    /**
     *
     * @author Carlos Fernando
     * @fecha 30/09/2019 - 9:37:26 p. m.
     * @metodo guardarOperacion
     * @descripcion guarda las operaciones realizadas por el web service
     */
    private void guardarOperacion() {
        try {
            resultados.setResultado(resultado);
            resultados.setIdoperacion(new Operaciones(Integer.parseInt(operacion)));
            transacciones.insertarResultados(resultados);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atencion", "La operacion ha sido registrada"));
        } catch (Exception ex) {
            System.out.println("Un error ha ocurrido " + ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atencion", "Un error ha ocurrido"));
        }
    }

    /**
	 * 
	 * @author Carlos Fernando
	 * @fecha 30/09/2019 - 9:37:26 p. m.
	 * @metodo inicializarEndPoints
	 * @descripcion inicializa los endpoints para el consumo del web service
	 */
    public void inicializarEndPoints() {
        try {
            url = new URL(Constantes.URL_ENDPOINT_WSDL);
            qname = new QName(Constantes.TARGET_NAME_SPACE, Constantes.ACTION);
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

    public List<Operaciones> getListaOperaciones() {
        listaOperaciones = transacciones.listaOperaciones();
        return listaOperaciones;
    }

    public void setListaOperaciones(List<Operaciones> listaOperaciones) {
        this.listaOperaciones = listaOperaciones;
    }

    public Resultados getResultados() {
        return resultados;
    }

    public void setResultados(Resultados resultados) {
        this.resultados = resultados;
    }

}
