<%@page import="org.manolete.gestion.model.aplicaciones.Aplicacion"%>
<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.List"%>
<% List<Aplicacion> aplicaciones = (List<Aplicacion>) request.getAttribute("aplicaciones"); %>
<html>
	<head>
		<title>Aplicaciones :: Listado JPA</title>
	</head>
<body>
	<h1>Aplicaciones - Listado JPA</h1>
	<table>
		<tr>
			<th>Código</th>
			<th>Nombre</th>
			<th>Modificado</th>
			<th>Por</th>
		</tr>
	<% for (Aplicacion aplicacion : aplicaciones) { %>
		<tr>
			<td><%= aplicacion.getCodigo() %></td>
			<td><%= aplicacion.getNombre() %></td>
			<td><%= aplicacion.getModificado() %></td>
			<td><%= aplicacion.getModificado_por().getId() %></td>
		</tr>
	<% } %>

		
	</table>
</body>
</html>