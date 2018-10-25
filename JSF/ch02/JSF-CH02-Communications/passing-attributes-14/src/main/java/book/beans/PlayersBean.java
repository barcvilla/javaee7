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

    public static final Logger logger = Logger.getLogger(PlayersBean.class.getName());
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
    
    public void parametersAction(ActionEvent evt)
    {
        this.playerName = (String)evt.getComponent().getAttributes().get("playerNameAttr");
        this.playerSurname = (String)evt.getComponent().getAttributes().get("playerSurnameAttr");
        
        logger.log(Level.INFO, "Name: {0} Surname: {1}", new Object[]{playerName, playerSurname});
    }
    
}
