
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
@Table(name="roles")
public class Rol implements Serializable {
    
@Id
@Column(name="id_rol")
private String idRol;

@Column(name="nombre_rol")
private String nombreRol;

 @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
  private List<Usuario> listUsuario;
 
 public Rol(){
    }

    public Rol(String idRol) {
        this.idRol = idRol;
    }

  public List<Usuario> getListUsuario (){
     return listUsuario;
    }
  
  public void setListUsuario(List<Usuario> listUsuario){
        this.listUsuario = listUsuario;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    
}
