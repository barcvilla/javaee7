/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.eis.PersonaDao;

/**
 * Componente EJB que implementa la interface PersonaServiceRemote y PersonaServiceLocal
 * @author PC
 */
@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaServiceLocal{
    
    @EJB
    private PersonaDao personaDao; //inyectamos la referencia del personaDao
    
    @Resource
    private SessionContext contexto;

    @Override
    public List<Persona> listarPersona() {
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

    @Override
    public void eliminarPersona(Persona persona) {
        personaDao.deletePersona(persona);
    }
    
}
