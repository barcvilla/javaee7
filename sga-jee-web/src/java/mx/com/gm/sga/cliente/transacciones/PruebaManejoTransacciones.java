/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente.transacciones;

import javax.naming.Context;
import javax.naming.InitialContext;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author PC
 */
public class PruebaManejoTransacciones {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) throws Exception {
        Context jndi = new InitialContext();
        PersonaServiceRemote personaServiceRemote = (PersonaServiceRemote)jndi.lookup("java:global/sga-jee/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
        log.debug("Iniciando prueba Manejo Transaccional PersonaService");
        
        //buscamos al objeto Persona
        Persona persona1 = personaServiceRemote.encontrarPersonaPorId(new Persona(1));
        
        //cambiamos la persona
        persona1.setApellidoPaterno("VillaVilla");
        
        personaServiceRemote.modificarPersona(persona1);
        log.debug("Objeto modificado: " + persona1);
        log.debug("fin de prueba EJB personaServiceRemote");
    }
}
