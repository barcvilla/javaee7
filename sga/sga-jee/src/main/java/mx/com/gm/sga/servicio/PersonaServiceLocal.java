/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Persona;

/**
 * La llamada local a un EJB se realiza cuando se tienen componentes web en el servidor. Asi se evitan las llamadas remotas.
 * Esta interface al igual que PersonaServiceRemote utilizan el objeto Domain Persona
 * @author PC
 */
@Local // Tipo de llamada local al EJB
public interface PersonaServiceLocal {
    public List<Persona> listarPersona();
    public Persona encontrarPersonaPorId(Persona persona);
    public Persona encontrarPersonaPorEmail(Persona persona);
    public void registrarPersona(Persona persona);
    public void modificarPersona(Persona persona);
    public void eliminarPersona(Persona persona);
}
