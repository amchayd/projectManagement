package pmo.gp.beans;

import java.util.*;

/**
 * @author oualid
 * @version 1.0
 * @created 21-mai-2015 19:35:50
 */
public class Probleme {

	private int id;
	private String libelle;
	private String description;
	public Etape etapes;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public void setEtapes(Etape etapes) {
        this.etapes = etapes;
    }

    public Etape getEtapes() {
        return etapes;
    }

	


}