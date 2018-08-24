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
import static mx.com.gm.sga.cliente.ciclovida.ActualizarObjetoJPA.log;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author PC
 */
public class EliminarObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try
        {
            //1/. Iniciamos la transaccion
            tx.begin();
            
            //2. Ejecutamos SQL de tipo select, proporcionamos un id de persona valido
            Persona persona1 = em.find(Persona.class, 11);
            
            //3. Terminamos la transaccion
            tx.commit();
            
            //4. Iniciamos una segunda transaccion
            EntityTransaction tx2 = em.getTransaction();
            tx2.begin();
            
            //5. ejecutamos un sql (es un delete)
            em.remove(persona1);
            
            //6. Terminamos la transaccion 2, al momento de hacer el commit se realiza el delete
            tx2.commit();
            
            // objeto en estado detached ya modificado. Ya no es posible resincronizarlo en otra transaccion. Solo esta en memoria, pero al 
            // terminar el metodo se elimina.
            log.debug("Objeto eliminado: " + persona1);
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
