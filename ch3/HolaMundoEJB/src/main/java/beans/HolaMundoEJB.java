/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;

/**
 * Objeto EJB que se desplegara en un contenedor ejb embebido
 * @author PC
 */
@Stateless
public class HolaMundoEJB {
    public int sumar(int a, int b)
    {
        return a + b;
    }
}
