/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.eis.PersonaDao;

/**
 * Componente EJB que implementa la interface PersonaServiceRemote y PersonaServiceLocal
 * @author PC
 */
@WebService(endpointInterface = "mx.com.gm.sga.servicio.PersonaServiceWS")
@Stateless
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})//agregamos la seguridad al EJB y los metodos del EJB
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaServiceLocal, PersonaServiceWS{
    
    @EJB
    private PersonaDao personaDao; //inyectamos la referencia del personaDao
    
    @Resource
    private SessionContext contexto;

    @Override
    public List<Persona> listarPersonas() {
        return personaDao.findAllPersonas();
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return personaDao.findPersonaById(persona);
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return personaDao.findPersonaByEmail(persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
        personaDao.insertPersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
        try
        {
            personaDao.updatePersona(persona);
        }
        catch(Throwable t)
        {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
        
    }
    
    @RolesAllowed({"ROLE_ADMIN"}) // eliminar persona solo lo podra ejecutar el rol de administrador    
    @Override
    public void eliminarPersona(Persona persona) {
        personaDao.deletePersona(persona);
    }
    
}
