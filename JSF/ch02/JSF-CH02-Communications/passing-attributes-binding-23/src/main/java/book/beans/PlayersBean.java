/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIInput;

/**
 *
 * @author PC
 */
@Named(value = "playersBean")
@RequestScoped
public class PlayersBean {

    private UIInput htmlInputText = null;
    
    public PlayersBean() {
    }
    
    public UIInput getHtmlInputText()
    {
        return htmlInputText;
    }
    
    public void setHtmlInputText(UIInput htmlInputText)
    {
        this.htmlInputText = htmlInputText;
    }
    
    public String getPlayerNameSurname()
    {
        return (String)htmlInputText.getAttributes().get("playerNameAttr");
    }
}
