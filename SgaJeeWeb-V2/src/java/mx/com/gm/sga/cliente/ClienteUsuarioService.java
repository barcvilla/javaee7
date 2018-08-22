/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.servicio.UsuarioServiceRemote;

/**
 *
 * @author PC
 */
public class ClienteUsuarioService {
    public static void main(String[] args) {
        System.out.println("Iniciando la llamada al EJB desde el cliente\n");
        try
        {
            Context jndi = new InitialContext();
            UsuarioServiceRemote usuarioService = (UsuarioServiceRemote)jndi.lookup("java:global/sga-jee/UsuarioServiceImpl!mx.com.gm.sga.servicio.UsuarioServiceRemote");
            List<Usuario> usuarios = usuarioService.listarUsuarios();
            for(Usuario usuario : usuarios)
            {
                System.out.println(usuario);
            }
            System.out.println("\nFin de la llamada al EJB desde el cliente");
        }
        catch(NamingException ex)
        {
            ex.printStackTrace(System.out);
        }
    }
}
