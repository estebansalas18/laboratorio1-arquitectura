/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jackson
 */
@Entity
@Table(name = "carrera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c")
    , @NamedQuery(name = "Carrera.findByCarreraId", query = "SELECT c FROM Carrera c WHERE c.carreraId = :carreraId")
    , @NamedQuery(name = "Carrera.findByNombreCarrera", query = "SELECT c FROM Carrera c WHERE c.nombreCarrera = :nombreCarrera")
    , @NamedQuery(name = "Carrera.findByModalidad", query = "SELECT c FROM Carrera c WHERE c.modalidad = :modalidad")})
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "carrera_id")
    private Integer carreraId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_carrera")
    private String nombreCarrera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "modalidad")
    private String modalidad;

    public Carrera() {
    }

    public Carrera(Integer carreraId) {
        this.carreraId = carreraId;
    }

    public Carrera(Integer carreraId, String nombreCarrera, String modalidad) {
        this.carreraId = carreraId;
        this.nombreCarrera = nombreCarrera;
        this.modalidad = modalidad;
    }

    public Integer getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Integer carreraId) {
        this.carreraId = carreraId;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carreraId != null ? carreraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.carreraId == null && other.carreraId != null) || (this.carreraId != null && !this.carreraId.equals(other.carreraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.Carrera[ carreraId=" + carreraId + " ]";
    }
    
}
