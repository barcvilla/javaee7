/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.ch01.beans.lambda;

import java.util.Comparator;

/**
 *
 * @author PC
 */
public class TreeSetComparator implements Comparator<Players> {
    @Override
    public int compare(Players key_1, Players key_2) {
        return key_1.getRanking() - key_2.getRanking();
    }
}
