/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author PC
 */
@Named(value = "contextParamBean")
@RequestScoped
public class ContextParamBean {

    private String numberOne;
    
    public ContextParamBean() {
    }

    public String getNumberOne() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        numberOne = facesContext.getExternalContext().getInitParameter("number.one.in.atp");
        return numberOne;
    }
    
}
