package pmo.gp.beans;

import java.util.HashSet;
import java.util.Set;

public class Role {
	
	private int id;
	private String libelle;
	private Set<Utilisateur> utilisateurs;
	
	public Role() {
		utilisateurs=new HashSet<Utilisateur>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	 
	

}
