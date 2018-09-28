/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.ch01.beans.lambda;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Players implements Comparable<Players> {
    private String player;
    private byte age;
    private String birthplace;
    private String residence;
    private short height;
    private byte weight;
    private String coach;
    private Date born;
    private int ranking;

    public Players() {
    }
    
    public Players(int ranking, String player, byte age, String birthplace, String residence, short height, byte weight, String coach, Date born) {
        this.ranking = ranking;
        this.player = player;
        this.age = age;
        this.birthplace = birthplace;
        this.residence = residence;
        this.height = height;
        this.weight = weight;
        this.coach = coach;
        this.born = born;
    }        

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }   
    
    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public short getHeight() {
        return height;
    }

    public void setHeight(short height) {
        this.height = height;
    }   

    public byte getWeight() {
        return weight;
    }

    public void setWeight(byte weight) {
        this.weight = weight;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }      

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }        

    @Override
    public int compareTo(Players o) {
        return 1;
    }
}
