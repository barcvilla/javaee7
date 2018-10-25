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
import javax.faces.event.ActionEvent;

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
        logger.log(Level.INFO, "Player name (from setPlayerName()) method: {0}", playerName);
    }

    public String getPlayerSurname() {
        return playerSurname;
    }

    public void setPlayerSurname(String playerSurname) {
        this.playerSurname = playerSurname;
        logger.log(Level.INFO, "Player Surname (from setPlayerSurname() method: {0})", playerSurname);
    }
    
    public void parametersAction()
    {
        logger.log(Level.INFO, "Player name (from parametersAction() method: {0})", playerName);
        logger.log(Level.INFO, "Player surname (from parametersAction() method: {0})", playerSurname);
    }
    
    public void parametersAction(ActionEvent e)
    {
        logger.log(Level.INFO, "Player name (from parametersAction(ActionEvent e) method {0})", this.playerName);
        logger.log(Level.INFO, "Player surname (from parametersAction(ActionEvent e) method {0})", this.playerSurname);
    }
}
