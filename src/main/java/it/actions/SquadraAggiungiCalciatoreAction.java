package it.actions;

import java.io.IOException;

import org.apache.commons.cli.MissingArgumentException;

import it.business.GestioneSquadraEjb;
import it.entity.Calciatore;
import it.entity.Squadra;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SquadraAggiungiCalciatoreAction implements IServletActions {
	
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneSquadraEjb gse) 
			throws ServletException, IOException {
		
		String idSquadra = request.getParameter("id_squadra");
		String idCalciatore = request.getParameter("id_calciatore");
		
		try {
			gse.aggiungiCalciatoreAllaSquadra(idCalciatore, idSquadra);
		} catch (MissingArgumentException e) {
			
			e.printStackTrace();
		}
		
		new SquadreMostraTutteAction().esegui(request, response, gse);
		
		}
		
}
		
		



