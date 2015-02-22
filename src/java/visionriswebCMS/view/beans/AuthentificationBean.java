/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visionriswebCMS.view.beans;

/**
 *
 * @author admin
 */
 
import java.io.Serializable;
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.Transaction;
 
//import com.otv.hbm.User;
//import com.otv.util.HibernateUtil;
import java.util.logging.Logger;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import org.hibernate.criterion.Restrictions;
import visionriswebCMS.model.bo.Authentification;
import visionriswebCMS.model.util.NewHibernateUtil;
 
/**
 * @author onlinetechvision.com
 * @since 3 Oct 2011
 * @version 1.0.0
 *
 */
public class AuthentificationBean implements Serializable{
     
   
//    private static final long serialVersionUID = 1L;
//  //  private static Logger log = Logger.getLogger(UserManagedBean.class);
//    private static final String SUCCESS = "success";
//    private static final String ERROR   = "error";  
    private String utilisateur;
    private String password;
//    private String message;

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        public PhaseId getPhaseID(){
        return PhaseId.RESTORE_VIEW;
    }
    
    private boolean login(){
        @SuppressWarnings("static-access")
        Authentification u=(Authentification)FacesContext.getCurrentInstance().getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if(u !=null){
            if(u.isLogged())
                return true;
            return false;
        }
        else return false;
    }
     
    public void afterPhase(PhaseEvent event){
      if(event.getPhaseId()==PhaseId.RESTORE_VIEW){
          FacesContext fc = event.getFacesContext();
          boolean loginPage =fc.getViewRoot().getViewId().lastIndexOf("utilisateur") > -1 ? true : false; 
      if(!loginPage && !login()){
          NavigationHandler nh=fc.getApplication().getNavigationHandler();
          nh.handleNavigation(fc,"utilisateur", "password");
      }
      }
  }
    public boolean isLogged(Authentification log){
       
        this.s=NewHibernateUtil.getSessionFactory().openSession();
        if(log.getUtilisateur()==null || log.getPassword()== null)
        return false;
        Transaction t=this.s.beginTransaction();
        Authentification buff=(Authentification) this.s.createCriteria(Authentification.class)
                .add(Restrictions.eq("utilisateur",log.getUtilisateur()))
                .add(Restrictions.eq("password",log.getPassword()))
                .setMaxResults(1)
                .uniqueResult();
      t.commit();
      this.s.close();
      if(buff == null){
          return false;
      }
      else
      {
          return true;
      }
    }
   
}