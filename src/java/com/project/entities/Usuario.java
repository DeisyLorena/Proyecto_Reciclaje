
package com.project.entities;

import com.project.controllers.util.JsfUtil;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
    
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="id_usuario")
 private int idUser;
 
 @Column(name="nombre")
 private String nombresUser;

 @Column(name="primer_apellido")
 private String primerApellido;
 
 @Column(name="segundo_apellido")
 private String segundoApellido;
 
 @Column(name="telefono")
 private String telefonoUser;
 
 @Column(name="direccion")
 private String direccionUser;
 
 @Column(name="email")
 private String correo;
 
 @Column(name="fecha_nacimiento")
 @Temporal(TemporalType.DATE)
 private Date fechaNacimiento;
 
 @Column(name="password")
 private String passwordUser;

 @Column(name="razon_social")
 private String razonSocial;  
 
 @JoinColumn(name="id_rol", referencedColumnName= "id_rol")
  @ManyToOne(optional = false)
 private Rol idRol;
 
 @JoinColumn(name="id_tipo_documento", referencedColumnName= "id_tipo_documento")
 @ManyToOne(optional = false)
 private TipoDocumento idTipoDocumento;
 
 @ManyToOne
    @JoinColumns( {
        @JoinColumn(name="id_ciudad", referencedColumnName="id_ciudad"),
        @JoinColumn(name="id_departamento", referencedColumnName="id_departamento")
    })
    private Ciudad idCiudad;
 
    public Usuario(){   
    }

    public Usuario(int idUser) {
        this.idUser = idUser;
    }
    
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombresUser() {
        return nombresUser;
    }

    public void setNombresUser(String nombresUser) {
        this.nombresUser = nombresUser;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefonoUser() {
        return telefonoUser;
    }

    public void setTelefonoUser(String telefonoUser) {
        this.telefonoUser = telefonoUser;
    }

    public String getDireccionUser() {
        return direccionUser;
    }

    public void setDireccionUser(String direccionUser) {
        this.direccionUser = direccionUser;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        try {
            this.passwordUser = JsfUtil.generateDigest(passwordUser);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
          Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);                  
        }
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    public TipoDocumento getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }  
}
