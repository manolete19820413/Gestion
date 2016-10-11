<%@page import="org.manolete.gestion.model.acceso.Perfil"%>
<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.List"%>
<% List<Perfil> perfiles = (List<Perfil>) request.getAttribute("perfiles"); %>
<html>
	<head>
		<title>Perfiles :: Listado JPA</title>
	</head>
<body>
	<h1>Perfiles - Listado JPA</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Modificado</th>
			<th>Por</th>
		</tr>
	<% for (Perfil perfil : perfiles) { %>
		<tr>
			<td><%= perfil.getId() %></td>
			<td><%= perfil.getNombre() %></td>
			<td><%= perfil.getModificado() %></td>
			<td><%= perfil.getModificado_por().getId() %></td>
		</tr>
	<% } %>

		
	</table>
</body>
</html>