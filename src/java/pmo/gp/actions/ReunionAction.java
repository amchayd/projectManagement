/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pmo.gp.actions;

import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pmo.gp.beans.Projet;
import pmo.gp.beans.Reunion;
import pmo.gp.dao.ChefProjetDao;
import pmo.gp.dao.UtilisateurDao;
import pmo.gp.dao.interfaces.ChefProjetDaoInt;
import pmo.gp.dao.interfaces.UtilisateurDaoInt;

/**
 *
 * @author oualid
 */
@ManagedBean(name = "ReunAction", eager = true)
@SessionScoped
public class ReunionAction {
    
    private List<Reunion> listreunions;
    private int idchef;
    private Reunion selectedReunion;
       @PostConstruct
    public void init() {

        listreunions= getlistreunionbyMatricule(this.idchef); 
    }
    /*LIST REUNION*/
    public String getReunions()
    {
        listreunions=getlistreunionbyMatricule(SessionTools.getUserid());
    return "reunions";
    }
    public List<Reunion> getlistreunionbyMatricule(int idchef)
    {
        UtilisateurDaoInt user=new UtilisateurDao();  
    return  user.getlistReunionschef(idchef); 
    }
    public List<Reunion> getListreunions() {
        return listreunions;
    }
    
    /*MODIFIER REUNION*/
    public void ModifierReunion()
    {
        ChefProjetDaoInt cp=new ChefProjetDao();
        cp.modifierReunion(selectedReunion);
       // return "resunions";
    }
    public void setListreunions(List<Reunion> listreunions) {
        this.listreunions = listreunions;
    }

    public int getIdchef() {
        return idchef;
    }

    public void setIdchef(int idchef) {
        this.idchef = idchef;
    }

    public Reunion getSelectedReunion() {
        return selectedReunion;
    }

    public void setSelectedReunion(Reunion selectedReunion) {
        this.selectedReunion = selectedReunion;
    }
    
    
    
}
