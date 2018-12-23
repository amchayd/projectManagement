package pmo.gp.actions;

import java.util.*;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import pmo.gp.beans.*;
import pmo.gp.dao.*;
import pmo.gp.dao.interfaces.*;

@ManagedBean(name = "LoginAction", eager = true)
@RequestScoped
public class LoginAction{
	private String username;
	private String password;
        private String err;
        private javax.servlet.http.HttpSession sess;
        

	/**
	 * Authentification
	 */
        public void test()
        {
                        Session session =  HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Criteria prcr = session.createCriteria(Utilisateur.class);
                       Utilisateur u=new Utilisateur();
                       u.setNom("too");
                        session.saveOrUpdate(u);
		        tx.commit();
		        session.close();
        }
        public String login()
        {
            err="";
            DSIDaoInt dsi=new DSIDao();
	   int i =dsi.ConsulterProjets(null, null).size();
                String execString="Failed";
		if(!getUsername().equals("") && !getPassword().equals("")){
		UtilisateurDaoInt userdao=new UtilisateurDao();
                Utilisateur u=userdao.Authentifier(getUsername(), getPassword());
       if(u != null)
      {
            SessionTools.setUserid(u.getId());
            SessionTools.setUsername(u.getNom().toUpperCase()+" "+u.getPrenom().toUpperCase());
            SessionTools.setUsertype(u.getRole().getLibelle());
    	    execString = "allprojets";	
      }
		
        }else
                    execString = "index";
                    err="Nom utilisateur ou Mot de passe incorrects";
                  return execString;
        }
	/**
        *Deconnexion
        */
          //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionTools.getSession();
        session.invalidate();
        return "index";
         }
        public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
        
    
	
        
	

}
