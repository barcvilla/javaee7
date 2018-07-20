/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author PC
 */
@Entity
public class Persona implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//se genera el autoincremento
    @Column(name = "id_persona")// corresponde al nombre de la tabla en la BD
    private Integer idPersona; 
    
    /*El campo nombre de la tabla Persona coincide con la variable de clase nombre por lo que no hay necesidad de indicar el name*/
    @Column(nullable = false, length = 45)
    private String nombre;
    
    @Column(name = "apellido_paterno", nullable = false, length = 45)
    private String apePaterno;
    
    @Column(name = "apellido_materno", length = 45)
    private String apeMaterno;
    
    @Column(nullable = false, length = 45)
    private String email;
    
    @Column(length = 45)
    private String telefono;
    
    public Persona(){}
    
    public Persona(Integer idPersona)
    {
        this.idPersona = idPersona;
    }
    
    public Persona(String nombre, String apePaterno, String apeMaterno, String email, String telefono)
    {
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.email = email;
        this.telefono = telefono;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apePaterno=" + apePaterno + ", apeMaterno=" + apeMaterno + ", email=" + email + ", telefono=" + telefono + '}';
    }
    
    
    
    
}
