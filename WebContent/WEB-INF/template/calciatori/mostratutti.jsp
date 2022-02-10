<%@page import="java.util.List"%>
<%@page import="it.entity.Calciatore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco calciatori</title>
</head>
<body>

		<h3>Lista Calciatori</h3><br>
		<a href="/ProgettoCalcetto">Torna alla Home</a><br>
		<a href="/ProgettoCalcetto/gestione/calciatore/add">Aggiungi un altro giocatore</a><br><br>		
		<%List<Calciatore> listaCalciatori = (List<Calciatore>)request.getAttribute("listaCalciatori"); %>
		<div style="height: 400px; overflow: auto; border: 2px solid black; padding: 4px">
		<table>
		<tr>
			<th>Nome<th>Cognome<th>Ruolo<th>ID<th>Squadra
			
		</tr>
		<% for ( Calciatore c : listaCalciatori ) { %> 
		<tr>		
		<td> <%=c.getNome() %>
		<td> <%=c.getCognome() %>
		<td> <%=c.getRuolo() %>
		<td> <%=c.getIdCalciatore() %>
		<td> <%=c.controllaNoSquadra() %>
		<td> <a href="/ProgettoCalcetto/gestione/calciatore/edit?id_calciatore=<%=c.getIdCalciatore() %>">Modifica</a> | 
			 <a href="/ProgettoCalcetto/gestione/calciatore/delete?id_calciatore=<%=c.getIdCalciatore() %>">Elimina</a>
		</tr>
		<%} %>
		
		</table>
		</div>
</body>
</html>