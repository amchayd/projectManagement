package pmo.gp.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import pmo.gp.actions.*;

import pmo.gp.beans.*;
import pmo.gp.dao.interfaces.*;

public class DSIDao implements DSIDaoInt{

	@Override
	public void CreerProjet(Projet p) {
		// TODO Auto-generated method stub
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            p.setDatecreation(date);
            Session session =  HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Criteria prcr = session.createCriteria(Projet.class);
                        session.saveOrUpdate(p);
		        tx.commit();
		        session.close();
	}

	@Override
	public List<Projet> ConsulterProjets(String critere,Object valeur) {
		// TODO Auto-generated method stub
		  Session session =  HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Criteria prjcr = session.createCriteria(Projet.class);
                                 if(critere!=null)
                                 prjcr.add(Restrictions.eq(critere,valeur));
				List<Projet> results = prjcr.list();
		tx.commit();
		session.close();
                return results;
	}

	@Override
	public void ValiderCompteRendu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashSet<CompteRendu> ConsulterCompteRendu() {
		// TODO Auto-generated method stub
		return null;
	}


    @Override
    public HashMap<String,Integer> getAllStatistique() {
          List<Projet> results=ConsulterProjets(null, null);
          HashMap<String,Integer> stat=new HashMap<String, Integer>();
          UtilisateurDaoInt userdao=new UtilisateurDao();
          for(Projet p:results)
              stat.put(p.getMatricule(),userdao.getPourcentageProjet(p.getMatricule(),null));
                return stat;
    }

    @Override
    public void SaveModifProjetDSI(Projet p) {
          Session session =  HibernateUtil.getSessionFactory().openSession();
          Transaction tx = session.beginTransaction();
          String hqlUpdate="update Projet set intitule =:intitule,sponsor = :sponsor,"
                  + " budget = :budget,chefprojet= :chef,directionresponsable=:direction" +
    				            " where matricule = :matricule";
        int updateprojet = session.createQuery( hqlUpdate )
        .setString( "intitule", p.getIntitule() )
        .setString( "sponsor", p.getSponsor())
        .setDouble( "budget", p.getBudget())
        .setInteger("chef", p.getChefprojet().getId())
        .setInteger("direction", p.getDirectionresponsable().getId())
        .setString( "matricule", p.getMatricule() )
        .executeUpdate();
tx.commit();
session.close();    }




	
}
