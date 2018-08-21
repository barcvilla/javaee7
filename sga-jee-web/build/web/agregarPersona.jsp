<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Agregar Persona</title>
</head>
<body>

	<h1>Agregar Persona</h1>
	
	<form action="ListarPersonas" method="post">
		<input type="hidden" name="accion" value="agregar"/>
	
		<label for="nombre">Nombre:</label>
		<input type="text" name="nombre" style="display: block;" />
		
		<label for="apePaterno">Apellido Paterno:</label>
		<input type="text" name="apePaterno" style="display: block;"/>
                
                <label for="apeMaterno">Apellido Materno:</label>
		<input type="text" name="apeMaterno" style="display: block;"/>
		
		<label for="email">eMail:</label>
		<input type="text" name="email" style="display: block;"/>
		
		<label for="telefono">Teléfono:</label>
		<input type="text" name="telefono" style="display: block;"/>
		
		<input type="submit" value="Enviar" />
	</form>

	<a href="index.jsp">Regresar al Inicio</a>
</body>
</html>
