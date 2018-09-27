/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.ch01.pojos;

/**
 *
 * @author PC
 */
public class PlayerMoreDetails {
    private int turnedpro;
    private String coach;
    private String website;

    public PlayerMoreDetails(int turnedpro, String coach, String website) {
        this.turnedpro = turnedpro;
        this.coach = coach;
        this.website = website;
    }

    public int getTurnedpro() {
        return turnedpro;
    }

    public String getCoach() {
        return coach;
    }

    public String getWebsite() {
        return website;
    }     
}
