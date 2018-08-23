/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclientews;

import clientews.servicio.ServicioSumarImplService;
import clientews.servicio.ServicioSumarWS;

/**
 *
 * @author PC
 */
public class TestServicioSumarWS 
{    
    public static void main(String[] args) {
        ServicioSumarWS servicoSumar = new ServicioSumarImplService().getServicioSumarImplPort();
        System.out.println("Ejecutando Servicio Sumar WS");
        int x = 1;
        int y = 2;
        
        System.out.println("Sumar: " + "x: " + x + " y: " + y);
        System.out.println("Resultado: " + servicoSumar.sumar(x, y));
        System.out.println("Fin del Servicio Sumar WS");
    }
    
}
