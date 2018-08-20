/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;
import static mx.com.gm.sga.cliente.ciclovida.PersistirObjetoJPA.log;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author PC
 */
public class EncontrarObjetoJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try
        {
            //1. Iniciamos la transaccion
            tx.begin();
            
            //2. Ejecutamos SQL de tipo select
            Persona persona1 = em.find(Persona.class, 1);
            
            //3. Termina la transaccion
            tx.commit();
            
            //Objeto en estado detached
            log.debug("Objeto recuperado: " + persona1);
        }
        catch (ConstraintViolationException e) {
            log.log(Level.ERROR, "Exception: ");
            e.getConstraintViolations().forEach(err -> log.log(Level.ERROR, err.toString()));
        }
        finally
        {
            // Cerramos el Entity Manager
            em.close();
        }
    }
}
