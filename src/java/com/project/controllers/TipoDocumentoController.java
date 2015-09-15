
package com.project.controllers;

import com.project.entities.TipoDocumento;
import com.project.sessions.TipoDocumentoSession;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TipoDocumentoController implements Serializable {
    
     @EJB //Enterprise Java Beans <- Se encarga de las Transacciones (se coloca arriba de la instancia de session)
    private TipoDocumentoSession usuarioSession;    
    
    private TipoDocumento selectedTipoDocumento;
    private List<TipoDocumento> itemsTipoDocumento = null;
    
    public TipoDocumentoController() {        
    }

    public TipoDocumento getSelectedTipoDocumento() {
        if (selectedTipoDocumento == null) {
            selectedTipoDocumento = new TipoDocumento();  
        }
        return selectedTipoDocumento;
    }

    public void setSelectedTipoDocumento(TipoDocumento selectedTipoDocumento) {
        this.selectedTipoDocumento = selectedTipoDocumento;
    }

    public TipoDocumentoSession getTipoDocumentoSession() {
        return usuarioSession;
    }

    public List<TipoDocumento> getItemsTipoDocumento() {
          if(itemsTipoDocumento == null) {
        try {
            itemsTipoDocumento = getTipoDocumentoSession().findAll();
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
    }
        }
        return itemsTipoDocumento;
    }
    
     public void create() {
        try {
             getTipoDocumentoSession().create(selectedTipoDocumento);  
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            
        }
    }
     public void remove(){
        try {
            getTipoDocumentoSession().remove(selectedTipoDocumento);
            itemsTipoDocumento = null;
        } catch (Exception ex) {
             System.err.println(ex.getMessage());
        }
    }
}
