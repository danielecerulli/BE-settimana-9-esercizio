<%@page import="it.entity.Calciatore"%>
<%@page import="java.util.List"%>
<%@page import="it.entity.Squadra"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rosa dei giocatori</title>
</head>
<body>
	
	<%Squadra squadra = (Squadra)request.getAttribute("squadra"); %>
	<%List<Calciatore> listaCalciatoriSquadra = (List<Calciatore>)request.getAttribute("listaCalciatoriSquadra"); %>
	<h1>Rosa della Squadra: <%=squadra.getNomeSquadra() %></h1><br><br>
	<a href="/ProgettoCalcetto">Torna alla Home</a><br><br>
	<a href="http://localhost:8080/ProgettoCalcetto/gestione/squadra/mostratutti">Torna alla Lista Squadre</a><br><br>
		<table>
			<tr><th>ID Calciatore:<th>Nome:<th>Cognome:<th>Ruolo:</tr>
			<%for (Calciatore c : listaCalciatoriSquadra) {     %>
					<tr><td><%=c.getIdCalciatore() %>	
					<td><%=c.getNome() %>
					<td><%=c.getCognome() %>
					<td><%=c.getRuolo() %>
		<% } %>
		</table>
</body>
</html>