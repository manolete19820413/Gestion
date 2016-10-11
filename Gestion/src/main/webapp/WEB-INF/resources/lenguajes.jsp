<%@page import="org.manolete.gestion.model.contenido.Lenguaje"%>
<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.List"%>
<% List<Lenguaje> lenguajes = (List<Lenguaje>) request.getAttribute("lenguajes"); %>
<html>
	<head>
		<title>Lenguajes :: Listado JPA</title>
	</head>
<body>
	<h1>Lenguajes - Listado JPA</h1>
	<table>
		<tr>
			<th>Codigo</th>
			<th>Nombre</th>
			<th>Modificado</th>
			<th>Por</th>
		</tr>
	<% for (Lenguaje lenguaje : lenguajes) { %>
		<tr>
			<td><%= lenguaje.getCodigo() %></td>
			<td><%= lenguaje.getNombre() %></td>
			<td><%= lenguaje.getModificado() %></td>
			<td><%= lenguaje.getModificado_por().getId() %></td>
		</tr>
	<% } %>

		
	</table>
</body>
</html>