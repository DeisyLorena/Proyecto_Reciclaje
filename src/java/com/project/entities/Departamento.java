
package com.project.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departamentos")
public class Departamento implements Serializable {
    
    @Id
    @Column(name="id_departamento")
    private int idDepartamento;
    
    @Column(name="nombre_departamento")
    private String nombreDepartamento;
    
    @JoinColumn(name="id_pais", referencedColumnName= "id_pais")
    @ManyToOne(optional = false)
    private Pais idPais;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartamento")
    private List<Ciudad> listCiudad;
    
    public Departamento(){
    }
    
    public Departamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    //Getter = para retornar o mostrar 
    public int getIdDepartamento(){
        return idDepartamento;
    }
    //setter = para modificar algo y para esto tenemos que enviar un parametro.
    public void setIdDepartamento(int idDepartamento){
        this.idDepartamento = idDepartamento;
    }
   //Getter = para retornar o mostrar 
   public String getNombreDepartamento(){
       return nombreDepartamento;
   }
    //setter = para modificar algo y para esto tenemos que enviar un parametro.
   public void setNombreDepartamento(String nombreDepartamento){
       this.nombreDepartamento = nombreDepartamento;
   }
   //Getter = para retornar o mostrar 
   public Pais getIdPais() {
       return idPais;
   }
   //setter = para modificar algo y para esto tenemos que enviar un parametro.
   public void setIdPais(Pais idPais){
       this.idPais = idPais;
   }

    public List<Ciudad> getListCiudad() {
        return listCiudad;
    }

    public void setListCiudad(List<Ciudad> listCiudad) {
        this.listCiudad = listCiudad;
    }
    
}
