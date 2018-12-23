package pmo.gp.actions;

import java.util.HashSet;
import javax.faces.bean.*;
import org.hibernate.*;
import pmo.gp.beans.*;
import pmo.gp.dao.DSIDao;
import pmo.gp.dao.interfaces.DSIDaoInt;

@ManagedBean(name = "CreerProjetAction", eager = true)
@RequestScoped
public class CreerProjetAction {

	private String matricule;
	private String intitule;
	private int chefprojet;
        private int direction;
        private double budget;
        private String sponsor;


    /*
     creer projet   
     */    
    public String creerProjet()
    {
        Projet p=new Projet();
        p.setMatricule(getMatricule());
        p.setIntitule(getIntitule());
        p.setBudget(getBudget());
        p.setSponsor(getSponsor());
        ChefProjet cp=new ChefProjet();
        cp.setId(getChefprojet());
        p.setChefprojet(cp);
        Direction d=new Direction();
        d.setId(getDirection());
        p.setDirectionresponsable(d);
        DSIDaoInt dsi=new DSIDao();
        dsi.CreerProjet(p);
        String result="allprojets";
        
    return result;
    }
    public String getMatricule() {
        return matricule;
    }

    public String getIntitule() {
        return intitule;
    }

    public int getChefprojet() {
        return chefprojet;
    }

    public int getDirection() {
        return direction;
    }

    public double getBudget() {
        return budget;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setChefprojet(int chefprojet) {
        this.chefprojet = chefprojet;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }
    
    

    

	

}
