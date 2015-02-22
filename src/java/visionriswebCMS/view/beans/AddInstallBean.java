/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visionriswebCMS.view.beans;

import java.util.ArrayList;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import visionriswebCMS.model.bo.Installs;
import visionriswebCMS.model.dao.daoInstalls;

/**
 *
 * @author Jalal Sordo
 */
@ManagedBean(name = "addInstallBean", eager = true)
@ViewScoped
public class AddInstallBean implements java.io.Serializable{

    private daoInstalls dao;
    private Installs inst;
    private boolean skip;

    /**
     * Creates a new instance of AddInstallBean
     */
    @PostConstruct
    public void init() {
        inst = new Installs();
        System.err.println("installs bean Created = " + Calendar.getInstance().toString());
        dao = new daoInstalls();

    }

    public void addInstall() {
        dao.addInstall(inst);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, " Install bien ajouté", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        RequestContext.getCurrentInstance().execute("addInstall.hide();refresh();");
    }

    public Installs getInst() {
        return inst;
    }

    public void setInst(Installs inst) {
        this.inst = inst;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }
}
