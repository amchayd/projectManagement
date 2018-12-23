package pmo.gp.dao;

import java.text.*;
import java.util.*;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pmo.gp.actions.*;
import pmo.gp.beans.*;
import pmo.gp.dao.interfaces.*;

public class ChefProjetDao implements ChefProjetDaoInt{

	@Override
	public int DetaillerProjet(Projet p) {
		// TODO Auto-generated method stub
		          return SaveModifProjet(p);
	}

	@Override
	public List<Projet> MesProjetsEnCours(int id) {
            		// TODO Auto-generated method stub
                        UtilisateurDaoInt user=new UtilisateurDao();
		        Session session =  HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Criteria prjcr = session.createCriteria(Projet.class);
                                 DSIDaoInt dsi=new DSIDao();
                                 ChefProjet cp=new ChefProjet();
                                 cp.setId(id);
                                 prjcr.add(Restrictions.eq("chefprojet",cp));
				List<Projet> results = prjcr.list();
                                List<Projet> finallist=new ArrayList<>();
                               for(Projet p:results)
                               {
                               if(user.getPourcentageProjet(null, new ArrayList<>(p.getEtapes()))!=100)
                               {
                               finallist.add(p);
                               }
                               }
		tx.commit();
		session.close();
                return finallist;
        }
    
   @Override
    public List<Projet> MesProjetsTermines(int id) {
                        UtilisateurDaoInt user=new UtilisateurDao();
		        Session session =  HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Criteria prjcr = session.createCriteria(Projet.class);
                                 DSIDaoInt dsi=new DSIDao();
                                 ChefProjet cp=new ChefProjet();
                                 cp.setId(id);
                                 prjcr.add(Restrictions.eq("chefprojet",cp));
				 List<Projet> results = prjcr.list();
                                 List<Projet> finallist=new ArrayList<>();
                               for(Projet p:results)
                               {
                               if(user.getPourcentageProjet(null, new ArrayList<>(p.getEtapes()))==100)
                               {
                               finallist.add(p);
                               }
                               }
		tx.commit();
		session.close();
                return finallist;
    }

    @Override
    public List<Projet> NouveauxProjets(int id) {
		        Session session =  HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Criteria prjcr = session.createCriteria(Projet.class);
                                 DSIDaoInt dsi=new DSIDao();
                                 ChefProjet cp=new ChefProjet();
                                 cp.setId(id);
                                 prjcr.add(Restrictions.eq("chefprojet",cp));
				List<Projet> results = prjcr.list();
                                List<Projet> finallist=new ArrayList<>();
                               for(Projet p:results)
                               {
                               if(p.getEtapes().size()==0)
                               {
                               finallist.add(p);
                               }
                               }
		tx.commit();
		session.close();
                return finallist;
    }
	@Override
	public void DetaillerCompteRendu(CompteRendu cr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CommenterCompteRendu() {
		// TODO Auto-generated method stub
		
	}
    @Override
    public HashMap<String, Integer> getStatistique(int id) {
        List<Projet> results=MesProjetsEnCours(id);
          HashMap<String,Integer> stat=new HashMap<>();
          UtilisateurDaoInt userdao=new UtilisateurDao();
          for(Projet p:results)
              stat.put(p.getMatricule(),userdao.getPourcentageProjet(p.getMatricule(),null));
                return stat;
    }

    @Override
    public long countNvProjet(int id) {
        long number=0;
        Session session =  HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select count(*) from Projet p where p.chefprojet = :chef and p.etapes.size=0");
        ChefProjet cp=new ChefProjet();
        cp.setId(id);
        query.setParameter("chef", cp);
        List liste = query.list();
        number = (long) liste.get(0);
        session.close();
        return number;
    }

    @Override
    public void ajoutertache(Etape ep) {
            Session session =  HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Criteria epcr = session.createCriteria(Etape.class);
                        session.save(ep);
		        tx.commit();
		        session.close();
    }

    @Override
    public void modifierReunion(Reunion r) {
        
          Session session =  HibernateUtil.getSessionFactory().openSession();
	 /* Transaction tx = session.beginTransaction();
          //recuperer renion
          Reunion oldr=(Reunion )session.get(Reunion.class, r.getIdreunion());
          
          //update old reunion
          oldr.setDatereunion(r.getDatereunion());
          oldr.setEndroit(r.getEndroit());
          oldr.setOrdre(r.getOrdre());
          oldr.setProjet(r.getProjet());
          
          Session session2 =  HibernateUtil.getSessionFactory().openSession();
	  Transaction tx2 = session2.beginTransaction();
          session2.update(oldr);
                  System.err.println("-------------modifierReunion");
          tx.commit();
          session.close();
          tx2.commit();
          session2.close();*/
          Query query = session.createQuery("update Reunion set datereunion = :datereunion,endroit = :endroit, ordre = :ordre" +
    				            " where idreunion = :idreunion");
          query.setParameter("datereunion", r.getDatereunion());
          query.setParameter("endroit", r.getEndroit());
          query.setParameter("ordre", r.getOrdre());
          query.setParameter("idreunion", r.getIdreunion());
          int result = query.executeUpdate();
    }
    @Override
    public int SaveModifProjet(Projet p) {
          Session session =  HibernateUtil.getSessionFactory().openSession();
          Transaction tx = session.beginTransaction();
          String hqlUpdate="update Projet set intitule =:intitule,description = :description,"
                  + " prevudebut = :prevudebut,prevufin= :prevufin,commenatairechefprojet=:commenatairechefprojet" +
    				            " where matricule = :matricule";
        int updateprojet = session.createQuery( hqlUpdate )
        .setString( "intitule", p.getIntitule() )
        .setString( "description", p.getDescription())
        .setDate( "prevudebut", p.getPrevufin())
        .setDate( "prevufin", p.getPrevufin())
        .setString( "commenatairechefprojet", p.getCommenatairechefprojet())
        .setString( "matricule", p.getMatricule() )
        .executeUpdate();
         tx.commit();
         session.close();
         return updateprojet;
    }

    @Override
    public void changerPourcentage(String cod, String mat, String op) {
                  Session session =  HibernateUtil.getSessionFactory().openSession();
                  Query query=null;
        switch(op)
        {
            case "+":
             query = session.createQuery("update Etape set pourcentage =pourcentage +1 " +
                                                " where code = :code and matricule=mat");
                    break;
            case "-":
           query = session.createQuery("update Etape set pourcentage =pourcentage -1 " +
                                                " where code = :code and matricule=mat");  
                break;
                
        }
          query.setParameter("code",cod);
                  query.setParameter("matricule", mat);
        int result = query.executeUpdate();
         session.close();

    }

   

}
