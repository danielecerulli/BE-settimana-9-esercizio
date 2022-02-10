<%@page import="it.entity.Calciatore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Calciatore</title>
</head>
<body>
	<a href="#Elenco">Elenco</a><br><br>
	<%Calciatore c = (Calciatore)request.getAttribute("calciatore"); %>
	<a href="/ProgettoCalcetto">Torna alla Home</a><br><br>
	<form method="POST" action="/ProgettoCalcetto/gestione/calciatore/aggiorna">
		Nome Calciatore:<input type="text" value="<%=c.getNome()%>" name="nome"><br><br>
		Cognome Calciatore:<input type="text" value="<%=c.getCognome()%>" name="cognome"><br><br>
		Ruolo Calciatore:<input type="text" value="<%=c.getRuolo()%>" name="ruolo"><br><br>
	<input type="hidden" value="<%=c.getIdCalciatore()%>" name="idCalciatore">
	<input type="submit" value="Modifica">
	</form><br><br>
	<a name="Elenco"></a>	
</body>
</html>