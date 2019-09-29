/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Fernando
 */
@Entity
@Table(name = "operaciones", catalog = "prueba", schema = "pruebas", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operaciones.findAll", query = "SELECT o FROM Operaciones o")
    , @NamedQuery(name = "Operaciones.findByIdoperacion", query = "SELECT o FROM Operaciones o WHERE o.idoperacion = :idoperacion")
    , @NamedQuery(name = "Operaciones.findByNombre", query = "SELECT o FROM Operaciones o WHERE o.nombre = :nombre")})
public class Operaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idoperacion", nullable = false)
    private Integer idoperacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idoperacion", fetch = FetchType.LAZY)
    private List<Resultados> resultadosList;

    public Operaciones() {
    }

    public Operaciones(Integer idoperacion) {
        this.idoperacion = idoperacion;
    }

    public Operaciones(Integer idoperacion, String nombre) {
        this.idoperacion = idoperacion;
        this.nombre = nombre;
    }

    public Integer getIdoperacion() {
        return idoperacion;
    }

    public void setIdoperacion(Integer idoperacion) {
        this.idoperacion = idoperacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Resultados> getResultadosList() {
        return resultadosList;
    }

    public void setResultadosList(List<Resultados> resultadosList) {
        this.resultadosList = resultadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idoperacion != null ? idoperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operaciones)) {
            return false;
        }
        Operaciones other = (Operaciones) object;
        if ((this.idoperacion == null && other.idoperacion != null) || (this.idoperacion != null && !this.idoperacion.equals(other.idoperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.soap.model.entities.Operaciones[ idoperacion=" + idoperacion + " ]";
    }
    
}
