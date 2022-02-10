package it.business;

import java.util.List;

import org.apache.commons.cli.MissingArgumentException;

import it.dao.CalciatoreDao;
import it.dao.ICalciatoreDao;
import it.dao.ISquadraDao;
import it.dao.SquadraDao;
import it.entity.Calciatore;
import it.entity.Squadra;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless
@LocalBean
public class GestioneSquadraEjb {
	
	@PersistenceContext(unitName = "calcettoPS")
	EntityManager em;
	
	private ICalciatoreDao calciatoreDao;
	private ISquadraDao squadraDao;
	
	
    
    public ICalciatoreDao getCalciatoreDao() {
    	if (calciatoreDao == null) { 
    		calciatoreDao = new CalciatoreDao(em);
    	}
		return calciatoreDao;
	}

	public ISquadraDao getSquadraDao() {
		if (squadraDao == null) {
			squadraDao = new SquadraDao(em);
		}
		return squadraDao;
	}

	public void setCalciatoreDao(ICalciatoreDao calciatoreDao) {
		this.calciatoreDao = calciatoreDao;
	}

	public void setSquadraDao(ISquadraDao squadraDao) {
		this.squadraDao = squadraDao;
	}

	public GestioneSquadraEjb() {
        
    }
	
	public void aggiornaCalciatore(Calciatore c) {
		getCalciatoreDao().update(c);					
	}
	public void aggiornaCalciatore(String id, String nome, String cognome, String ruolo) {
		Calciatore c = new Calciatore();
		c.setIdCalciatore(Integer.parseInt(id));
		c.setNome(nome);
		c.setCognome(cognome);
		c.setRuolo(ruolo);
		aggiornaCalciatore(c);					
	}
	
	public void inserisciCalciatore(Calciatore c) {
		getCalciatoreDao().inserisci(c);
	}
	
	public void inserisciCalciatore(String nome, String cognome, String ruolo) {
		Calciatore c = new Calciatore();
		c.setNome(nome);
		c.setCognome(cognome);
		c.setRuolo(ruolo);
		inserisciCalciatore(c);
	}
	
	public void eliminaCalciatore(Calciatore c) {
		getCalciatoreDao().delete(c);
	}
	
	public void eliminaCalciatore(int id) {
		Calciatore c = new Calciatore();
		c.setIdCalciatore(id);
		eliminaCalciatore(c);
	}
	
	public void eliminaCalciatore(String id) {
		Calciatore c = new Calciatore();
		c.setIdCalciatore(Integer.parseInt(id));
		eliminaCalciatore(c);
	}
	
	public void inserisciSquadra(Squadra s) {
		getSquadraDao().inserisci(s);
	}
	
	public void inserisciSquadra(String nome, String citta) {
		Squadra s = new Squadra();
		s.setNomeSquadra(nome);
		s.setCittaSquadra(citta);
		inserisciSquadra(s);
	}
	
	public void aggiungiCalciatoreAllaSquadra(String nomeS, String nomeC, String cognomeC) {
		List<Squadra> listaSquadre = getSquadraDao().getAll();
		List<Calciatore> calciatori = getCalciatoreDao().getAll();
		for ( Squadra s : listaSquadre ) {
			if ( s.getNomeSquadra().equals(nomeS) ) {				
				for ( Calciatore c : calciatori ) {
					if (c.getNome().equals(nomeC) || c.getCognome().equals(cognomeC)) {
						s.getCalciatori().add(c);
						c.setSquadra(s);
						getSquadraDao().update(s);
					}
				
				}
					
			}
		
		}
	
	}
	
	public void eliminaSquadra(Squadra s) {
		getSquadraDao().delete(s);
	}
	
	public void eliminaSquadra(int id) {
		Squadra s = new Squadra();
		s.setIdSquadra(id);
		eliminaSquadra(s);
	}
	
	public void eliminaSquadra(String id) {
		Squadra s = new Squadra();
		s.setIdSquadra(Integer.parseInt(id));
		eliminaSquadra(s);
	}
	
	public void aggiungiCalciatoreAllaSquadra(Calciatore c, Squadra s) {
		getSquadraDao().squadraAggiungiCalciatore(s, c);
	}
	
	public void aggiungiCalciatoreAllaSquadra(String nomeC, String cognomeC, String ruolo, String nomeS, String citta) {	
		Calciatore c = new Calciatore();
		Squadra s = new Squadra();
		c.setNome(nomeC);
		c.setCognome(cognomeC);
		c.setRuolo(ruolo);
		s.setNomeSquadra(nomeS);
		s.setCittaSquadra(citta);		
		aggiungiCalciatoreAllaSquadra(c, s);
	}
	
	public Squadra trovaSquadraConId(Squadra s) {
		return getSquadraDao().getByPrimaryKey(s.getIdSquadra());
	}
	
	public Squadra trovaSquadraConId(int idS) {
		Squadra s = new Squadra();
		s.setIdSquadra(idS);
		return trovaSquadraConId(s);
	}

	public Squadra trovaSquadraConId(String idS) {
		Integer idSI = Integer.parseInt(idS);
		return trovaSquadraConId(idSI);
	}
	
	public List<Calciatore> trovaTuttiCalciatori() {
		return getCalciatoreDao().getAll();
	}
	
	public void aggiungiCalciatoreAllaSquadra(String idC, String idS) throws MissingArgumentException {
		Calciatore c = getCalciatoreDao().getByPrimaryKey(idC);
		Squadra s = getSquadraDao().getByPrimaryKey(Integer.parseInt(idS));
		aggiungiCalciatoreAllaSquadra(c, s);
	}

}
