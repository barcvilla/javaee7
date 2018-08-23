/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Remote;
import mx.com.gm.sga.domain.Persona;

/**
 * Componente del Servidor: Interface remota de EJB.
 * La clase PersonaServiceImpl, implementara esta interface
 * @author PC
 */
@Remote // interface Remote para ser accedido de manera remota a nuestros EJB
public interface PersonaServiceRemote {
    public List<Persona> listarPersonas();
    public Persona encontrarPersonaPorId(Persona persona);
    public Persona encontrarPersonaPorEmail(Persona persona);
    public void registrarPersona(Persona persona);
    public void modificarPersona(Persona persona);
    public void eliminarPersona(Persona persona);
}
