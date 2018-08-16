/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Remote;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author PC
 */
@Remote
public interface UsuarioServiceRemote {
    public List<Usuario> listarUsuarios();
    public Usuario encontrarUsuarioPorId(Usuario usuario);
    public void registrarUsuario(Usuario usuario);
    public void modificarUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
}
