<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">-->
<!DOCTYPE html>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>résultat Modifier Client JSP</title>
</head>
<body>
	<p>
		nous s&ocirc;mmes le&nbsp;<span><%=new Date()%></span></p>
	<p>
		bonjour,&nbsp;<%=request.getAttribute("leprenom")%>
		<%=request.getAttribute("lenom")%></p>
		<p>
		l'id saisi est &nbsp;<%=request.getAttribute("lid")%></p>
	<p>
		la couleur des yeux saisie est &nbsp;<%=request.getAttribute("lacouleuryeux")%></p>
		<p>
		l'âge saisi est &nbsp;<%=request.getAttribute("lage")%></p>

</body>
</html>