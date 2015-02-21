/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visionriswebCMS.view.beans;

import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author admin
 */
@ManagedBean(name = "installs", eager = true)
@SessionScoped
public class InstallsBean {

    private String text;

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    @PostConstruct
    public void inint() {
        System.err.println("installs bean Created = " + Calendar.getInstance().toString());
        text = "ahmed";

    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
