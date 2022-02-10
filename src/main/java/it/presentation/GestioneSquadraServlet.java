package it.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import it.actions.SquadraAggiungiCalciatoreAction;
import it.actions.CalciatoreInserisciAction;
import it.actions.ServletActionsFactory;
import it.business.GestioneSquadraEjb;
import it.entity.Calciatore;
import it.entity.Squadra;

@WebServlet("/gestione/*")
public class GestioneSquadraServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	GestioneSquadraEjb gse;
       
   
    public GestioneSquadraServlet() {
        
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		ServletActionsFactory.getInstance().create(action).esegui(request, response, gse);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		ServletActionsFactory.getInstance().create(action).esegui(request, response, gse);
	
	}
	

}
