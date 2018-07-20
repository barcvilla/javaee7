/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idPersona;
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String email;
    private String telefono;
    
    public Persona(){}
    
    public Persona(int idPersona, String nombre, String apePaterno, String apeMaterno, String email, String telefono)
    {
        super();
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
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
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + 
                ", apePaterno=" + apePaterno + ", apeMaterno=" + apeMaterno + 
                ", email=" + email + ", telefono=" + telefono + '}';
    }
    
    
}
