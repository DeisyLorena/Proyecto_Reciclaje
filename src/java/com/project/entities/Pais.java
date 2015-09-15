
package com.project.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "paises")
public class Pais implements Serializable {
    
    @Id
    @Column(name = "id_pais")
    private String idPais;
    
    @Column(name = "nombre_pais")
    @Size(max = 60)
    private String nombrePais;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPais")
    private List<Departamento> listDepartamento;
    
    public Pais(){
    }

    public Pais(String idPais) {
        this.idPais = idPais;
    }

    public List<Departamento> getListDepartamento (){
        return listDepartamento;
    }
    
    public void setListDepartamento(List<Departamento> listDepartamento){
        this.listDepartamento = listDepartamento;
    }
   
    //Getter = para retornar o mostrar
    public String getIdPais() {
        return idPais;
    }
    //setter = para modificar algo y para esto tenemos que enviar un parametro.
    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }   
}
