/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import beans.dominio.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * 
 * @author PC
 */
public class TestEntidadPersona {
    
    static EntityManager em = null;
    static EntityTransaction tx = null;
    static EntityManagerFactory emf = null;
    Logger log = LogManager.getRootLogger();
    
    public TestEntidadPersona() {
    }
    
    @BeforeClass // metodo que se ejecuta antes de la instaciacion de la clase
    public static void init()throws Exception
    {
        emf = Persistence.createEntityManagerFactory("PersonaPU");
    }
    
    @Before
    public void setup()
    {
        try
        {
            em = emf.createEntityManager(); // creacion de una instancia del EntityManager
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    @Test
    public void testPersonaEntity()
    {
        log.debug("Iniciando test Persona Entity con JPA");
        assertTrue(em != null);
        
        /*Comenzamos una transaccion*/
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        /*No se debe especificar el ID, ya que se genera automaticamente*/
        Persona persona1 = new Persona("Oscar", "Gomez", "Laros", "ogomez@gmail.com", "12345678");
        log.debug("Objeto a persistir..." + persona1);
        em.persist(persona1);
        tx.commit(); // terminamos la transaccion
        
        assertTrue(persona1.getIdPersona() != null); 
        log.debug("Objeto persistido: " + persona1);
        log.debug("Fin test Persona Entity con JPA");
    }
    
    @After
    public void tearDown() throws Exception
    {
        if(em != null)
        {
            em.close();
        }
    }
}
