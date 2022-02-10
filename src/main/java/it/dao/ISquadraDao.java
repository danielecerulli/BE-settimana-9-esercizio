package it.dao;

import java.util.List;

import it.entity.Calciatore;
import it.entity.Squadra;


public interface ISquadraDao {
	
	public Squadra inserisci(Squadra s);
	public List<Squadra> getAll();
	public Squadra getByPrimaryKey(int id);
	public void update(Squadra s);
	public void delete(Squadra s);
	public void squadraAggiungiCalciatore(Squadra s, Calciatore c);

}
