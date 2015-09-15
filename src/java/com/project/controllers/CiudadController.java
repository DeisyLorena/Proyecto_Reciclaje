package com.project.controllers;

import com.project.entities.Ciudad;
import com.project.entities.Departamento;
import com.project.sessions.CiudadSession;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CiudadController implements Serializable { 
     @EJB
    private CiudadSession ciudadSession;
 
    private Ciudad selectedCiudad;
     private int idDepartamento;
    private List<Ciudad> itemsCiudad = null;
    
     public CiudadController() {        
    }
    
    public Ciudad getSelectedCiudad(){ // para retornar datos de tipo departamentos.
        if(selectedCiudad == null) {
            selectedCiudad = new Ciudad();
        }
        return selectedCiudad;
    }
    
    public void setSelectedCiudad(Ciudad selectedCiudad){ // para recibir un parametro de tipo departamento al cual se le nombre como selectedDepartamento. y luego modificarlo e igualarlo ala variable q se siente alamacenada.
        this.selectedCiudad = selectedCiudad;
    }
    
     public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    public CiudadSession getCiudadSession(){
        return ciudadSession;
    }
    
    public List<Ciudad> getItemsCiudad(){
        if(itemsCiudad == null){
            try {
                itemsCiudad = getCiudadSession().findAll();
            } catch(Exception ex) {
                System.err.println(ex.getMessage());   
            }
        }
        return itemsCiudad;
    }
    
    public void create() {
        try {
            selectedCiudad.setIdDepartamento(new Departamento(idDepartamento));
            getCiudadSession().create(selectedCiudad);
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    } 
    
    public void remove(){
        try{
            getCiudadSession().remove(selectedCiudad);
            itemsCiudad = null;
        } catch(Exception ex){
            System.err.println(ex.getMessage());         
        }
    }
}
