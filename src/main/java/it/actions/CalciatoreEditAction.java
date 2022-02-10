package it.actions;

import java.io.IOException;
import java.io.PrintWriter;


import it.business.GestioneSquadraEjb;
import it.entity.Calciatore;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CalciatoreEditAction implements IServletActions {

	@Override
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneSquadraEjb gse)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Calciatore c = gse.getCalciatoreDao().getByPrimaryKey(request.getParameter("id_calciatore"));
			request.setAttribute("calciatore", c);
			request.getServletContext().getRequestDispatcher("/WEB-INF/template/calciatori/edit.jsp").include(request, response);
			//request.getServletContext().getNamedDispatcher("/gestione/calciatore/mostratutti").forward(request, response);
			new CalciatoriMostraTuttiAction().esegui(request, response, gse);
		} catch (Exception e) {
			out.println("<h2>"+e.getMessage()+"</h2>");
			e.printStackTrace();
		}

	}

}
