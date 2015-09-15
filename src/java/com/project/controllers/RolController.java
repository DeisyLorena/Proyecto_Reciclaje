package com.project.controllers;

import com.project.entities.Rol;
import com.project.sessions.RolSession;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class RolController {
    
      @EJB //Enterprise Java Beans <- Se encarga de las Transacciones (se coloca arriba de la instancia de session)
    private RolSession rolSession;    
    
    private Rol selectedRol;
    private List<Rol> itemsRol= null;
    
    public RolController() {        
    }

    public Rol getSelectedRol() {
        if (selectedRol == null) {
            selectedRol = new Rol();  
        }
        return selectedRol;
    }
    public void setSelectedRol(Rol selectedRol) {
        this.selectedRol = selectedRol;
    }

    public RolSession getRolSession() {
        return rolSession;
    }

    public List<Rol> getItemsRol() {
        if(itemsRol == null) {
        try {
            itemsRol = getRolSession().findAll();
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
    }
        }
        return itemsRol;
    } 
    
    public void create() {
        try {
             getRolSession().create(selectedRol);  
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            
        }
    }
    
     public void remove(){
        try {
            getRolSession().remove(selectedRol);
            itemsRol = null;
        } catch (Exception ex) {
             System.err.println(ex.getMessage());
        }
    }
    
}
