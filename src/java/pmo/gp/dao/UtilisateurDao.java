package pmo.gp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import pmo.gp.actions.HibernateUtil;

import pmo.gp.beans.ChefProjet;
import pmo.gp.beans.Direction;
import pmo.gp.beans.Etape;
import pmo.gp.beans.Projet;
import pmo.gp.beans.Reunion;
import pmo.gp.beans.Utilisateur;
import pmo.gp.dao.interfaces.UtilisateurDaoInt;

public class UtilisateurDao implements UtilisateurDaoInt {

	@Override
	public Utilisateur Authentifier(String username,String password) {
		Session session =  HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Criteria usercr = session.createCriteria(Utilisateur.class);
				usercr.add(Restrictions.eq("username",username));
				usercr.add(Restrictions.eq("password",password));
				List<Utilisateur> results = usercr.list();
				Utilisateur utilisateur = null;
		 for (Iterator<Utilisateur> iterator = results.iterator(); iterator.hasNext();){
		   utilisateur = (Utilisateur) iterator.next(); 
                   return utilisateur;
		}
		tx.commit();
		session.close();
		return null;
	}

	@Override
	public List<ChefProjet> listerChefs() {
		// TODO Auto-generated method stub
		  Session session =  HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Criteria chefcr = session.createCriteria(ChefProjet.class);
				List<ChefProjet> results = chefcr.list();
		tx.commit();
		session.close();
                return results;
	}

	@Override
	public List<Direction> Directions() {
		  // TODO Auto-generated method stub
		  Session session =  HibernateUtil.getSessionFactory().openSession();
		  Transaction tx = session.beginTransaction();
		  Criteria drcr = session.createCriteria(Direction.class);
		  List<Direction> results = drcr.list();
		tx.commit();
		session.close();
                return results;
	}

	@Override
	public String getChefById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDirectionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Projet getProjetByMatricule(String matricule) {
		// TODO Auto-generated method stub
                  Session session =  HibernateUtil.getSessionFactory().openSession();
		  Transaction tx = session.beginTransaction();
		  Criteria prcr = session.createCriteria(Projet.class);
                           prcr.add(Restrictions.eq("matricule",matricule));
                  Projet projet;
		  List<Projet> results = prcr.list();
                  for (Iterator<Projet> iterator = results.iterator();iterator.hasNext();){
		    projet= (Projet) iterator.next(); 
                   return projet;
		}
		tx.commit();
		session.close();
                return null;	
        }

    @Override
    public List<Etape> getTaches(String matricule) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Etape where MATRICULE = :matricule");
        query.setParameter("matricule", matricule);
        List<Etape> liste = query.list();
        session.close();
        return liste;
    }
        @Override
    public HashMap<String, Integer> statistique() {
        HashMap<String,Integer> stat=new HashMap<String, Integer>();
           return stat;
    }

    @Override
    public int getPourcentageProjet(String matricule,List<Etape> list) {
    int pr=0;
    UtilisateurDaoInt userdao=new UtilisateurDao();
    if(matricule!=null)
    list=userdao.getTaches(matricule);
    int nbrtache=0;
        if(list.size()!=0)
     for (Iterator<Etape> iterator = list.iterator(); iterator.hasNext();){
         Etape ep=(Etape)iterator.next();
		 nbrtache++;
                   pr+=ep.getPourcentage();
		}
     if(nbrtache==0)
     {
     return 0;
     }
     return pr/nbrtache;    
    }

    @Override
    public List<Reunion> getlistReunionschef(int chef) {
           Session session =  HibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("select r.idreunion,r.datereunion,r.endroit,r.ordre,r.projet.matricule from Reunion r,Projet p where p.matricule=r.projet.matricule and p.chefprojet.id= :chef ");
           query.setParameter("chef", chef);
           List liste = query.list();						
           session.close();
                		Iterator it = liste.iterator();
         List<Reunion> listr=new ArrayList<>();
		while(it.hasNext())
		{
			Object o[] = (Object[])it.next();
                         Reunion r=new Reunion();
                         r.setIdreunion(Integer.parseInt(o[0].toString()));
                         r.setDatereunion((Date) o[1]);
                         r.setEndroit(o[2].toString());
                         r.setOrdre(o[3].toString());
                         Projet p=new Projet();
                         p.setMatricule(o[4].toString());
                         r.setProjet(p);
                         listr.add(r);

		}
        return listr;
    }

    @Override
    public boolean isDetailled(String matri) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("select p.matricule from Projet p where p.matricule=:mat and p.prevudebut=null");
           query.setParameter("mat", matri);
           List liste = query.list();						
           session.close();
             if(liste.size()!=0)
            return true;
             return false;
    }
}
