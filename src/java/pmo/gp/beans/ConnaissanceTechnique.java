package pmo.gp.beans;

import java.util.HashSet;
import java.util.Set;

/**
 * @author oualid
 * @version 1.0
 * @created 21-mai-2015 19:35:47
 */
public class  ConnaissanceTechnique {

	private int idct;
	private String libelle;
	private Set<ChefProjet> chefsprojet;

	public  ConnaissanceTechnique(){
		chefsprojet=new HashSet<ChefProjet>();
	}
	
	public int getIdct() {
		return idct;
	}

	public void setIdct(int idct) {
		this.idct = idct;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<ChefProjet> getChefsprojet() {
		return chefsprojet;
	}

	public void setChefsprojet(Set<ChefProjet> chefsprojet) {
		this.chefsprojet = chefsprojet;
	}
	

	

}