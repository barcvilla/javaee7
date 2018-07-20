/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

/**
 * 
 * @author PC
 */
public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando la llamada al EJB desde el cliente\n");
        //iniciamos el contexto del EJB
        try
        {
            Context jndi = new InitialContext();
            //Asiganamos a una variable de tipo PersonaServiceRemote la llamada remota a nuestro componente EJB.
            //personaService apunta a nuestro EJB de manera remota
            PersonaServiceRemote personaService = (PersonaServiceRemote)jndi.lookup("java:global/sga-jee/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            List<Persona> personas = personaService.listarPersona();
            //iteramos la lista
            for(Persona persona : personas)
            {
                System.out.println(persona);
            }
            System.out.println("\nFin de la llamada al EJB desde el cliente");
        }
        catch(NamingException ex)
        {
            ex.printStackTrace();;
        }
    }
}
