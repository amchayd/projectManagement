package pmo.gp.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author oualid
 * @version 1.0
 * @created 21-mai-2015 19:35:25
 */
public class Projet {
	private String matricule;
	private String intitule;
	private Direction directionresponsable;
	private double budget;
	private String description;
	private Date datecreation;
	private Date prevudebut;
	private Date prevufin;
	private String sponsor;
	private String commenatairechefprojet;
	private boolean valide;
	private String priorite;
	public ChefProjet chefprojet;
	public Set<Document>documents;
	public Set<Reunion> reunions;
	public Set<Etape> etapes;

	public Projet(){
		documents=new HashSet<Document>();
		reunions=new HashSet<Reunion>();
		etapes=new HashSet<Etape>();
	               }

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Direction getDirectionresponsable() {
		return directionresponsable;
	}

	public void setDirectionresponsable(Direction directionresponsable) {
		this.directionresponsable = directionresponsable;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public Date getPrevudebut() {
		return prevudebut;
	}

	public void setPrevudebut(Date prevudebut) {
		this.prevudebut = prevudebut;
	}

	public Date getPrevufin() {
		return prevufin;
	}

	public void setPrevufin(Date prevufin) {
		this.prevufin = prevufin;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getCommenatairechefprojet() {
		return commenatairechefprojet;
	}

	public void setCommenatairechefprojet(String commenatairechefprojet) {
		this.commenatairechefprojet = commenatairechefprojet;
	}

	public boolean getValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public String getPriorite() {
		return priorite;
	}

	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}
	public ChefProjet getChefprojet() {
		return chefprojet;
	}

	public void setChefprojet(ChefProjet chefprojet) {
		this.chefprojet = chefprojet;
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	public Set<Reunion> getReunions() {
		return reunions;
	}

	public void setReunions(Set<Reunion> reunions) {
		this.reunions = reunions;
	}

	public Set<Etape> getEtapes() {
		return etapes;
	}

	public void setEtapes(Set<Etape> etapes) {
		this.etapes = etapes;
	}
	


}