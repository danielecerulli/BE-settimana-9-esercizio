<%@page import="it.entity.Squadra"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco squadre</title>
</head>
<body>
		
		<h3>Lista Squadre</h3><br>
		<a href="/ProgettoCalcetto">Torna alla Home</a><br>
		<a href="/ProgettoCalcetto/gestione/squadra/add">Aggiungi un'altra squadra</a><br><br><br>
		<%List<Squadra> listaSquadre = (List<Squadra>)request.getAttribute("listaSquadre"); %>
		<div style="height: 400px; overflow: auto; border: 2px solid black; padding: 4px">
		<table>
		<tr>
			<th>Nome<th>Città<th>
			
		</tr>
		<% for ( Squadra s : listaSquadre ) { %> 
		<tr>
		<td> <%=s.getNomeSquadra() %>
		<td> <%=s.getCittaSquadra() %>
		<td> <a href="/ProgettoCalcetto/gestione/squadra/edit?id_squadra=<%=s.getIdSquadra() %>">Modifica</a> | 
			 <a href="/ProgettoCalcetto/gestione/squadra/delete?id_squadra=<%=s.getIdSquadra() %>">Elimina</a>|
			 <a href="/ProgettoCalcetto/gestione/squadra/aggiungicalciatoreform?id_squadra=<%=s.getIdSquadra() %>">Aggiungi Calciatore</a>|
			 <a href="/ProgettoCalcetto/gestione/squadra/mostrarosa?id_squadra=<%=s.getIdSquadra() %>">Mostra Rosa Squadra</a>|
		</tr>
		<%} %>
		
		</table>
		</div>
</body>
</html>