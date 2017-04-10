
<%@page import="java.util.Date,java.util.Collection,metier.Client"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">-->
<!DOCTYPE html>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>résultat Lister les Clients</title>
</head>
<body>
	<p>
		nous s&ocirc;mmes le&nbsp;<span><%=new Date()%></span></p>
	<p>
	<table>
		<tr>
			<th>id</th>
			<th>nom</th>
			<th>prenom</th>
			<th>couleur des yeux</th>
			<th>age</th>
		</tr>
		<%
			Collection<Client> col = ((Collection<Client>) request.getAttribute("col"));
			for (Client cli : col) {
		%><tr>
			<td><%=cli.getId()%></td>
			<td><%=cli.getNom()%></td>
			<td><%=cli.getPrenom()%></td>
			<td><%=cli.getCouleurYeux()%></td>
			<td><%=cli.getAge()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>