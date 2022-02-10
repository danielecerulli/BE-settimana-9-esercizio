<%@page import="it.entity.Squadra"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Squadra</title>
</head>
<body>
	<a href="#Elenco">Elenco</a><br><br>
	<a href="/ProgettoCalcetto">Torna alla Home</a><br><br>
	<%Squadra s = (Squadra)request.getAttribute("squadra"); %>
	
	<form method="POST" action="/ProgettoCalcetto/gestione/squadra/aggiorna">
		Nome Squadra:<input type="text" value="<%=s.getNomeSquadra()%>" name="nome"><br><br>
		Città Squadra:<input type="text" value="<%=s.getCittaSquadra()%>" name="citta"><br><br>
	<input type="hidden" value="<%=s.getIdSquadra()%>" name="idSquadra">
	<input type="submit" value="Modifica">
	</form><br><br>
	<a name="Elenco"></a>	
</body>
</html>