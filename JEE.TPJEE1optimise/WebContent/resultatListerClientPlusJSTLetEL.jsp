<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>résultat Lister les Clients JSTL</title>
</head>
<body>
	<p>
		nous s&ocirc;mmes le&nbsp;<span><%=new Date()%></span>
	</p>
	<c:if test="${!empty col}">
		<table>
			<tr>
				<th>id</th>
				<th>nom</th>
				<th>prenom</th>
				<th>couleur des yeux</th>
				<th>age</th>
			</tr>
			<c:forEach var="c" items="${col}">
				<tr>
					<td><c:out value="${c.id}"></c:out></td>
					<td><c:out value="${c.nom}"></c:out></td>
					<td><c:out value="${c.prenom}"></c:out></td>
					<td><c:out value="${c.couleurYeux}"></c:out></td>
					<td><c:out value="${c.age}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>