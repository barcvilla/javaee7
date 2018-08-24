/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceLocal;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author PC
 */
@Named(value = "personaBean")
@RequestScoped
public class PersonaBean {

    @Inject
    private PersonaServiceLocal personaServiceLocal;
    private Persona personaSeleccionada;
    
    List<Persona> personas;
    
    public PersonaBean() {
    }
    
    @PostConstruct
    public void inicializar()
    {
        //Iniciamos las variables
        personas = personaServiceLocal.listarPersonas();
        personaSeleccionada = new Persona();
    }
    
    public void editListener(RowEditEvent event)
    {
        Persona persona = (Persona) event.getObject();
        personaServiceLocal.modificarPersona(persona);
    }
    
    public List<Persona> getPersonas()
    {
        return personas;
    }
    
    public void setPersonas(List<Persona> personas)
    {
        this.personas = personas;
    }
    
    public Persona getPersonaSeleccionada()
    {
        return personaSeleccionada;
    }
    
    public void setPersonaSeleccionada(Persona personaSeleccionada)
    {
        this.personaSeleccionada = personaSeleccionada;
    }
    
    public void reiniciarPersonaSeleccionada()
    {
        this.personaSeleccionada = new Persona();
    }
    
    public void agregarPersona()
    {
        personaServiceLocal.registrarPersona(this.personaSeleccionada);
        this.personaSeleccionada = null;
    }
    
    public void eliminarPersona()
    {
        personaServiceLocal.eliminarPersona(this.personaSeleccionada);
        this.personaSeleccionada = null;
    }
}
