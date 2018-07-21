/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gsm.sga.eis;

import java.util.List;
import mx.com.gm.sga.domain.Persona;

/**
 *
 * @author PC
 */
public interface PersonaDao {
    public List<Persona> findAllPersonas();
    public Persona findPersonaById(Persona persona);
    public Persona findPersonaByEmail(Persona persona);
    public void insertPersona(Persona persona);
    public void updatePersona(Persona persona);
    public void deletePersona(Persona persona);
}
