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
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author PC
 */
public class PersistirObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //Iniciamos la Transaccion
        
        // Paso 1. crear un nuevo objeto : Objeto en estado transitivo
        Persona persona1 = new Persona("Mariana", "Luna", "Jimenez", "mluna@gmail.com", "123456789");

        try 
        {
            // Paso 2.Iniciamos la transaccion
            tx.begin();

            // Paso 3. Ejecutamos SQL
            em.persist(persona1);

            // Paso 4. Commit/rollback
            tx.commit();

            //Objeto en estado detached
            log.debug("Objeto Persistido: " + persona1);
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
