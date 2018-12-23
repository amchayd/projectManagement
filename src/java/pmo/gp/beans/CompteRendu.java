package pmo.gp.beans;

import java.util.*;
/**
 * @author oualid
 * @version 1.0
 * @created 21-mai-2015 19:35:41
 */
public class CompteRendu {

        private int idreunion;
	private Date datecreation;
	private String ordre;
	private ChefProjet chefprojet;
	private String commentairechefprojet;
	private boolean valide;
	private Reunion reunion;


	public CompteRendu(){


	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public String getOrdre() {
		return ordre;
	}

	public void setOrdre(String ordre) {
		this.ordre = ordre;
	}

	public ChefProjet getChefprojet() {
		return chefprojet;
	}

	public void setChefprojet(ChefProjet chefprojet) {
		this.chefprojet = chefprojet;
	}

	public String getCommentairechefprojet() {
		return commentairechefprojet;
	}

	public void setCommentairechefprojet(String commentairechefprojet) {
		this.commentairechefprojet = commentairechefprojet;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public Reunion getReunion() {
		return reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

    public void setIdreunion(int idreunion) {
        this.idreunion = idreunion;
    }

    public int getIdreunion() {
        return idreunion;
    }
        

   
	

}