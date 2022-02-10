<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiunta squadra</title>
</head>
<body>
	<h2>Inserisci dati squadra</h2>
	<form method="POST" action="/ProgettoCalcetto/gestione/squadra/inserisci">
		Nome Squadra:<input type="text" name="nomeS"><br><br>
		Città Squadra:<input type="text" name="citta"><br><br>
	<input type="submit" value="Invia">
	</form><br><br>
	<a href="/ProgettoCalcetto">Torna alla Home</a><br><br>
	<a href="http://localhost:8080/ProgettoCalcetto/gestione/squadra/mostratutti">Torna alla lista Squadre</a><br><br>

</body>
</html>