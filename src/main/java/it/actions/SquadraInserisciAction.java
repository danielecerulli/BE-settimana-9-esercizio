package it.actions;

import java.io.IOException;

import it.business.GestioneSquadraEjb;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SquadraInserisciAction implements IServletActions {

	@Override
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneSquadraEjb gse)
			throws ServletException, IOException {
		String nome = request.getParameter("nomeS");
		String citta = request.getParameter("citta");
		
		if (!capitalCheck(nome) || !capitalCheck(citta)) {
			response.getWriter().append("<h2 style='background: red; padding: 10px'>CAPRA!!! METTI LE MAIUSCOLE</h2>");
			return;
		}
		
		gse.inserisciSquadra(nome, citta);
		System.out.println("Hai aggiuntosquadra: " + nome + " " + citta);
		new SquadreMostraTutteAction().esegui(request, response, gse);
	}
	
	private boolean capitalCheck(String nomeC) {
		if (!Character.isUpperCase(nomeC.charAt(0))) {
			return false;
		}
		return true;
	
	}
		

}
	
	


