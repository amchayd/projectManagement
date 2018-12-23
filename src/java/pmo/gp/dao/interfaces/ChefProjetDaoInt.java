package pmo.gp.dao.interfaces;

import java.util.*;

import pmo.gp.beans.*;

public interface ChefProjetDaoInt {
    public int DetaillerProjet(Projet p);
    public List<Projet> MesProjetsEnCours(int id);
    public List<Projet> MesProjetsTermines(int id);
    public List<Projet> NouveauxProjets(int id);
    public void DetaillerCompteRendu(CompteRendu cr);
    public void CommenterCompteRendu();
    public HashMap<String,Integer> getStatistique(int id);
    public long countNvProjet(int id);
    public void ajoutertache(Etape ep);
    public void modifierReunion(Reunion r);
    public int SaveModifProjet(Projet p);
    public void changerPourcentage(String cod,String mat,String op); 
}
