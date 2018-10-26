/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ComponentSystemEvent;

/**
 *
 * @author PC
 */
@Named(value = "playersBean")
@RequestScoped
public class PlayersBean {

    private final static Logger logger = Logger.getLogger(PlayersBean.class.getName());
    private String playerName;
    private String playerSurname;
    
    public PlayersBean() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerSurname() {
        return playerSurname;
    }

    public void setPlayerSurname(String playerSurname) {
        this.playerSurname = playerSurname;
    }
    
    public String addValueToFlashAction()
    {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("playerName", playerName);
        flash.put("playerSurname", playerSurname);
        
        return "terms?faces-redirect=true";
    }
    
    public void pullValuesFromFlashAction(ComponentSystemEvent e)
    {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        playerName = (String)flash.get("playerName");
        playerSurname = (String)flash.get("playerSurname");
    }
    
    public String termsAcceptedAction()
    {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.setKeepMessages(true);
        pullValuesFromFlashAction(null);
        
        //hacemos algo con el firstName y surName
        logger.log(Level.INFO, "First name: {0}", playerName);
        logger.log(Level.INFO, "Sur name: {0}", playerSurname);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Terms accepted and player registered"));
        return "done?faces-redirect=true";
    }
    
    public String termsRejectAction()
    {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.setKeepMessages(true);
        pullValuesFromFlashAction(null);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Terms rejected! Player not registered"));
        return "index?faces-redirect=true";
    }
}
