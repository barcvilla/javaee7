/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.ch01.beans.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.el.ELContext;
import javax.el.LambdaExpression;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author PC
 */
@Named(value = "lambdaBean")
@RequestScoped
public class LambdaBean {

    List<Integer> costBeforeVAT = Arrays.asList(34, 2200, 1350, 430, 57, 10000, 23, 15222, 1);
    List<Integer> primes = Arrays.asList(11, 29, 5, 19, 2, 13, 17, 7, 23, 3);
    List<String> languages = Arrays.asList("Java", "Scala", "C++", "Onyx", "Haskell", "Inform", "Lisp", "Accent", "Basic", "Delphi", "Fortran");
    List<String> orders = Arrays.asList("order#23200", "order#23200", "order#23200", "order#23200", "order#23200");
    List<String> names = Arrays.asList("Mark", "John", "Nelly", "Mark", "Kelly", "Kelly", "Mark", "Raul", "Molly", "Sully");
    List<String> toothless = Arrays.asList("", "a", "ab", "", "", "abcde", "qwert", "", "er", "k", "klmno");
    
    public List<String> getOrders() {
        return orders;
    }

    public List<String> getToothless() {
        return toothless;
    }

    public List<Integer> getCostBeforeVAT() {
        return costBeforeVAT;
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public List<String> getNames() {
        return names;
    }

    public Object firstLambdaAction(LambdaExpression lambdaExpression) {

        //useful in case of a custom ELContext
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        return lambdaExpression.invoke(elContext, 8, 3);

        //or simply, default ELContext:
        //return lambdaExpression.invoke(8, 3);
    }

    public Object secondLambdaAction(LambdaExpression lambdaExpression) {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();

        Map<String, Object> args = new HashMap<>();
        args.put("n", 17);
        args.put("m", 4);
        elContext.enterLambdaScope(args);
        Object result = lambdaExpression.invoke(elContext.isLambdaArgument("n") ? elContext.getLambdaArgument("n") : 0, elContext.isLambdaArgument("m") ? elContext.getLambdaArgument("m") : 0);
        elContext.exitLambdaScope();

        return result;
    }

    public Object thirdLambdaAction(LambdaExpression lambdaExpression) {
        return lambdaExpression.invoke(10);
    }
    
}
