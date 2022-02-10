<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiunta calciatore alla squadra</title>
</head>
<body>
	<h2>Inserisci dati squadra e calciatore</h2>
	<form method="POST" action="/ProgettoCalcetto/gestione/squadra/aggiungicalciatore">
		Nome Squadra:<input type="text" name="nomeS"><br><br>
		Nome Calciatore:<input type="text" name="nomeC"><br><br>
		Cognome Calciatore:<input type="text" name="cognomeC"><br><br>
	<input type="submit" value="Invia">
	</form><br><br>
	<a href="/ProgettoCalcetto">Torna alla Home</a><br><br>
</body>
</html>