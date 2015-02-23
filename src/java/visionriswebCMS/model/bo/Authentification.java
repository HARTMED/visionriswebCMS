/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visionriswebCMS.model.bo;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import visionriswebCMS.model.util.NewHibernateUtil;


@Entity
@Table(name="authentification"
    ,schema="dbo"
    ,catalog="visionriswebCMS"
)
public class Authentification implements java.io.Serializable{
    
     private int id;
     private String utilisateur;
     private String password;
      private String message;
      @Id 
    @Column(name="Id", unique=true, nullable=false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="utilisateur", nullable=false, length=200)
    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }
    
@Column(name="password", nullable=false, length=200)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     
     
     
    public Authentification(int id, String utilisateur, String password) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.password = password;
    
    }
  
     
    public Authentification() {
    }

    @Override
    public String toString() {
        return "Authentification{" + "id=" + id + ", utilisateur=" + utilisateur + ", password=" + password + '}';
    }
     
     
     
     
}
