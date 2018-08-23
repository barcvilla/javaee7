/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclientesws;

import clientesga.ws.Persona;
import clientesga.ws.PersonaServiceImplService;
import clientesga.ws.PersonaServiceWS;
import java.util.List;

/**
 *
 * @author PC
 */
public class TestPersonaServiceWS {
    public static void main(String[] args) {
        PersonaServiceWS personaService = new PersonaServiceImplService().getPersonaServiceImplPort();
        System.out.println("Ejecutando Servicio Listar Persona WS");
        List<Persona> personas = personaService.listarPersonas();
        for(Persona persona : personas)
        {
            System.out.println("Persona: " + persona.getIdPersona() + 
                    " " + persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno() + 
                    " " + persona.getEmail() + " " + persona.getTelefono());
        }
        System.out.println("Fin del servicio Listar Persona WS\n");
        
        System.out.println("\nEjecutando Servicio Encontrar Persona WS por ID");
        Persona encontrarPersonaId = new Persona();
        encontrarPersonaId.setIdPersona(1);
        Persona personaEncontrada = personaService.encontrarPersonaPorId(encontrarPersonaId);
        System.out.println("Persona Encontrada: " + personaEncontrada.getIdPersona() + " " + personaEncontrada.getNombre()+ " " + 
                personaEncontrada.getApellidoPaterno() + " " + personaEncontrada.getApellidoMaterno() + " " +
                personaEncontrada.getEmail() + " " + personaEncontrada.getTelefono());
        System.out.println("Fin del Servicio Encontrar Persona WS.\n");
        
        
        System.out.println("\nEjecutando Servicio Modificar Persona WS");
        personaEncontrada.setEmail("barcvilla@gmail.com");
        personaService.modificarPersona(personaEncontrada);
        System.out.println("Persona modificada: " + personaEncontrada.getIdPersona() + " " + personaEncontrada.getNombre() + " " + personaEncontrada.getApellidoPaterno());
        System.out.println("Fin Servicio Modificar Persona Persona WS\n");
        
        System.out.println("Ejecutando Servicio Listar Persona WS");
        personas = personaService.listarPersonas();
        for(Persona persona : personas)
        {
            System.out.println("Persona: " + persona.getIdPersona() + 
                    " " + persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno() + 
                    " " + persona.getEmail() + " " + persona.getTelefono());
        }
        System.out.println("Fin del servicio Listar Persona WS\n");
        
        System.out.println("\nEjecutando Servicio Eliminar Persona WS");
        personaService.eliminarPersona(personaEncontrada);
        System.out.println("Persona Eliminada: " + personaEncontrada.getIdPersona() + " " + personaEncontrada.getNombre() + " " + personaEncontrada.getApellidoPaterno());
        System.out.println("Fin del Servicio Eliminar Persona WS\n");
        
        System.out.println("Ejecutando Servicio Listar Persona WS");
        personas = personaService.listarPersonas();
        for(Persona persona : personas)
        {
            System.out.println("Persona: " + persona.getIdPersona() + 
                    " " + persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno() + 
                    " " + persona.getEmail() + " " + persona.getTelefono());
        }
        System.out.println("Fin del servicio Listar Persona WS\n");
        
        /* si funciona
        System.out.println("\nEjecutando Servicio Encontrar Persona WS por Email");
        Persona encontrarPersonaEmail = new Persona();
        encontrarPersonaEmail.setEmail("ceva_19@hotmail.com");
        Persona personaEncontradaEmail = personaService.encontrarPersonaPorEmail(encontrarPersonaEmail);
        System.out.println("Persona Encontrada: " + personaEncontradaEmail.getIdPersona() + " " + personaEncontradaEmail.getApellidoPaterno() + " " + 
                personaEncontradaEmail.getApellidoMaterno() + " " + personaEncontradaEmail.getEmail() + " " + personaEncontradaEmail.getTelefono());
        System.out.println("Fin del Servicio Encontrar Persona WS por Email\n");
        **/

    }
}
