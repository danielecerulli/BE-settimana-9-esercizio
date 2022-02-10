<%@page import="it.entity.Calciatore"%>
<%@page import="java.util.List"%>
<%@page import="it.entity.Squadra"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiunta calciatore alla squadra</title>
</head>
<body>
		<%List<Calciatore> calciatoriSenzaSquadra = (List<Calciatore>)request.getAttribute("calciatoriSenzaSquadra"); %>
		<%Squadra squadra = (Squadra)request.getAttribute("squadra"); %>
		<h1>Aggiunta Calciatore alla Squadra <%=squadra.getNomeSquadra() %></h1><br><br>
		<a href="/ProgettoCalcetto">Torna alla Home</a><br><br>
			
			<form action="/ProgettoCalcetto/gestione/squadra/aggiungicalciatore">
				Scegli il calciatore: <select name="id_calciatore">
										<%for (Calciatore c : calciatoriSenzaSquadra) {   %>
											       
													<option value="<%=c.getIdCalciatore() %>"> <%=c.getNome() %> | <%=c.getCognome() %> | <%=c.getRuolo() %>	</option>
													
										<% }%>
										
									  </select><br><br>
									  <input type="hidden" value="<%=squadra.getIdSquadra()%>" name="id_squadra">
									  <input type="submit" value="Invia">
								
			</form>
</body>
</html>