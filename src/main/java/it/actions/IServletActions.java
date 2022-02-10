package it.actions;

import java.io.IOException;

import it.business.GestioneSquadraEjb;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IServletActions {
	
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneSquadraEjb gse) 
			throws ServletException, IOException;

}
