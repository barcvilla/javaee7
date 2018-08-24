/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

/**
 *
 * @author PC
 */
public class ClientePersonaServiceConIP {
    public static void main(String[] args) {
        System.out.println("Inicio de llamada al EJB desde el cliente\n");
        
        String authFile = "login.conf";
        System.setProperty("java.security.auth.login.config", authFile);
        ProgrammaticLogin programmaticLogin = new ProgrammaticLogin();
        programmaticLogin.login("admin", "admin".toCharArray());
        
        try
        {
            Properties props = new Properties();
            props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            
            //optional. default localhost aqui se cambia la IP del servidor donde esta Glassfish
            props.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
            //optional puerto por default 3700 solo se cambia cuando el puerto no es 3700
            //props.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1)
            Context jndi = new InitialContext(props);
            PersonaServiceRemote personaServiceRemote = (PersonaServiceRemote) jndi.lookup("java:global/SgaJeeWeb-V2-WS-All-Methods-Whit-Auth/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            List<Persona> personas = personaServiceRemote.listarPersonas();
            for(Persona persona : personas)
            {
                System.out.println(persona);
            }
            
            System.out.println("\nFin de la llamada remota al EJB desde el cliente");
        }
        catch(NamingException ex)
        {
            ex.printStackTrace();
        }
    }
}
