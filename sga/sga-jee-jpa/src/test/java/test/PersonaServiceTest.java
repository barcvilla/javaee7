/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceLocal;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * CLIENTE LOCAL EN EL MISMO SERVIDOR
 * Clase que hace una llamada local (Cliente y EJB dentro del mismo servidor) a la interface PersonaServiceLocal
 * @author PC
 */
public class PersonaServiceTest {
    
    private PersonaServiceLocal personaServiceLocal;
    
    @Before
    public void setUp() throws Exception
    {
        /*Generamos una instancia del contenedor*/
        EJBContainer contenedor = EJBContainer.createEJBContainer();
        /*buscamos nuestro ejb PersonaServiceImpl mediante nuestra interface PersonaServiceLocal*/
        personaServiceLocal = (PersonaServiceLocal)
                contenedor.getContext().lookup("java:global/classes/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceLocal");
    }
    
    @Test
    public void testEJBPersonaService()
    {
        System.out.println("Iniciando test EJB PersonaService");
        assertTrue(personaServiceLocal != null);
        assertEquals(4, personaServiceLocal.listarPersona().size());
        System.out.println("El no. de personas es igual a " + personaServiceLocal.listarPersona().size());
        this.desplegarPersona(personaServiceLocal.listarPersona()); //llamamos al metodo del EJB a traves de la interface local
        System.out.println("Fin test EJB PersonaServiceLocal");
    }
    
    private void desplegarPersona(List<Persona> personas)
    {
        for(Persona persona : personas)
        {
            System.out.println(persona);
        }
    }
}
