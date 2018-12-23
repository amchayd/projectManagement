package pmo.gp.beans;

import java.util.HashSet;
import java.util.Set;

/**
 * @author oualid
 * @version 1.0
 * @created 21-mai-2015 19:35:44
 */
public class ChefProjet extends Utilisateur {

	private Set<CompteRendu>comptesrendus;
	private Set<ConnaissanceTechnique>connaissancestechniques;
	

	public ChefProjet(){
		comptesrendus=new HashSet<CompteRendu>();
		connaissancestechniques=new HashSet<ConnaissanceTechnique>();
	}
	public Set<CompteRendu> getComptesrendus() {
		return comptesrendus;
	}

	public void setComptesrendus(Set<CompteRendu> comptesrendus) {
		this.comptesrendus = comptesrendus;
	}

	public Set<ConnaissanceTechnique> getConnaissancestechniques() {
		return connaissancestechniques;
	}

	public void setConnaissancestechniques(
			Set<ConnaissanceTechnique> connaissancestechniques) {
		this.connaissancestechniques = connaissancestechniques;
	}
	


}