<%@page import="org.manolete.gestion.model.tickets.Ticket"%>
<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.List"%>
<% List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets"); %>
<html>
	<head>
		<title>Tickets :: Listado JPA</title>
	</head>
<body>
	<h1>Tickets - Listado JPA</h1>
	<table>
		<tr>
			<th>Usuario</th>
			<th>Correo</th>
			<th>Login</th>
		</tr>
	<% for (Ticket ticket : tickets) { %>
		<tr>
			<td><%= ticket.getId() %></td>
			<td><%= ticket.getUsuario().getCorreo() %></td>
			<td><%= ticket.getLogin() %></td>
		</tr>
	<% } %>

		
	</table>
</body>
</html>