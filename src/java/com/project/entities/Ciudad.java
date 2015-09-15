
package com.project.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ciudades")
@IdClass (value = CiudadPK.class)
public class Ciudad implements Serializable {
    
    @Id
    @Column(name="id_ciudad")
    private int idCiudad;
    
    @Id
    @ManyToOne
    @JoinColumn(name="id_departamento", referencedColumnName="id_departamento")
    private Departamento idDepartamento;
    
    @Column(name="nombre_ciudad")
    private String nombreCiudad;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad")
    private List<Usuario> listUsuario;

    public Ciudad(){
    }
    
    public Ciudad(int idCiudad, Departamento idDepartamento){
        this.idCiudad = idCiudad;
        this.idDepartamento = idDepartamento;
    }
    
    public int getIdCiudad (){
        return idCiudad;
    }
    
    public void setIdCiudad(int idCiudad){
        this.idCiudad = idCiudad;
    }
    
    public Departamento getIdDepartamento(){
        return idDepartamento;
    }
    
    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    public String getNombreCiudad(){
        return nombreCiudad;
    }
    
    public void setNombreCiudad(String nombreCiudad){
        this.nombreCiudad = nombreCiudad;
    }
    
    public List<Usuario> getListUsuario (){
        return listUsuario;
    }
    
    public void setListUsuario(List<Usuario> listUsuario){
        this.listUsuario = listUsuario;
    }
    
}
