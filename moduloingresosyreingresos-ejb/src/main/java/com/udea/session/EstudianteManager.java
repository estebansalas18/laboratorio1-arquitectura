/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.Estudiante;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jackson
 */
@Stateless
@LocalBean
public class EstudianteManager{

    @PersistenceContext(unitName = "com.udea_moduloingresosyreingresos-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    public List<Estudiante> getAllEstudiantes() {
        Query db = em.createNamedQuery("Estudiante.findAll");
        return db.getResultList();
    }
    
     public Estudiante updateEstudiante(Estudiante estudiante) {
         return em.merge(estudiante);
    }
 
}
