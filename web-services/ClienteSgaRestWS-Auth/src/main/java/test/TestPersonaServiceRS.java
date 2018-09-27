/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Persona;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

/**
 *
 * @author PC
 */
public class TestPersonaServiceRS {
    //variable que usaremos
    private static final String URL_BASE = "http://localhost:8080/SgaJeeWeb-V2-RESTFUL-WS/webservice";
    private static Client cliente;
    private static WebTarget webTarget; //variables para llamar los metodos del WS
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder; // variable para llamar al WS
    private static Response response; //respuesta de WS
    
    public static void main(String[] args) {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().nonPreemptive().credentials("admin", "admin").build();
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(feature);
        
        cliente = ClientBuilder.newClient(clientConfig);
        
        //Leer una persona (metodo get)
        webTarget = cliente.target(URL_BASE).path("/personas");
        //Proporcionamos un idPersona valido
        persona = webTarget.path("/3").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona Recuperada: " + persona);
        
        //Leer todas las personas (metodo get con readEntity de tipo List<>)
        personas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>(){});
        System.out.println("\nPersona recuperadas:");
        imprimirPersonas(personas);
        
        /**
        //Agregar una persona (metodo post)       
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Carlos");
        nuevaPersona.setApellidoPaterno("Miranda");
        nuevaPersona.setApellidoPaterno("Ramirez");
        nuevaPersona.setEmail("cmiranda@mail.com");
        nuevaPersona.setTelefono("357951852");
        invocationBuilder =  webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(nuevaPersona, MediaType.APPLICATION_XML));
        
        
        System.out.println("");
          System.out.println("Estatus respuesta agregar:" + response.getStatus());
        //Recuperamos a la persona recien agregada para despues modificarla y al final eliminarla
        Persona personaRecuperada = response.readEntity(Persona.class);
        System.out.println("Persona agregada: " + personaRecuperada);
        **/
        
        /** funciona
        //Modificar una persona (metodo put)
        //persona recuperada anteriormente
        Persona personaModificar = persona; //personaRecuperada;
        personaModificar.setApellidoMaterno("CambioApeMat");
        String pathId = "/" + personaModificar.getIdPersona();
        invocationBuilder =  webTarget.path( pathId ).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(pathId, MediaType.WILDCARD_TYPE).entity(personaModificar, MediaType.APPLICATION_XML));
 
        System.out.println("");
         System.out.println("Estatus respuesta modificar:" + response.getStatus());
        System.out.println("Persona modificada: " + response.readEntity(Persona.class));
        **/
        
        
                
        //Eliminar una persona       
        // persona recuperada anteriormente        
        Persona personaEliminar = persona; //personaRecuperada;
        String pathEliminarId = "/" + personaEliminar.getIdPersona();
        invocationBuilder =  webTarget.path( pathEliminarId ).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
 
        System.out.println("");
        System.out.println("Estatus respuesta eliminar: " + response.getStatus());
        System.out.println("Persona Eliminada: ");
        
    }
    
    private static void imprimirPersonas(List<Persona> personas){
       for(Persona persona: personas){
            System.out.println("Persona:" + persona);
        }
    }
}
