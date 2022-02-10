package it.actions;

import java.io.IOException;
import java.io.PrintWriter;

import it.business.GestioneSquadraEjb;
import it.entity.Squadra;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SquadraEditAction implements IServletActions {

	@Override
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneSquadraEjb gse)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Squadra s = gse.getSquadraDao().getByPrimaryKey(Integer.parseInt(request.getParameter("id_squadra")));
			request.setAttribute("squadra", s);
			request.getServletContext().getRequestDispatcher("/WEB-INF/template/squadre/edit.jsp").include(request, response);
			//request.getServletContext().getNamedDispatcher("/gestione/calciatore/mostratutti").forward(request, response);
			new SquadreMostraTutteAction().esegui(request, response, gse);
		} catch (Exception e) {
			out.println("<h2>"+e.getMessage()+"</h2>");
			e.printStackTrace();
		}

	}

}
