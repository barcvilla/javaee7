/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio.rest;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceLocal;

/**
 *
 * @author PC
 */
@Path("/personas") //exponemos la clase como web service rest
@Stateless //esta clse es un ejb
public class PersonaServiceRS {
    @EJB // injeccion de ejb
    private PersonaServiceLocal personaServiceLocal;
    
    @GET
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) // produce datos con xml y con JSon
    public List<Persona> listarPersonas() {
        return personaServiceLocal.listarPersona();
    }
    
    @GET
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}") //hace referencia a /personas/{id}    
    public Persona encontrarPersonaPorId(@PathParam("id") int id) {
        return personaServiceLocal.encontrarPersonaPorId(new Persona(id));
    }
    
    @POST
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarPersona(Persona persona) {
        try {
            personaServiceLocal.registrarPersona(persona);
            return Response.ok().entity(persona).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarPersona(@PathParam("id") int id, Persona personaModificada) {
        try {
            Persona persona = personaServiceLocal.encontrarPersonaPorId(new Persona(id));
            if (persona != null) {
                personaServiceLocal.modificarPersona(personaModificada);
                return Response.ok().entity(personaModificada).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarPersonaPorId(@PathParam("id") int id) {
        try {
            personaServiceLocal.eliminarPersona(new Persona(id));
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }

}
