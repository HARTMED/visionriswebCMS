/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visionriswebCMS.model.dao;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import visionriswebCMS.model.bo.Installs;
import visionriswebCMS.model.util.NewHibernateUtil;

/**
 *
 * @author admin
 */
public class daoInstalls {

    public daoInstalls() {
    }

    public ArrayList<Installs> getAllInstalls() {
        try {

            SessionFactory ses = NewHibernateUtil.getSessionFactory();
            Session session = ses.openSession();

            return (ArrayList<Installs>) session.createQuery("from Installs").list();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String a[]) {

        daoInstalls dao = new daoInstalls();
        System.err.println(dao.getAllInstalls().size());
        
        
    }

}
