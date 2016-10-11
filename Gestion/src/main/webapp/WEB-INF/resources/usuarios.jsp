<%@page import="org.manolete.gestion.model.acceso.Usuario"%>
<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.List"%>
<% List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios"); %>
<html>
	<head>
		<title>Usuarios :: Listado JPA</title>
	</head>
<body>
	<h1>Usuarios - Listado JPA</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Password</th>
			<th>Correo</th>
			<th>Validado</th>
			<th>Modificado</th>
			<th>Por</th>
		</tr>
	<% for (Usuario usuario : usuarios) { %>
		<tr>
			<td><%= usuario.getId() %></td>
			<td><%= usuario.getPassword() %></td>
			<td><%= usuario.getCorreo() %></td>
			<td><%= usuario.isValidado() %></td>
			<td><%= usuario.getModificado() %></td>
			<td><%= usuario.getModificado_por() %></td>
		</tr>
	<% } %>

		
	</table>
</body>
</html>