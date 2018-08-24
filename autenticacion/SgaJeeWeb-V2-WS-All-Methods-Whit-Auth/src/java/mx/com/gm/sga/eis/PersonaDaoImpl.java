/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.eis;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.gm.sga.domain.Persona;

/**
 * Componente EJB que se depositara dentro de un servidor Java. Necesita la anotacionn @Stateles para hacer uso de todos los servicios
 * del Servidor java
 * @author PC
 */
@Stateless
public class PersonaDaoImpl implements PersonaDao{
    @PersistenceContext(unitName = "PersonaPU") // llamamos a nuestro Persistance Unit del archivo persistance.xml
    EntityManager em; // inyectamos el Persistance Unit a em de tipo EntityManager

    @Override
    public List<Persona> findAllPersonas() {
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public Persona findPersonaById(Persona persona) {
        /*metodo find del entity manager, clase que buscamos y el id*/
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public Persona findPersonaByEmail(Persona persona) {
        Query query = em.createQuery("from Persona p where p.email = :email");
        query.setParameter("email", persona.getEmail());
        return (Persona)query.getSingleResult();
    }

    @Override
    public void insertPersona(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void updatePersona(Persona persona) {
        em.merge(persona);
    }

    @Override
    public void deletePersona(Persona persona) {
        //em.merge(persona);
        //em.remove(persona);
        
        if(!em.contains(persona))
        {
            persona = em.merge(persona);
        }
        em.remove(persona);
        
    }
}
