/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente.cascada;

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
public class PersistenciaCascadaJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try
        {
            //1. Creamos un objeto Persona que en estado Transitivo
            Persona persona1 = new Persona("Braulio", "Figueroa", "Sanchez", "bfigueroa@gmail.com", "123456789");
            
            //Creamos el objeto usuario (tiene dependencia con el objeto persona)
            Usuario usuario1 = new Usuario("bfigueroa", "123", persona1);
            
            //2. Inicia transaccion
            tx.begin();
            
            //3. Ejecutar SQL. Solo persistimos el objeto Usuario. No hay necesidad de persistir el objeto persona1, se hara por cascada
            em.persist(usuario1);
            
            //4. Commit/rollback
            tx.commit();
            
            // Objeto en estado detached
            log.debug("Objeto persistido Usuario: " + usuario1);
            log.debug("Objeto persistido Persona: " + persona1);
            
        }
        catch (ConstraintViolationException e) {
            log.log(Level.ERROR, "Exception: ");
            e.getConstraintViolations().forEach(err -> log.log(Level.ERROR, err.toString()));
        }
        finally
        {
            em.close();
        }
    }
}
