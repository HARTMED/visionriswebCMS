/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visionriswebCMS.model.dao;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import visionriswebCMS.model.bo.Authentification;
import visionriswebCMS.model.util.NewHibernateUtil;

/**
 *
 * @author admin
 */
public class daoAuthentification {
    
    
    public boolean isLogged(Authentification log){
       
        Session s=NewHibernateUtil.getSessionFactory().openSession();
        if(log.getUtilisateur()==null || log.getPassword()== null)
        return false;
        Transaction t=s.beginTransaction();
        Authentification buff=(Authentification) s.createCriteria(Authentification.class)
                .add(Restrictions.eq("utilisateur",log.getUtilisateur()))
                .add(Restrictions.eq("password",log.getPassword()))
                .setMaxResults(1)
                .uniqueResult();
      t.commit();
      s.close();
      if(buff == null){
          return false;
      }
      else
      {
          return true;
      }
    }
           
  
}
