package it.actions;

import java.io.IOException;

import it.business.GestioneSquadraEjb;
import it.entity.Calciatore;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CalciatoreInserisciAction implements IServletActions {
	
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneSquadraEjb gse) 
			throws ServletException, IOException {
		String nomeC = request.getParameter("nomeC");
		String cognomeC = request.getParameter("cognome");
		
		if (!capitalCheck(nomeC) || !capitalCheck(cognomeC)) {
			response.getWriter().append("<h2 style='background: red; padding: 10px'>CAPRA!!! METTI LE MAIUSCOLE</h2>");
			return;
		}
		
		String ruolo = request.getParameter("ruolo");
		gse.inserisciCalciatore(nomeC, cognomeC, ruolo);
		System.out.println("Hai aggiunto calciatore: " + nomeC + " " + cognomeC);
		new CalciatoriMostraTuttiAction().esegui(request, response, gse);
	}
	
	private boolean capitalCheck(String nomeC) {
		if (!Character.isUpperCase(nomeC.charAt(0))) {
			return false;
		}
		return true;
	}

}
