/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.ch01.beans;

import com.jsf.ch01.pojos.PlayerDetails;
import com.jsf.ch01.pojos.PlayerMoreDetails;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ValueChangeEvent;

/**
 * Expression Language puede acceder a los metodos publicos mediante el punto (.) o las corches []. Ejemplo
 * #{playersBean.playerName} o #{playersBean['playerName']}
 * @author PC
 */
@Named(value = "playersBean")
@RequestScoped
public class PlayersBean {
    private static final Logger logger = Logger.getLogger(PlayersBean.class.getName());
    public enum Plays{
        Left, Right
    }
    
    private boolean show_prize = false;
    private boolean show_racquet = false;
    private String facebook = null;
    
    private String playerName = "Rafael";
    private String playerSurname = "Nadal";
    private PlayerDetails playerDetails;
    //Referenciando a un Enum
    private Plays play;
    //Referenciando a un array
    private String[] titles_2013 = {"Sao Paulo", "Acapulco", "ATP World Tour Masters 1000 Indian Wells", "Barcelona", "ATP World Tour Masters 1000 Madrid", "ATP World Tour Masters 1000 Rome", "Roland Garros", "ATP World Tour Masters 1000 Canada", "ATP World Tour Masters 1000 Cincinnati", "US Open"};
    // Referenciando una List
    private List<String> finals_2013 = new ArrayList<String>();
    // Referenciando un Map
    private Map<String, String> matchFacts = new HashMap<String, String>();
    private int prize = 60941937;

    public PlayersBean() {
        facebook = "raphael.naldal@facebook.com";
        play = Plays.Left;
        finals_2013.add("Beijing");
        finals_2013.add("ATP World Tour Masters 1000 Monte Carlo");
        finals_2013.add("Vina del Mar");
        matchFacts.put("Aces", "127");
        matchFacts.put("Double Faults","107");
        matchFacts.put("1st Serve", "70%");
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1986, Calendar.JUNE, 3);
        playerDetails = new PlayerDetails(27, calendar.getTime(), "Manacor, Mallorca, Spain", "Manacor, Mallorca, Spain", 185, 85,
            new PlayerMoreDetails(2001, "Toni Nadal", " http://www.rafaelnadal.com"));
    }
    
    public boolean isShow_racquet() {
        return show_racquet;
    }

    public boolean isShow_prize() {
        return show_prize;
    }
    
    public String getFacebook() {
        return facebook;
    }
    
    public int getPrize()
    {
        return prize;
    }
    
    public String getHonorific()
    {
        return "Mr.";
    }
    
    public List<String> getFinals_2013()
    {
        return finals_2013;
    }
    
    public Map<String, String> getMatchFact()
    {
        return matchFacts;
    }
    
    public String[] getTitles_2013()
    {
        return titles_2013;
    }
    
    public Plays getPlay()
    {
        return play;
    }
    
    public String getPlayerName()
    {
        return playerName;
    }
    
    public String getPlayerSurname()
    {
        return playerSurname;
    }
    
    public PlayerDetails getPlayerDetails()
    {
        return playerDetails;
    }
    
    //Llamando desde JSF: #{playersBean.vamosRafa_1()}
    public void vamosRafa_1() {
        System.out.println("Vamos Rafa!");
    }

    public String vamosRafa_2() {
        return "Vamos Rafa!";
    }
    
    //Llamando desde JSF: #{playersBean.vamosRafa_3('Vamos Rafa!')}
    public void vamosRafa_3(String text) {
        System.out.println(text);
    }
    
    //Llamando a un metodo con dos argumentos desde JSF: #{playersBean.vamosRafa_4(playersBean.playerName, playersBean.playerSurname)}
    public String vamosRafa_4(String name, String surname) {
        return "Vamos " + name + " " + surname + "!";
    }

    public String vamosRafa_5() {
        return "vamos";
    }

    public void showPrizeMoney() {
        this.show_prize = true;
    }

    public void hidePrizeMoney() {
        this.show_prize = false;
    }
    
    public void showHideRacquetPicture(ValueChangeEvent e) {
        if (e.getNewValue() == Boolean.TRUE) {
            this.show_racquet = true;
        } else {
            this.show_racquet = false;
        }
    }

    public void playerListener(ActionEvent e) {
        logger.log(Level.INFO, "playerListener method called ...");
    }

    public void playerDone() {
        logger.log(Level.INFO, "playerDone method called ...");        
    }
}
