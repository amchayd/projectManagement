package pmo.gp.beans;

import java.util.*;

/**
 * @author oualid
 * @version 1.0
 * @created 21-mai-2015 19:35:22
 */
public class Reunion {

        private int idreunion;
	private Date datereunion;
	private String ordre;
	private String endroit;
	private CompteRendu compterendu;
	private Projet projet;
	

	public Reunion(){
	}

	public Date getDatereunion() {
		return datereunion;
	}

	public void setDatereunion(Date datereunion) {
		this.datereunion = datereunion;
	}

	public String getOrdre() {
		return ordre;
	}

	public void setOrdre(String ordre) {
		this.ordre = ordre;
	}

	public String getEndroit() {
		return endroit;
	}

	public void setEndroit(String endroit) {
		this.endroit = endroit;
	}

	public CompteRendu getCompterendu() {
		return compterendu;
	}

	public void setCompterendu(CompteRendu compterendu) {
		this.compterendu = compterendu;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

    public int getIdreunion() {
        return idreunion;
    }

    public void setIdreunion(int idreunion) {
        this.idreunion = idreunion;
    }
	


}