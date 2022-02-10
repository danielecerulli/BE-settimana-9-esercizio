package it.actions;

import java.io.IOException;

import it.business.GestioneSquadraEjb;
import it.entity.Calciatore;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WrongAction implements IServletActions {
	
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneSquadraEjb gse) 
			throws ServletException, IOException {
		
		System.out.println("AZIONE NON CONTEMPLATA!");
	}

}
