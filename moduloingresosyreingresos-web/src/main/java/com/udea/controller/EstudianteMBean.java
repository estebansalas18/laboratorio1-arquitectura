/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;


import com.udea.Estudiante;
import com.udea.session.CarreraManager;
import com.udea.session.EstudianteManager;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Jackson
 */
public class EstudianteMBean {
    @EJB
    private EstudianteManager estudianteManager;

    @EJB
    private CarreraManager carreraManager;
    /**
     * Creates a new instance of EstudianteMBean
     */
     private Estudiante estudiante; //para mostrar, actualizar o insertar en el formulario
    private List<Estudiante> estudiantes; //para visualizar en la tabla
    public EstudianteMBean() {
    }
    
            //retorna una lista de clientes para mostrar en un datatable de JSF
         public List<Estudiante> getEstudiantes(){
            if((estudiantes==null)||(estudiantes.isEmpty()))
               refresh();
            return estudiantes;
        }
        //Retorna el detalle de cada cliente en el formulario.
        public Estudiante getDetails() {
            return estudiante;
        }
        /**
        * Action handler - llamado cuando en una fila de la tabla se haga click en ID
        * @param estudiante
        * @return
        */
        public String showDetails(Estudiante estudiante) {
            this.estudiante = estudiante;
            return "DETAILS"; // Permite enlazar a EstudianteDetails.xml
        }
        /**
        Profundización en Arquitectura de Software - Universidad de Antioquia
        * Action handler - Actualiza el modelo Estudiante en la BD.
        * Se llama cuando se presiona el boton update del formulario
        * @return
        */
        public String update() {
            
            System.out.println("###UPDATE###");

            estudiante = estudianteManager.updateEstudiante(estudiante);
            return "SAVED"; // Para el caso navegacional
        }
        
        /**
        * Action handler - returno hacia la vista de la lista de clientes
        * @return
        */
        public String list() {
            
            System.out.println("###LIST###");
            
            return "LIST";
        }
        private void refresh() {
            estudiantes=estudianteManager.getAllEstudiantes();
        }
        //Para cargar correctamente los combobox del formulario Details
    
}

