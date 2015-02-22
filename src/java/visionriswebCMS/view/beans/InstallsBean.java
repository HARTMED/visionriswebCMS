/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visionriswebCMS.view.beans;

import java.util.ArrayList;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import visionriswebCMS.model.bo.Installs;
import visionriswebCMS.model.dao.daoInstalls;

/**
 *
 * @author admin
 */
@ManagedBean(name = "installs", eager = true)
@SessionScoped
public class InstallsBean {

    private ArrayList<Installs> listInstalls;
    private ArrayList<Installs> filteredInstalls;
    private daoInstalls dao;

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    @PostConstruct
    public void init() {
        System.err.println("installs bean Created = " + Calendar.getInstance().toString());
        dao= new daoInstalls();
        listInstalls=dao.getAllInstalls();
       
    }

    public void setDao(daoInstalls dao) {
        this.dao = dao;
    }

    public ArrayList<Installs> getListInstalls() {
        return listInstalls;
    }

    public void setListInstalls(ArrayList<Installs> listInstalls) {
        this.listInstalls = listInstalls;
    }

    public void setFilteredInstalls(ArrayList<Installs> filteredInstalls) {
        this.filteredInstalls = filteredInstalls;
    }

    public ArrayList<Installs> getFilteredInstalls() {
        return filteredInstalls;
    }

  

}
