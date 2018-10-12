/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.book.beans;

import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author PC
 */
@Named(value = "playersBean")
@RequestScoped
public class PlayersBean {

    private static final Logger logger = Logger.getLogger(PlayersBean.class.getName());
    private String playerName;
    private String playerSurname;
    
    public PlayersBean() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        logger.info("EXECUTING 'setPlayName' SETTER");
        this.playerName = playerName;
    }

    public String getPlayerSurname() {
        return playerSurname;
    }

    public void setPlayerSurname(String playerSurname) {
        logger.info("EXECUTING 'setPlayerSurname' SETTER");
        this.playerSurname = playerSurname;
    }
    
    
    public void init()
    {
        if(!FacesContext.getCurrentInstance().isPostback())
        {
            logger.info("EXECUTING INIT ACTION");
            if(playerName != null)
            {
                setPlayerName(playerName.toUpperCase());
            }
            if(playerSurname != null)
            {
                setPlayerSurname(playerSurname.toUpperCase());
            }
        }
    }
    
    public void postbackAction()
    {
        logger.info("EXECUTING POSTBACK ACTION");
    }
}
