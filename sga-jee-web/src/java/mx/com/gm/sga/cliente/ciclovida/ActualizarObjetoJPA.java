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
public class ActualizarObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try
        {
            //1. Iniciamos la Transaccion
            tx.begin();
            
            //2. Ejecutamos SQL de tipo select. El id proporcionado debe existir en la base de datos
            Persona persona1 = em.find(Persona.class, 2);
            
            //3. Terminamos la transaccion
            tx.commit();
            
            //Objeto en estado detached
            log.debug("Objeto Recuperado: " + persona1);
            
            //4. setValue(nuevoValor)
            persona1.setNombre("Carlos Eduardo");
            persona1.setApellidoPaterno("Villenueve");
            
            //5. Iniciamos una segunda transaccion
            EntityTransaction tx2 = em.getTransaction();
            tx2.begin();
            
            //6. Ejecuta el SQL. Es un select, pero al estar modificado al terminar la transaccion hara un update
            // como ya tenemos el objeto hacemos solo un merge para resincronizar. El objeto a hacer merge, debe contar con el valor de la
            // llave primaria.
            em.merge(persona1); //aplicamos un merge porque el objeto viene de un estado detached. em.persist() se usa cuando viene el objeto de un estado transit
            
            //7. Terminamos la transaccion 2
            //Al momento de hacer commit, se revisan las diferencias entre el objeto de la BD y el objeto en la memoria, si se aplican los cambios
            // si existieran.
            tx2.commit();
            
            //objeto en estado detached ya moficiado
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
