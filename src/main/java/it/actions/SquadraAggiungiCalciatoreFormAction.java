package it.actions;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import it.business.GestioneSquadraEjb;
import it.entity.Calciatore;
import it.entity.Squadra;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SquadraAggiungiCalciatoreFormAction implements IServletActions {

	@Override
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneSquadraEjb gse)
			throws ServletException, IOException {
			Squadra squadra = gse.trovaSquadraConId(request.getParameter("id_squadra"));
			List<Calciatore> listaCalciatoriSenzaSquadra = gse.trovaTuttiCalciatori().stream().filter( c -> c.getSquadra() == null ).collect(Collectors.toList());
					request.setAttribute("calciatoriSenzaSquadra", listaCalciatoriSenzaSquadra);
					request.setAttribute("squadra", squadra);
			request.getServletContext().getRequestDispatcher("/WEB-INF/template/squadre/aggiungicalciatore.jsp").forward(request, response);

	}

}
