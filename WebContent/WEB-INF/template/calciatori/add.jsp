<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiunta calciatore</title>
</head>
<body>
	<h2>Inserisci dati calciatore</h2>
	<form method="POST" action="/ProgettoCalcetto/gestione/calciatore/inserisci">
		Nome Calciatore:<input type="text" name="nomeC" placeholder="Mario"><br><br>
		Cognome Calciatore:<input type="text" name="cognome" placeholder="Rossi"><br><br>
		Ruolo Calciatore:<input type="text" name="ruolo" placeholder="Attaccante"><br><br>
	<input type="submit" value="Invia">
	</form><br><br>
	<a href="/ProgettoCalcetto">Torna alla Home</a><br><br>
	<a href="/ProgettoCalcetto/gestione/calciatore/mostratutti">Torna alla Lista Calciatori</a><br><br><br>

</body>
</html>