/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import bl.GeneralEJB;
import bl.JTechosException;
import entity.ContactUs;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import qa.Question;
import qa.Test;

/**
 *
 * @author johnson3yo
 */
@Named
@RequestScoped
public class ContactController {
    
    @EJB GeneralEJB gEJB;
 
    private ContactUs contact = new ContactUs();
    private FacesContext context;
    private UIComponent component;
    private Question question;
    private boolean error;
    
    private String answer;
    private TimeZone timeZone;
    
    @PostConstruct
    public void initQuestion(){
       
    question = Test.load();
      
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
    
    
    
    
    private String orgName;
    private String orgMsg;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    
    
    
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgMsg() {
        return orgMsg;
    }

    public void setOrgMsg(String orgMsg) {
        this.orgMsg = orgMsg;
    }

    public TimeZone getTimeZone() {
        return TimeZone.getDefault();
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
    
    

    public ContactUs getContact() {
        return contact;
    }

    public void setContact(ContactUs contact) {
        this.contact = contact;
    }

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UIComponent component) {
        this.component = component;
    }
    
   
    
    public String send(){
        
        try{
        contact.setTimeCreated(new Date());
        gEJB.verifyAnswer(question,answer);
        this.gEJB.sendMessage(contact);
        error= true;
        context = FacesContext.getCurrentInstance();
        context.addMessage(component.getClientId(), new FacesMessage("Your Message has been received"));
        
        return "";
        }
        catch(JTechosException je){
            error=false;
             context = FacesContext.getCurrentInstance();
        context.addMessage(component.getClientId(), new FacesMessage(je.getMessage()));
        
            
          return "";
        }
            
    }
    
    
    public List getJobList(){
        
     return gEJB.getJobList();
        
    }
    
    
}
