/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.Carrera;
import com.udea.session.CarreraManager;
import com.udea.session.EstudianteManager;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Jackson
 */
public class CarreraMBean implements Serializable{

    @EJB
    private EstudianteManager estudianteManager;

    @EJB
    private CarreraManager carreraManager;

    
      //Propiedades del modelo
 private Carrera carrera; //para mostrar, actualizar o insertar en el formulario
 private List<Carrera> carreras; //para visualizar en la tabla
 
 
    public CarreraMBean() {}

        //retorna una lista de clientes para mostrar en un datatable de JSF
         public List<Carrera> getCarreras(){
            if((carreras==null)||(carreras.isEmpty()))
               refresh();
            return carreras;
        }
        //Retorna el detalle de cada cliente en el formulario.
        public Carrera getDetails() {
            return carrera;
        }
        /**
        * Action handler - llamado cuando en una fila de la tabla se haga click en ID
        * @param carrera
        * @return
        */
        public String showDetails(Carrera carrera) {
            this.carrera = carrera;
            return "DETAILS"; // Permite enlazar a CarreraDetails.xml
        }
        /**
        Profundización en Arquitectura de Software - Universidad de Antioquia
        * Action handler - Actualiza el modelo Carrera en la BD.
        * Se llama cuando se presiona el boton update del formulario
        * @return
        */
        public String update() {
            
            System.out.println("###UPDATE###");

            carrera = carreraManager.updateCarrera(carrera);
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
            carreras=carreraManager.getAllCarreras();
        }
        //Para cargar correctamente los combobox del formulario Details
    
        }
