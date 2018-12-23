/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pmo.gp.actions;

import java.io.Serializable;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import pmo.gp.filter.FilterAuth;

/**
 *
 * @author oualid
 */
@ManagedBean(name = "Util", eager = true)
public class SessionTools implements Serializable{
     private static String usertype ;
     private static int userid;
     private static String username;
     /**/
     private static final String _username="username";
     private static final String _userid="userid";
     private static final String _usertype="usertype";
     
     
 

    public static String getUsertype() {
        usertype=getSession().getAttribute(_usertype).toString();
        return usertype;
    }

    public static void setAttr(String key,Object val) {
        getSession().setAttribute(key,val);
    }
     public static Object getAttr(String key) {
         Object val=getSession().getAttribute(key);
        return val;
    }
    public static String getUsername() {
        username=getSession().getAttribute(_username).toString();
        return username;
    }
    public static int getUserid() {
        userid=Integer.parseInt(getSession().getAttribute(_userid).toString());
        return userid;
    }

    public static void setUsertype(String usertype) {
        HttpSession sess=getSession();
        sess.setAttribute(_usertype, usertype);
    }

    public static void setUserid(int userid) {
        HttpSession sess=getSession();
        sess.setAttribute(_userid, userid);
    }

    public static void setUsername(String username) {
        HttpSession sess=getSession();
        sess.setAttribute(_username, username);
    }
    
    
    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
    }
 
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }
}
