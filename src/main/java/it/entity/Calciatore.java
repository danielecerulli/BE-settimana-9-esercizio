package it.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@NamedQuery(name="get.all.calciatori", query="SELECT c FROM Calciatore c")
@Entity
@Table(name="calciatore")
public class Calciatore implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private int idCalciatore;
	private String nome;
	private String cognome;
	private String ruolo;
	private Squadra squadra;
	
	@Id
	@Column(name="id_calciatore")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdCalciatore() {
		return idCalciatore;
	}
	@Column(name="nome_calciatore", nullable = false)
	public String getNome() {
		return nome;
	}
	@Column(name="cognome_calciatore", nullable = false)
	public String getCognome() {
		return cognome;
	}
	@Column(name="ruolo")
	public String getRuolo() {
		return ruolo;
	}
	public void setIdCalciatore(int idCalciatore) {
		this.idCalciatore = idCalciatore;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="id_squadra")
	public Squadra getSquadra() {		
		return squadra;
	}
	
	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}
	
	public String controllaNoSquadra() {
		if (this.getSquadra() == null) {
		return "NO SQUADRA ASSEGNATA!";
		}
		else 
			return this.getSquadra().getNomeSquadra();
	}
	
}
