package it.actions;

public class ServletActionsFactory {
	
	
	private ServletActionsFactory() {}
	
	private final static ServletActionsFactory servletActionsFactory = new ServletActionsFactory();
		
	
	public static ServletActionsFactory getInstance() {
		return servletActionsFactory;
	}


	public IServletActions create(String action) {
		
		switch(action) {
		
		case "/calciatore/inserisci":
			return new CalciatoreInserisciAction();
			
			
		case "/calciatore/aggiungisquadra":
			return new SquadraAggiungiCalciatoreAction();
			
			
		case "/calciatore/delete":
			return new CalciatoreDeleteAction();
			
			
		case "/calciatore/add":
			return new CalciatoreAddAction();
		
			
		case "/calciatore/mostratutti":
			return new CalciatoriMostraTuttiAction();
			
			
		case "/calciatore/aggiorna":
			return new CalciatoreAggiornaAction();
		
		case "/calciatore/edit":
			return new CalciatoreEditAction();
					
		case "/squadra/add":
			return new SquadraAddAction();
			
		case "/squadra/inserisci":
			return new SquadraInserisciAction();
			
		case "/squadra/aggiungicalciatore":
			return new SquadraAggiungiCalciatoreAction();
			
		case "/squadra/elimina":
			return new SquadraDeleteAction();
			
		case "/squadra/aggiorna":
			return new SquadraAggiornaAction();
			
		case "/squadra/edit":
			return new SquadraEditAction();
		
		case "/squadra/mostratutti":
			return new SquadreMostraTutteAction();
				
		case "/squadra/aggiungicalciatoreform":
			return new SquadraAggiungiCalciatoreFormAction();
			
		case "/squadra/mostrarosa":
			return new SquadraMostraRosaAction();
		
		}
		
		return new WrongAction();		
	
	}

}
