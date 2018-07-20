/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.HolaMundoEJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author PC
 */
public class HolaMundoEJBTest {
    private static EJBContainer contenedor;
    private static Context contexto;
    private static HolaMundoEJB ejb; //llamamos la clase ejb bean
    
    @Before//metodo que se ejecuta antes de la prueba unitaria
    public void iniciarContendor()throws Exception {
        System.out.println("Iniciando EJB Container");
        contenedor = EJBContainer.createEJBContainer();
        contexto = contenedor.getContext();
        ejb = (HolaMundoEJB) contexto.lookup("java:global/classes/HolaMundoEJB!beans.HolaMundoEJB");
    }
    
    //Prueba unitaria
    @Test
    public void testAddNumbers() throws Exception
    {
        int dato1 = 3;
        int dato2 = 5;
        int resultado = ejb.sumar(dato1, dato2);
        assertEquals((dato1+dato2), resultado);
        System.out.println("\nOperacion terminada, resultado: " + resultado + "\n");
    }
}
