/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente.jpql;

import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author PC
 */
public class PruebaJPQL {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        String jpql = null;
        Query q = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        
        //1. Consulta de todas las personas
        log.debug("\n1) Consulta de todas las Personas");
        jpql = "select p from Persona p";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersona(personas);
        
        //2. Consulta de la Persona con id = 1
        log.debug("\n2) Consulta de la Persona con id = 2");
        jpql = "select p from Persona p where p.idPersona = 2";
        persona = (Persona) em.createQuery(jpql).getSingleResult();
        log.debug(persona);
        
        //3. Consulta de la Persona por nombre:
        log.debug("\n3) Consulta de la Persona por nombre");
        jpql = "select p from Persona p where p.nombre = 'Fernando'";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersona(personas);
        
        //4. Consulta de datos individuales, se crea un arreglo(tupla) de tipo object de 3 columnas
        log.debug("\n4) Consulta de datos individuales, se crea un arreglo (tupla) de tipo Object de 3 columnas");
        jpql = "select p.nombre as Nombre, p.apellidoPaterno as Paterno, p.apellidoMaterno as Materno from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext())
        {
            tupla = (Object[])iter.next();
            String nombre = (String)tupla[0];
            String apePat = (String)tupla[1];
            String apeMat = (String)tupla[2];
            log.debug(nombre + " " + apePat + " " + apeMat);
        }
        
        //5. Obtenemos el objeto Persona y el id, se crea un arreglo de tipo Object con 2 columnas
        log.debug("\n5) Obtiene el objeto Persona y el idPersona, se crea un arreglo (tupla) de tipo Object con 2 columnas");
        jpql = "select p, p.idPersona from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext())
        {
            tupla = (Object[])iter.next();
            persona = (Persona)tupla[0];
            int idPersona = (int)tupla[1];
            log.debug("Objeto Persona: " + persona);
            log.debug("id persona: " + idPersona);
        }
        
        //6. Consulta de todas las personas
        log.debug("\n6) Consulta de todas las Personas");
        jpql = "select new mx.com.gm.sga.domain.Persona(p.idPersona) from Persona p";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersona(personas);
        
        //7. Regresamos el valor minimo y maximo del idPersona
        log.debug("\n7) Regresa el valor minimo y maximo del idPersona (Scalar Results");
        jpql = "select min(p.idPersona) as MinId, max(p.idPersona) as MaxId, count(p.idPersona) from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext())
        {
            tupla = (Object[])iter.next();
            Integer idMin = (Integer)tupla[0];
            Integer idMax = (Integer)tupla[1];
            Long count = (Long)tupla[2];
            log.debug("idMin: " + idMin + " idMax: " + idMax + " count: " + count );
        }
        
    }
    
    private static void mostrarPersona(List<Persona> personas)
    {
        for(Persona persona : personas)
        {
            log.debug(persona);
        }
    }
    
    private static void mostrarUsuario(List<Usuario> usuarios)
    {
        for(Usuario usuario : usuarios)
        {
            log.debug(usuarios);
        }
    }
}
