/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.Estudiante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jackson
 */
@Local
public interface EstudianteManagerLocal {

    List<Estudiante> getAllEstudiantes();

    Estudiante updateEstudiante(Estudiante estudiante);

 
    
}
