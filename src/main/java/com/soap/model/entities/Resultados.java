/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Fernando
 */
@Entity
@Table(name = "resultados", catalog = "prueba", schema = "pruebas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultados.findAll", query = "SELECT r FROM Resultados r")
    , @NamedQuery(name = "Resultados.findByIdresultado", query = "SELECT r FROM Resultados r WHERE r.idresultado = :idresultado")
    , @NamedQuery(name = "Resultados.findByOperando1", query = "SELECT r FROM Resultados r WHERE r.operando1 = :operando1")
    , @NamedQuery(name = "Resultados.findByOperando2", query = "SELECT r FROM Resultados r WHERE r.operando2 = :operando2")
    , @NamedQuery(name = "Resultados.findByResultado", query = "SELECT r FROM Resultados r WHERE r.resultado = :resultado")})
public class Resultados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="resultados_idresultado_generator", sequenceName="pruebas.resultados_idresultado_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="resultados_idresultado_generator")
    @Basic(optional = false)
    @Column(name = "idresultado", nullable = false)
    private Integer idresultado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "operando1", nullable = false)
    private Integer operando1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "operando2", nullable = false)
    private Integer operando2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resultado", nullable = false)
    private Integer resultado;
    @JoinColumn(name = "idoperacion", referencedColumnName = "idoperacion", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Operaciones idoperacion;

    public Resultados() {
    }

    public Resultados(Integer idresultado) {
        this.idresultado = idresultado;
    }

    public Resultados(Integer idresultado, Integer operando1, Integer operando2, Integer resultado) {
        this.idresultado = idresultado;
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.resultado = resultado;
    }

    public Integer getIdresultado() {
        return idresultado;
    }

    public void setIdresultado(Integer idresultado) {
        this.idresultado = idresultado;
    }

    public Integer getOperando1() {
        return operando1;
    }

    public void setOperando1(Integer operando1) {
        this.operando1 = operando1;
    }

    public Integer getOperando2() {
        return operando2;
    }

    public void setOperando2(Integer operando2) {
        this.operando2 = operando2;
    }

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    public Operaciones getIdoperacion() {
        return idoperacion;
    }

    public void setIdoperacion(Operaciones idoperacion) {
        this.idoperacion = idoperacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresultado != null ? idresultado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultados)) {
            return false;
        }
        Resultados other = (Resultados) object;
        if ((this.idresultado == null && other.idresultado != null) || (this.idresultado != null && !this.idresultado.equals(other.idresultado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soap.model.entities.Resultados[ idresultado=" + idresultado + " ]";
    }
    
}
