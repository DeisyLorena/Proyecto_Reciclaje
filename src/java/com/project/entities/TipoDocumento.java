
package com.project.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipos_documento")
public class TipoDocumento implements Serializable {
    
    @Id
    @Column(name="id_tipo_documento")
    private String idTipoDocumento;
    
    @Column(name="descripcion_tipo_documento") 
    private String descripcionTipoDoc;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="idTipoDocumento")
     private List<Usuario> listUsuario;
    
    public TipoDocumento(){
    }

    public TipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }
 
     public List<Usuario> getListUsuario (){
        return listUsuario;
    }
    public void setListUsuario(List<Usuario> listUsuario){
        this.listUsuario = listUsuario;
    }

    public String getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getDescripcionTipoDoc() {
        return descripcionTipoDoc;
    }

    public void setDescripcionTipoDoc(String descripcionTipoDoc) {
        this.descripcionTipoDoc = descripcionTipoDoc;
    }
   
}
