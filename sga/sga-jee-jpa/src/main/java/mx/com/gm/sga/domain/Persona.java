/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
/*adicionamos el query llamado Persona.findAll. Usamos una sentencia JPQL: Select a todos los objetos de tipo Persona en la BD
  ordenados por el idPersona*/
@NamedQueries({@NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p ORDER BY p.idPersona")})
@Table(name = "persona")// indicamos el nombre de la tabla
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int idPersona;
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
