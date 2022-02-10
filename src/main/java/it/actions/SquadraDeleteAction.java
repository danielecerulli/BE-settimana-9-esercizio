package it.actions;

import java.io.IOException;

import it.business.GestioneSquadraEjb;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SquadraDeleteAction implements IServletActions {

	@Override
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneSquadraEjb gse)
			throws ServletException, IOException {
		gse.eliminaSquadra(request.getParameter("id_squadra"));
		new SquadreMostraTutteAction().esegui(request, response, gse);

	}

}
