package it.actions;

import java.io.IOException;
import java.util.List;

import it.business.GestioneSquadraEjb;
import it.entity.Squadra;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SquadreMostraTutteAction implements IServletActions {

	@Override
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneSquadraEjb gse)
			throws ServletException, IOException {
List<Squadra> listaSquadre = gse.getSquadraDao().getAll();
		
		request.setAttribute("listaSquadre", listaSquadre);
		request.getServletContext().getRequestDispatcher("/WEB-INF/template/squadre/mostratutti.jsp").include(request, response);

	}

}
