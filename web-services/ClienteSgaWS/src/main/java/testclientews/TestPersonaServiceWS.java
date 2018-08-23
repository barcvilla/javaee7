/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclientews;

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
            System.out.println("Personas: " + persona.getNombre() +  " " + persona.getApellidoPaterno());
        }
        System.out.println("Fin Servicio Listar Personas WS");
    }
}
