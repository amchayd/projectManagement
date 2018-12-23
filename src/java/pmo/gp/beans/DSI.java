package pmo.gp.beans;

import java.util.HashSet;
import java.util.Set;



/**
 * @author oualid
 * @version 1.0
 * @created 21-mai-2015 19:35:31
 */
public class DSI extends Utilisateur {
	public Set<Projet> projets;

	public DSI(){
		projets=new HashSet<Projet>();
	}
	public Set<Projet> getProjets() {
		return projets;
	}

	public void setProjets(Set<Projet> projets) {
		this.projets = projets;
	}

	

}