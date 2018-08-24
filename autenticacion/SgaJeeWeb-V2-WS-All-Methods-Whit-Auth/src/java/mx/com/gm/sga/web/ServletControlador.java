/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceLocal;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author PC
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ListarPersonas"})
public class ServletControlador extends HttpServlet {

    private static final long serialVersionUID = 1L;
    static Logger log = LogManager.getRootLogger();

    @EJB
    private PersonaServiceLocal personaServiceLocal;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        if(accion != null && accion.equals("editar"))
        {
            //1. recuperamos el idPersona seleccionado
            String idPersonaString = request.getParameter("idPersona");
            int idPersona = 0;
            if(idPersonaString != null)
            {
                //2. creamos el objeto persona a recuperar
                idPersona = Integer.parseInt(idPersonaString);
                Persona persona = new Persona(idPersona);
                persona = this.personaServiceLocal.encontrarPersonaPorId(persona);
                
                //3. compartimos el objeto persona en el alcance request
                request.setAttribute("persona", persona);
                
                //4. Redireccionamos a la pagina para editar el objeto
                request.getRequestDispatcher("editarPersona.jsp").forward(request, response);
            }
        }
        else
        {
            //la accion por default es listar
            //5. listamos las personas
            this.listarPersonas(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if(accion != null && accion.equals("agregar"))
        {
            //1. recuperamos los parametros
            String nombre = request.getParameter("nombre");
            String apePaterno = request.getParameter("apePaterno");
            String apeMaterno = request.getParameter("apeMaterno");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");
            
            //2. creamos el objeto persona
            Persona persona = new Persona();
            persona.setNombre(nombre);
            persona.setApellidoPaterno(apePaterno);
            persona.setApellidoMaterno(apeMaterno);
            persona.setEmail(email);
            persona.setTelefono(telefono);
            
            
            
            try
            {
                //3. utilizamos la capa de servicios para agregar a la persona. si ya existe el email no deberia registrarse
                this.personaServiceLocal.registrarPersona(persona);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            
            //4. listamos las persona
            this.listarPersonas(request, response);
        }
        else if(accion != null && accion.equals("modificar"))
        {
            // dentro de la modificacion, se puede modificar o eliminar segun se haya seleccionado
            // verificamos si se presiono el boton guardar
            
            String botonGuardar = request.getParameter("guardar");
            String botonEliminar = request.getParameter("eliminar");
            
            if(botonGuardar != null)
            {
                //1. recuperamos los parametros
                String idPersonaString = request.getParameter("idPersona");
                String nombre = request.getParameter("nombre");
                String apePaterno = request.getParameter("apePaterno");
                String apeMaterno = request.getParameter("apeMaterno");
                String email = request.getParameter("email");
                String telefono = request.getParameter("telefono");
                
                //2. creamos el objeto Persona
                Persona persona = new Persona();
                int idPersona = Integer.parseInt(idPersonaString);
                persona.setIdPersona(idPersona);
                persona.setNombre(nombre);
                persona.setApellidoPaterno(apePaterno);
                persona.setApellidoMaterno(apeMaterno);
                persona.setEmail(email);
                persona.setTelefono(telefono);
                
                try
                {
                    
                    //3. utilizamos la capa de servicio para modificar a la persona
                    this.personaServiceLocal.modificarPersona(persona);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                //4. Listamos las personas
                this.listarPersonas(request, response);
            }
            else if(botonEliminar != null)
            {
                //1. recuperamos los valores
                String idPersonaString = request.getParameter("idPersona");
                String nombre = request.getParameter("nombre");
                String apePaterno = request.getParameter("apePaterno");
                String apeMaterno = request.getParameter("apeMaterno");
                String email = request.getParameter("email");
                String telefono = request.getParameter("telefono");
                
                //2. creamos el objeto persona
                int idPersona = Integer.parseInt(idPersonaString);
                
                Persona persona = new Persona();
                persona.setIdPersona(idPersona);
                persona.setNombre(nombre);
                persona.setApellidoPaterno(apePaterno);
                persona.setApellidoMaterno(apeMaterno);
                persona.setEmail(email);
                persona.setTelefono(telefono);
                
                try
                {
                    //3. eliminamos a la persona
                    this.personaServiceLocal.eliminarPersona(persona);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                //4. listamos personas
                this.listarPersonas(request, response);
            }
            else
            {
                //4. accion por default listamos las personas
                this.listarPersonas(request, response);
            }
        }
    }

    private void listarPersonas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        List<Persona> personas = personaServiceLocal.listarPersonas();
        request.setAttribute("personas", personas);
        request.getRequestDispatcher("listarpersonas.jsp").forward(request, response);
    }
}
