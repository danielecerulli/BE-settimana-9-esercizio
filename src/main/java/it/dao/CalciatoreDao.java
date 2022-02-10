package it.dao;

import java.util.List;

import org.apache.commons.cli.MissingArgumentException;

import it.entity.Calciatore;
import it.entity.Squadra;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;

public class CalciatoreDao implements ICalciatoreDao {
	
	private EntityManager em;
	
	public CalciatoreDao(EntityManager em) {
		this.em = em;
	}

	@Override
	public Calciatore inserisci(Calciatore c) {
		em.persist(c);
		return c;
	}

	@Override
	public List<Calciatore> getAll() {
		Query q = em.createNamedQuery("get.all.calciatori");
		List<Calciatore> listaCalciatori = q.getResultList();
		return listaCalciatori;
	}

	@Override
	public Calciatore getByPrimaryKey(int id) {	
		Calciatore c = em.find(Calciatore.class, id);
		if ( c == null)
			throw new EntityNotFoundException("Non è stato trovato il calciatore con id: " + id);
		return c;
	}
	
	@Override
	public Calciatore getByPrimaryKey(String id) throws MissingArgumentException {	
		if ( id == null || id.isBlank() ) {
			throw new MissingArgumentException("Id Calciatore mancante!");
		}
		
		return getByPrimaryKey(Integer.parseInt(id));
	}

	@Override
	public void update(Calciatore c) {
		em.merge(c);	
	}

	@Override
	public void delete(Calciatore c) {
		em.remove(em.find(Calciatore.class, c.getIdCalciatore()));
		
	}
	
	public void delete(int id) {
		em.remove(em.find(Calciatore.class, id));
		
	}

	@Override
	public List<Calciatore> getCalciatoreBySquadra(String nomeSq) {
		Query sql = em.createQuery("SELECT c FROM Calciatore c JOIN c.squadra WHERE c.squadra.nomeSquadra "
				+ "LIKE '%" + nomeSq + "%'");
		List<Calciatore> listaCalcSq = sql.getResultList();		
		return listaCalcSq;
	}

	@Override
	public void calciatoreAggiungiSquadra(Squadra s, Calciatore c) {		
		    	s = em.find(Squadra.class, s.getIdSquadra());
		    	c = em.find(Calciatore.class, c.getIdCalciatore());
		    	s.getCalciatori().add(c);
		    	c.setSquadra(s);
		    	em.merge(s);  	
	}
		

}
	
