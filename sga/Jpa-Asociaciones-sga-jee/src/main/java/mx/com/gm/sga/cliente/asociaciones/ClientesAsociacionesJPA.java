/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente.asociaciones;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author PC
 */
public class ClientesAsociacionesJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        
        try
        {
            List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();
            
            // cerramos la transaccion
            em.close();
            
            //impresion de las personas
            imprimirPersonas(personas);
        }
        catch (ConstraintViolationException e) {
            log.log(Level.ERROR, "Exception: ");
            e.getConstraintViolations().forEach(err -> log.log(Level.ERROR, err.toString()));
        }
        
    }
    
    private static void imprimirPersonas(List<Persona> personas)
    {
        // objetos en estado detached o desconectado
        for(Persona persona : personas)
        {
            log.debug("Persona: " + persona);
            //recuperamos los usuarios de cada persona
            for(Usuario usuario : persona.getUsuarioList())
            {
                log.debug("Usuario: " + usuario);
            }
        }
    }
}
