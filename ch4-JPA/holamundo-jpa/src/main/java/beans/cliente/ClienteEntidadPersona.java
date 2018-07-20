/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.cliente;

import beans.dominio.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author PC
 */
public class ClienteEntidadPersona {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //iniciamos la transaccion
        tx.begin();
        // no se debe especificar el ID ya que se genera en automatico
        Persona persona1 = new Persona("Maria", "Guitierrez", "Esparza", "maria@gmail.com.mx", "1234667899");
        log.debug("Objeto a persistir: " + persona1);
        //persistimos el objeto
        em.persist(persona1);
        //terminamos la transaccion
        tx.commit();
        log.debug("Objeto persistido: " + persona1);
        em.close();
    }
}
