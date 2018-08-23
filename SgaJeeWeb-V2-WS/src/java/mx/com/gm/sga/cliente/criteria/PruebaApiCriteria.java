/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente.criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author PC
 */
public class PruebaApiCriteria {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb =  em.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        
        //Query utilizando el api criteria de JPA
        //1) consulta de todas las personas
        log.debug("\n1) Consulta de todas las personas");
        
        //1. El objeto EntityManager crea instancia CriteriaBuilder
        cb = em.getCriteriaBuilder();
        
        //2. Creamos un objeto criteria query
        criteriaQuery = cb.createQuery(Persona.class);
        
        //3. Creamos el objeto raiz del query
        fromPersona = criteriaQuery.from(Persona.class);
        
        //4. seleccionamos lo necesario del from
        criteriaQuery.select(fromPersona);
        
        //5. creamos el query typeSafe
        query = em.createQuery(criteriaQuery);
        
        //6. ejecutamos las consulta
        List<Persona> personas = query.getResultList();
        mostrarPersonas(personas);
        
        //2-a) Consulta de la persona con id = 1;
        //jpql = "select p from Persona p where p.idPersona = 1";
        log.debug("\n2-a) Consulta de la Persona con id  1:");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 1));
        persona = (Persona)em.createQuery(criteriaQuery).getSingleResult();
        log.debug(persona);
        
        //2-b Consulta de la persona con id = 1
        //jpql = "select p from Persona p where p.idPersona = 1
        log.debug("\n2-b) Consulta de persona con id = 1, forma dinamica");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);
        
        //La clase Predicate permite agregar varios  criterios dinamicamente
        List<Predicate> criterios = new ArrayList<Predicate>();
        
        //verificamos si tenemos criterios que agregar
        Integer idPersonaParam = null;
        idPersonaParam = 1;
        if(idPersonaParam != null)
        {
            ParameterExpression<Integer> p = cb.parameter(Integer.class, "idPersona");
            //criterios.add(cb.equal(fromPersona.get("idPersona"), p));
        }
        
        // se agregan criterios
        if(criterios.isEmpty())
        {
            throw new RuntimeException("Sin criteriaQuery");
        }
        else if(criterios.size() == 1)
        {
            criteriaQuery.where((Expression<Boolean>) criterios.get(0));
        }
        else
        {
            //criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        }
        
        //se crea el query con los criterios
        query = em.createQuery(criteriaQuery);
        if(idPersonaParam != null)
        {
            query.setParameter("idPersona", idPersonaParam);
        }
        
        persona = query.getSingleResult();
        log.debug(persona);
    }
    
    private static void mostrarPersonas(List<Persona> personas)
    {
        for(Persona persona : personas)
        {
            log.debug(persona);
        }
    }
}
