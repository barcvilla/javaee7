/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.beans;

import java.util.Random;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author PC
 */
@Named(value = "playersBean")
@RequestScoped
public class PlayersBean {

    private String playerName = "";
    private String playerSurname = "";
    private FacesContext facesContext;
    
    public PlayersBean() {
    }
    
    @PostConstruct
    public void postConstruct()
    {
        facesContext = FacesContext.getCurrentInstance();
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
    
    public String validateData()
    {
        Random r = new Random();
        int valid = r.nextInt(20);
        if(valid < 10)
        {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Player name/surname Validation Failed", ""));
        }
        
        return "index";
    }
    
}
