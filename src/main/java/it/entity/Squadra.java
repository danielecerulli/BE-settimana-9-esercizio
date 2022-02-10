package it.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@NamedQuery(name = "get.all.squadre" , query="SELECT s FROM Squadra s")
@Entity
@Table(name="squadra")
public class Squadra implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private int idSquadra;
	private String nomeSquadra;
	private String cittaSquadra;
	private List<Calciatore> calciatori;
	
	
	@Id
	@Column(name="id_squadra")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdSquadra() {
		return idSquadra;
	}
	@Column(name="nome_squadra")
	public String getNomeSquadra() {
		if ( nomeSquadra.equals("") || nomeSquadra.isBlank() ) {
			nomeSquadra = "NO SQUADRA ASSEGNATA!";
		}
		return nomeSquadra;
	}
	@Column(name="citta")
	public String getCittaSquadra() {
		return cittaSquadra;
	}
	public void setIdSquadra(int idSquadra) {
		this.idSquadra = idSquadra;
	}
	public void setNomeSquadra(String nomeSquadra) {
		this.nomeSquadra = nomeSquadra;
	}
	public void setCittaSquadra(String cittaSquadra) {
		this.cittaSquadra = cittaSquadra;
	}
	@OneToMany(mappedBy = "squadra", cascade = CascadeType.ALL)
	public List<Calciatore> getCalciatori() {
		if (calciatori == null)
			calciatori = new ArrayList<Calciatore>();
		return calciatori;
	}
	public void setCalciatori(List<Calciatore> calciatori) {
		this.calciatori = calciatori;
	}
	
	

}
