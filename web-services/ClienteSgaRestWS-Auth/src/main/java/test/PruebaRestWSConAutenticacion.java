/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Persona;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

/**
 *
 * @author PC
 */
public class PruebaRestWSConAutenticacion {
    public static void main(String[] args) {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().nonPreemptive().credentials("admin", "admin").build();
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(feature);
        
        Client cliente = ClientBuilder.newClient(clientConfig);
        
        //Leer una persona (metodo get)
        WebTarget webTarget = cliente.target("http://localhost:8080/SgaJeeWeb-V2-RESTFUL-WS/webservice").path("/personas");
        //Proporcionamos un idPersona valido
        Persona persona = webTarget.path("/3").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona Recuperada: " + persona);
    }
}
