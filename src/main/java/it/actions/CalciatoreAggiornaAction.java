package it.actions;

import java.io.IOException;
import java.io.PrintWriter;

import it.business.GestioneSquadraEjb;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CalciatoreAggiornaAction implements IServletActions {

	@Override
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneSquadraEjb gse)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("idCalciatore");
		String nome = request.getParameter("nome");
		String cogn = request.getParameter("cognome");
		String ruolo = request.getParameter("ruolo");
		
		
		gse.aggiornaCalciatore(id, nome, cogn, ruolo);
		//out.println("<h3>Calciatore aggiornato!</h3>");
		new CalciatoriMostraTuttiAction().esegui(request, response, gse);
		
		
	}

}
