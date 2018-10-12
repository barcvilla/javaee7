/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.book.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PC
 */
@Named(value = "dateBean")
@RequestScoped
public class DateBean {

    private Date date = new Date();
    
    public void setDate(Date date)
    {
        this.date = date;
    }
    
    public Date getDate()
    {
        return date;
    }
    
    public String sendDate()
    {
        String dateAsString = new SimpleDateFormat("dd-MM-yyyy").format(date);
        return "date.xhtml?faces-redirect=true&date=" + dateAsString;
    }
    
    public DateBean() {
        
    }
    
}
