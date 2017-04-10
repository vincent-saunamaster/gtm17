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
	<p>
		<!-- essai jstl openclassrom -->
		<!-- 4  scope (portée des varibles) = page, request, session, application -->
		<c:set var="exemple1" scope="page" value="valeur de l'exemple 1 !" />
		<c:set var="exemple2" scope="request">valeur de l'exemple 2 !</c:set>
		<c:set var="exemple3" scope="session">valeur de l'exemple 3 !</c:set>

		<c:out value="${exemple1}" default="texte si ${exemple1} est null" />
		<c:out value="${requestScope.exemple2}"
			default="texte si ${exemple2} est null" />
		<c:out value="${sessionScope.exemple3}">texte si ${exemple3} est null</c:out>

		<c:set var="exemple4" scope="application">
			<c:out value="${param.lang}" default="FR" />
		</c:set>






		<c:set target="${unObjet}" property="unAttributDeObjet">nouvelle valeur de la propriété de l'objet</c:set>
		<c:remove var="unObjet" scope="application" />

		<c:choose>
			<c:when test="${expression1}">Action ou texte.</c:when>
			<c:when test="${expression2}">Action ou texte.</c:when>
			<c:otherwise>Autre action ou texte.</c:otherwise>
		</c:choose>
		<!-- fin essai jstl -->
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
			<!-- <c:forEach var="i" begin="0" end="7" step="1"></c:forEach> -->
			<!-- avec i toujours inférieur ou égal à n, ici exécute 8 fois -->
			<c:forEach var="c" items="${col}">
				<!-- items est la syntaxe spécifique pour indiquer une collection -->
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