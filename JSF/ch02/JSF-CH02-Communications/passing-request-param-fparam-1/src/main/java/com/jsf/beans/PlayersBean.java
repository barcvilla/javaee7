/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.beans;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

/**
 * Algunas veces necesitamos pasar parametros desde Facelet al managed bean o a otro Facelet. Para ese caso necesita utilizar el tag
 * <f:param> el cual puede ser usado para adicionar un query string nombre-valor a un request. 
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
    
    /**
     * Cuando se hace click al CommandButton en el JSF, los request parameters son enviados a este metodo parametersAction()
     * Extraemos estos parametros accediendo a los request parameters a traves del FacesContext y finalmente return "result" es
     * el nombre de otra pagina JSF result
     * @return 
     */
    public String parametersAction()
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        setPlayerName(params.get("playerNameParam"));
        setPlayerSurname(params.get("playerSurnameParam"));
        return "result";
    }
    
    /**
     * Ejecutamos una tarea de inicializacion. Despues de establecer managed bean properties pero antes que 
     * un metodo de accion sea llamdo (si existe)
     * Este metodo ini sera llamado antes que se llame a parametersAction() 
     */
    @PostConstruct
    public void ini()
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        logger.log(Level.INFO, "Name: {0} Surname: {1}", new Object[]{params.get("playerNameParam"), params.get("playerSurnameParam")});
    }
}
