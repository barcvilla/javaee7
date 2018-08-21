<%-- 
    Document   : listarpersonas
    Created on : 20/08/2018, 20:26:22
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Personas</title>
    </head>
    <body>
        <h1>Listado de Personas</h1>
        <a href="agregarPersona.jsp">Agregar Persona</a>
        <br/><br/>
        <table border="1">
            <tr>
                <th>Nombre</th>
                <th>Apellido Paterno</th>
                <th>Apellido Matenro</th>
                <th>Email</th>
                <th>Telefono</th>
            </tr>
            <c:forEach var="persona" items="${personas}">
                <tr>
                    <td>
                        <a href="ListarPersonas?accion=editar&idPersona=${persona.idPersona}">${persona.nombre}</a>
                    </td>
                    <td>${persona.apellidoPaterno}</td>
                    <td>${persona.apellidoMaterno}</td>
                    <td>${persona.email}</td>
                    <td>${persona.telefono}</td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
