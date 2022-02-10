package it.actions;

import java.io.IOException;

import it.business.GestioneSquadraEjb;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CalciatoreDeleteAction implements IServletActions {

	@Override
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneSquadraEjb gse)
			throws ServletException, IOException {
		String idC = request.getParameter("id_calciatore");
		gse.eliminaCalciatore(idC);
		System.out.println("Calciatore eliminato dalla lista!");
		new CalciatoriMostraTuttiAction().esegui(request, response, gse);

	}

}
