/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pmo.gp.actions;

import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import org.primefaces.model.chart.*;
import pmo.gp.beans.*;
import pmo.gp.dao.*;
import pmo.gp.dao.interfaces.*;
/**
 *
 * @author oualid
 */
@ManagedBean(name = "PrjsAction", eager = true)
@RequestScoped
public class ProjetAction implements Serializable{
    private int id;
    private List<Projet> listeprojet;
    private Projet selectedProjet;
    private int idChefProjet;
    private int idDirection;
    /*DETAILLE PROJET*/
    List<Etape> listeEtape;
    /*STATISTIQUE PROJER*/
    private BarChartModel barModel;
    /*USERTPE & USERID*/
    private int userid;
    private String usertype;
    /*TACHE*/
    private Etape tache;

    
    @PostConstruct
    public void init() {
       this.userid=SessionTools.getUserid();
       this.usertype=SessionTools.getUsertype();
       if(usertype.equals("DSI")) 
       {
       listeprojet = listerProjet();
       }else if(usertype.equals("CHEFPROJET"))
       {
      listeprojet=listerMesProjet(userid);
       }
       tache=new Etape();
       selectedProjet=new Projet();
    }
    /*LISTER PROJETS CHEF*/
    public List<Projet> listerMesProjet(int id)
    {
             ChefProjetDaoInt cp=new ChefProjetDao();
	     return cp.MesProjetsEnCours(id);
    }
    /*LISTER PROJETS DSI*/
    public String listerProjet(int index)
    {
         List<Projet> listTmp;
         List<Projet> list;
         ChefProjetDaoInt cp;
        switch(index)
        {
            case 0:
                /*tout projets*/
               listeprojet=listerProjet();
                break;
            case 1:
                /*Projets terminé*/
                listTmp=listerProjet();
                list=new ArrayList<Projet>();
                for(Projet p:listTmp)
                {
                    if(getPourcentage(p.getMatricule())==100)
                        list.add(p);
                }  
                listeprojet=list;
                break;
                case 2:
                  /*Projets en cour*/
                listTmp=listerProjet();
                list=new ArrayList<>();
                for(Projet p:listTmp)
                {
                    if(getPourcentage(p.getMatricule())!=100)
                        list.add(p);
                }  
                listeprojet=list;
                break;
            case 3:
                 /*Projets non détaillés*/
                listTmp=listerProjet();
                list=new ArrayList<>();
                for(Projet p:listTmp)
                {
                    if(!isDetailled(p.getMatricule()))
                        list.add(p);
                }  
                listeprojet=list;
                break;
             case 4:
                 /*Projets Chef Terminer*/
                 cp=new ChefProjetDao();
                listeprojet=cp.MesProjetsTermines(this.userid);
                break;
            case 5:
                 /*Projets chef en cour*/
                cp=new ChefProjetDao();
                listeprojet=cp.MesProjetsEnCours(this.userid);
                break;
            case 6:
                 /*Nouveaux Projets chef*/
                cp=new ChefProjetDao();
                listeprojet=cp.NouveauxProjets(this.userid);
                break;
            
        }
        return "allprojets";
    }
    /*getSome info nv projet*/
    public List<Projet> getListenvprojets() {
       ChefProjetDaoInt cp=new ChefProjetDao();
        return cp.NouveauxProjets(this.userid);
    }
    
    private List<Projet> listerProjet()
    {
             List<Projet> list=new ArrayList<Projet>();
             DSIDaoInt dsi=new DSIDao();
	     list = dsi.ConsulterProjets(null, null);
             return list;
    }
    /*nombre de nouveaux projets*/
    public long getCountNouveauxProjets()
    {
    long i=0;
    ChefProjetDaoInt cp=new ChefProjetDao();
    i=cp.countNvProjet(this.userid);
    return i;
    }
    /*si le projet est detaillé*/
    public boolean isDetailled(String matricule)
    {
        UtilisateurDaoInt userdao=new UtilisateurDao();
       return userdao.isDetailled(matricule);
    }
    
    /*MODIFIER PROJET*/
    public String ModifierProjet(String matricule)
    {
       if(matricule==null ||matricule.equals("") )
           return "allprojets";
      UtilisateurDaoInt userdao=new UtilisateurDao();
      selectedProjet=userdao.getProjetByMatricule(matricule);
      if(selectedProjet!=null)
      {
          setIdChefProjet(selectedProjet.getChefprojet().getId());
          setIdDirection(selectedProjet.getDirectionresponsable().getId());
      return "modifierprojet";

      }
      return "index";
    }
    /*SAVE UPDATED DATA*/
    public String SaveModificationProjet()
    {
     Direction d=new Direction();
     d.setId(getIdDirection());
     ChefProjet cp=new ChefProjet();
     cp.setId(getIdChefProjet());
     selectedProjet.setChefprojet(cp);
     selectedProjet.setDirectionresponsable(d);
     ChefProjetDaoInt cpdao=new ChefProjetDao();
     int i=cpdao.SaveModifProjet(selectedProjet);
     if(i==1)
    return "allprojets";
     return "";
    }
    /*DETAILLE PROJET*/
    public String Detailleprojet(String matricule)
    {
      UtilisateurDaoInt userdao=new UtilisateurDao();
      selectedProjet=userdao.getProjetByMatricule(matricule);
      listeEtape=new ArrayList<>(selectedProjet.etapes);
      if(selectedProjet!=null)
      {
      return "detailleprojet";
      }
      return "allprojets";
    }
    /*TACHES*/
      public String gettaches(String matricule)
    {
      UtilisateurDaoInt userdao=new UtilisateurDao();
      selectedProjet=userdao.getProjetByMatricule(matricule);
      listeEtape=new ArrayList<>(selectedProjet.etapes);
      if(selectedProjet!=null)
      { 
          
      return "taches";
      }
      return "allprojets";
    }
          
    /*AJOUTER TACHE*/
    public String ajoutertache()
    {
    tache.setProjet(selectedProjet);
    ChefProjetDaoInt cp=new ChefProjetDao();
    cp.ajoutertache(tache);
    return "allprojets";
    }
    /*Changer pourcentage*/
    public void changerPourcentage(String code,String matricule,String op)
    {
                 System.err.println("-----chp");
        ChefProjetDaoInt cp=new ChefProjetDao();
        cp.changerPourcentage(code,matricule, op);
    }
    /*DETAILLER PROJET*/
    public String detaillerprojet(String matricule)
    {
        if(matricule==null ||matricule.equals("") )
           return "allprojets";
      UtilisateurDaoInt userdao=new UtilisateurDao();
      selectedProjet=userdao.getProjetByMatricule(matricule);
      if(selectedProjet!=null)
      {
      return "detaillerprojet";

      }
      return "index";
    }
    /*TACHES*/
    public String taches(String matricule)
    {
        if(matricule==null ||matricule.equals("") )
           return "allprojets";
      UtilisateurDaoInt userdao=new UtilisateurDao();
      selectedProjet=userdao.getProjetByMatricule(matricule);
      if(selectedProjet!=null)
      {
      return "taches";

      }
      return "index";
    }
    /*SUBMIT DETAILLER PROJET*/
    public String SubmitDetaillerProjet()
    {
         ChefProjetDaoInt cp=new ChefProjetDao();
        int i= cp.DetaillerProjet(selectedProjet);
         if(i==1)
        return "taches";
         return "";
    }
    /*GANTT PROJET*/
    public String getEtantAvancement(String matricle) 
    {
    return "statistique";
    }
    /*POURCENTAGE PROJET*/
    public int getPourcentage(String matricule)
    {
     UtilisateurDaoInt userdao=new UtilisateurDao();
     return userdao.getPourcentageProjet(matricule,null);
    }
    /*Statistique*/
    public String getStatistique()
    {
    createBarModels();
    return "statistique";
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setListeprojet(List<Projet> listeprojet) {
        this.listeprojet = listeprojet;
    }
    
    
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries projets = new ChartSeries();
        HashMap<String,Integer> stat=new HashMap<String,Integer>();
         if(this.usertype.equals("DSI")) 
       {
           DSIDaoInt dsi=new DSIDao();
           stat=dsi.getAllStatistique();
       }else if(this.usertype.equals("CHEFPROJET"))
       {
           ChefProjetDaoInt cp=new ChefProjetDao();
           stat=cp.getStatistique(this.userid);
       }
        
        
        Set cles = stat.keySet();
        Iterator it = cles.iterator();
       while (it.hasNext()){
               String cle = (String)it.next(); 
               int valeur = stat.get(cle);
               projets.set(cle, valeur);
            }
 
        model.addSeries(projets);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Statistique");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
             xAxis.setLabel("Matricule Projet");
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Etat %");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }
 
    /*LISTE CHEF*/
    public List<ChefProjet> getListeChef()
    {
        UtilisateurDaoInt user=new UtilisateurDao();
        return user.listerChefs();
    }
    /*LISTE DIRECTION*/
    public List<Direction> getListeDirection()
    {
        UtilisateurDaoInt user=new UtilisateurDao();
        return user.Directions();
    }
    
    /*GETTERS ET SETTERS*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Projet> getListeprojet() {
        return listeprojet;
    }

    public void setListeprojet() {
        this.listeprojet = listerProjet();
    }

    public Projet getSelectedProjet() {
        return selectedProjet;
    }

    public void setSelectedProjet(Projet selectedProjet) {
        this.selectedProjet = selectedProjet;
    }

    public int getIdChefProjet() {
        return idChefProjet;
    }

    public int getIdDirection() {
        return idDirection;
    }

    public void setIdChefProjet(int idChefProjet) {
        this.idChefProjet = idChefProjet;
    }

    public void setIdDirection(int idDirection) {
        this.idDirection = idDirection;
    }

    public List<Etape> getListeEtape() {
        return listeEtape;
    }

    public void setListeEtape(List<Etape> listeEtape) {
        this.listeEtape = listeEtape;
    }

    public Etape getTache() {
        return tache;
    }

    public void setTache(Etape tache) {
        this.tache = tache;
    }
   
    
    
    
    
    
    
}
