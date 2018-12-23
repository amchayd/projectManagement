package pmo.gp.dao.interfaces;

import pmo.gp.beans.*;
import java.util.*;

public interface DSIDaoInt {
    public void CreerProjet(Projet p);
    public List<Projet> ConsulterProjets(String critere,Object valeur);
    public void ValiderCompteRendu();
    public HashSet<CompteRendu> ConsulterCompteRendu();
    public void SaveModifProjetDSI(Projet p);
    public HashMap<String,Integer> getAllStatistique();
   
}
