/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.beans;

import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

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
    
    public void init()
    {
        logger.info("The init() method was called!!!");
        if(playerName != null)
        {
            setPlayerName(playerName.toUpperCase());
        }
        
        if(playerSurname != null)
        {
            setPlayerSurname(playerSurname.toUpperCase());
        }
    }
    
    public void userAction()
    {
        logger.info("The userAction() method was called");
    }
    
}
