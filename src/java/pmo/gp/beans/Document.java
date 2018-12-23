package pmo.gp.beans;

/**
 * @author oualid
 * @version 1.0
 * @created 21-mai-2015 19:35:35
 */
public class Document {

	private String nom;
	private String type;
	private Projet projet;

	public Document(){

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
    

}