package it.actions;

import java.io.IOException;
import java.util.List;

import it.business.GestioneSquadraEjb;
import it.entity.Calciatore;
import it.entity.Squadra;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SquadraMostraRosaAction implements IServletActions {

	@Override
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneSquadraEjb gse)
			throws ServletException, IOException {
			
		String idS = request.getParameter("id_squadra");
			Squadra squadra = gse.trovaSquadraConId(idS);
			List<Calciatore> listaCalciatoriSquadra = squadra.getCalciatori();
			request.setAttribute("squadra", squadra);
			request.setAttribute("listaCalciatoriSquadra", listaCalciatoriSquadra);
			request.getServletContext().getRequestDispatcher("/WEB-INF/template/squadre/mostrarosa.jsp").include(request, response);
			
	}

}
