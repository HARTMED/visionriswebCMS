/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visionriswebCMS.model.dao;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import visionriswebCMS.model.bo.Installs;
import visionriswebCMS.model.util.NewHibernateUtil;

/**
 *
 * @author admin
 */
public class daoInstalls implements java.io.Serializable{

    SessionFactory ses = NewHibernateUtil.getSessionFactory();

    public daoInstalls() {
    }

    public ArrayList<Installs> getAllInstalls() {

        Session session = ses.openSession();
        try {

            return (ArrayList<Installs>) session.createQuery("from Installs").list();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public static void main(String a[]) {

        daoInstalls dao = new daoInstalls();
        System.err.println(dao.getAllInstalls().size());

    }

    public void addInstall(Installs inst) {
        Session session = ses.openSession();
        Transaction trns = session.getTransaction();

        try {
            trns.begin();
            session.save(inst);
            trns.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trns.rollback();

        } finally {
            session.close();
        }
    }

    public void updateInstall(Installs inst) {
        Session session = ses.openSession();
        Transaction trns = session.getTransaction();

        try {
            trns.begin();
            session.update(inst);
            trns.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trns.rollback();

        } finally {
            session.close();
        }
    }

    public void deleteInstall(Installs inst) {
        Session session = ses.openSession();
        Transaction trns = session.getTransaction();

        try {
            trns.begin();
            session.delete(inst);
            trns.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trns.rollback();

        } finally {
            session.close();
        }
    }

}
