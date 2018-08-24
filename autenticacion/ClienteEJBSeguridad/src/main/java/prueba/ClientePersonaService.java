/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
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
        System.out.println("Inicio de llamada al EJB desde el cliente\n");
        
        String authFile = "login.conf";
        System.setProperty("java.security.auth.login.config", authFile);
        ProgrammaticLogin programmaticLogin = new ProgrammaticLogin();
        programmaticLogin.login("admin", "admin".toCharArray());
        
        try
        {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/SgaJeeWeb-V2-WS-All-Methods-Whit-Auth/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            List<Persona> personas = personaService.listarPersonas();
            
            for(Persona persona : personas)
            {
                System.out.println(persona);
            }
            System.out.println("\nFin a la llamada del EJB desde el cliente");
        }
        catch(NamingException e)
        {
            e.printStackTrace(System.out);
        }
    }
}
