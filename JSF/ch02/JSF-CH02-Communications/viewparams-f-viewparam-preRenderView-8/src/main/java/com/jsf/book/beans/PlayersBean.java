/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.book.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PC
 */
@Named(value = "playersBean")
@RequestScoped
public class PlayersBean {

    private String playerName;
    private String playerSurname;

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
    
    public PlayersBean() {
    }
    
    public void init()
    {
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
