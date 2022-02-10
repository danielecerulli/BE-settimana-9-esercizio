package it.actions;

import java.io.IOException;
import java.util.List;

import it.business.GestioneSquadraEjb;
import it.entity.Calciatore;
import it.entity.Squadra;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CalciatoriMostraTuttiAction implements IServletActions {

	@Override
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneSquadraEjb gse)
			throws ServletException, IOException {
		List<Calciatore> listaCalciatori = gse.getCalciatoreDao().getAll();		
		request.setAttribute("listaCalciatori", listaCalciatori);
		request.getServletContext().getRequestDispatcher("/WEB-INF/template/calciatori/mostratutti.jsp").include(request, response);
		

	}
	
}
