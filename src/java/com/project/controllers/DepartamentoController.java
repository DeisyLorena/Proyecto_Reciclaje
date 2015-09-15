package com.project.controllers;

import com.project.entities.Departamento;
import com.project.entities.Pais;
import com.project.sessions.DepartamentoSession;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DepartamentoController implements Serializable {
    
    @EJB
    private DepartamentoSession departamentoSession;
 
    private Departamento selectedDepartamento;
    private String idPais;
    private List<Departamento> itemsDepartamento = null;
    
     public DepartamentoController() {        
    }
    
    public Departamento getSelectedDepartamento(){ // para retornar datos de tipo departamentos.
        if(selectedDepartamento == null) {
            selectedDepartamento = new Departamento();
        }
        return selectedDepartamento;
    }
    
    public void setSelectedDepartamento(Departamento selectedDepartamento){ // para recibir un parametro de tipo departamento al cual se le nombre como selectedDepartamento. y luego modificarlo e igualarlo ala variable q se siente alamacenada.
        this.selectedDepartamento = selectedDepartamento;
    }

    public String getIdPais() {
        return idPais;
    }

    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }
    
    public DepartamentoSession getDepartamentoSession(){
        return departamentoSession;
    }
    
    public List<Departamento> getItemsDepartamento(){
        if(itemsDepartamento == null){
            try {
                itemsDepartamento = getDepartamentoSession().findAll();
            } catch(Exception ex) {
                System.err.println(ex.getMessage());   
            }
        }
        return itemsDepartamento;
    }  
    public void create() {
        try {
            selectedDepartamento.setIdPais(new Pais(idPais));
            getDepartamentoSession().create(selectedDepartamento);
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    public void remove(){
        try {
            getDepartamentoSession().remove(selectedDepartamento);
            itemsDepartamento = null;
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }   
}
