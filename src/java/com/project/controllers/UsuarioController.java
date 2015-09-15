
package com.project.controllers;

import com.project.entities.Ciudad;
import com.project.entities.Departamento;
import com.project.entities.Rol;
import com.project.entities.TipoDocumento;
import com.project.entities.Usuario;
import com.project.sessions.UsuarioSession;
import java.io.Serializable;
import java.util.List;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class UsuarioController implements Serializable {
    
     @EJB //Enterprise Java Beans <- Se encarga de las Transacciones (se coloca arriba de la instancia de session)
    private UsuarioSession usuarioSession;
    private int idCiudad;
    private int idDepartamento;
    private String idRol;
    private String idTipoDocumento;
    private Usuario selectedUsuario;
    private List<Usuario> itemsUsuario = null;
    
    public UsuarioController() {        
    }
    
     public String getCiudad() {
        return idCiudad + "," + idDepartamento;
    }

    public void setCiudad(String ciudad) {
        StringTokenizer tokens = new StringTokenizer (ciudad, ",");
        idCiudad = Integer.parseInt(tokens.nextToken());
        idDepartamento = Integer.parseInt(tokens.nextToken());
    }
    
    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }
    
    public String getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }
    
    public Usuario getSelectedUsuario() {
        if (selectedUsuario == null) {
            selectedUsuario = new Usuario();  
        }
        return selectedUsuario;
    }
    
    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public UsuarioSession getUsuarioSession() {
        return usuarioSession;
    }
    public List<Usuario> getItemsUsuario() {
          if(itemsUsuario == null) {
        try {
            itemsUsuario = getUsuarioSession().findAll();
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
    }
        }
        return itemsUsuario;
    } 
    
     public void create() {
        try {
            selectedUsuario.setIdCiudad(new Ciudad(idCiudad, new Departamento(idDepartamento)));
            selectedUsuario.setIdRol(new Rol(idRol));
            selectedUsuario.setIdTipoDocumento(new TipoDocumento(idTipoDocumento));
             getUsuarioSession().create(selectedUsuario);  
        } catch (Exception ex) {
            System.err.println(ex.getMessage());            
        }
    }
     
     public void remove(){
         try{
             getUsuarioSession().remove(selectedUsuario);
             itemsUsuario = null;
         } catch (Exception ex)  {
             System.err.println(ex.getMessage());
         }
     }
}
