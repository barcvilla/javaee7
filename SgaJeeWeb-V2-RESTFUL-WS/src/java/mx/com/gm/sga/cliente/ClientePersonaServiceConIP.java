/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente;

import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

/**
 * Este caso se aplica cuando el cliente esta en otro equipo ya que nos siempre el cliente esta en el servidor java
 * @author PC
 */
public class ClientePersonaServiceConIP {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        try
        {
            Properties props = new Properties();
            props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            /*optioal. Default localhost. Aqui se cambiaa IP del servidor donde esta Glassfish*/
            props.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
            /*optional. Puerto por default 3700. Solo se necesita cambiar si el puerto no es 3700*/
            /*props.setProperty("org.omg.CORBA.ORBInitialHost", "3700");*/
            Context jndi = new InitialContext(props);
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
