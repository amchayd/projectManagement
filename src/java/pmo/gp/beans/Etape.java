package pmo.gp.beans;

import java.util.*;

/**
 * @author oualid
 * @version 1.0
 * @created 21-mai-2015 19:35:28
 */
public class Etape {

	private String code;
	private String description;
	private Date datedebut;
	private Date datefin;
	private int duree;
	private String niveau;
	private String prochaineetape;
	private int pourcentage;
	private Projet projet;
	private Set<Probleme> problemes;

	public Etape(){
		problemes=new HashSet<Probleme>();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getProchaineetape() {
		return prochaineetape;
	}

	public void setProchaineetape(String prochaineetape) {
		this.prochaineetape = prochaineetape;
	}

	public int getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Set<Probleme> getProblemes() {
		return problemes;
	}

	public void setProblemes(Set<Probleme> problemes) {
		this.problemes = problemes;
	}
	
     
}