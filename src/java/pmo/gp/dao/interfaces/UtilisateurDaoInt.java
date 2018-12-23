package pmo.gp.dao.interfaces;

import pmo.gp.beans.*;
import java.util.*;

public interface UtilisateurDaoInt {
    public Utilisateur Authentifier(String username,String password);
    public List<ChefProjet> listerChefs();
    public List<Direction> Directions();
    public String getChefById(int id);
    public String getDirectionById(int id);
    public Projet getProjetByMatricule(String matricule);
    public List<Etape> getTaches(String matricule);
    public int getPourcentageProjet(String matricule,List<Etape> list);
    public HashMap<String,Integer> statistique();
    public List<Reunion> getlistReunionschef(int chef);
    public boolean isDetailled(String matri);
}
