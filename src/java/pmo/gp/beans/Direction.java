package pmo.gp.beans;

import java.util.Set;

/**
 * @author oualid
 * @version 1.0
 * @created 21-mai-2015 19:35:38
 */
public class Direction {

	private int id;
	private String intitule;
	public Set<Projet> projets;

	public Direction(){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Set<Projet> getProjets() {
		return projets;
	}

	public void setProjets(Set<Projet> projets) {
		this.projets = projets;
	}
	


}