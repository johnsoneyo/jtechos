/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import bl.GeneralEJB;
import bl.JTechosException;
import entity.Recruit;
import entity.RecruitTech;
import entity.SkillSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author johnson3yo
 */
@RequestScoped
@ManagedBean
public class RegisterController {
    
    private RecruitTech rct = new RecruitTech();
    private Recruit rc = new Recruit();
    private Part file;
    private FacesContext context;
    private UIComponent component;
    private boolean error;
    private SkillSet skillSet = new SkillSet();
    private List<SkillSet>selectedTechList = new ArrayList();
    
   
    
    @EJB GeneralEJB reg;

    public RecruitTech getRct() {
        return rct;
    }

    public void setRct(RecruitTech rct) {
        this.rct = rct;
    }

    public Recruit getRc() {
        return rc;
    }

    public void setRc(Recruit rc) {
        this.rc = rc;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public FacesContext getContext() {
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }

    public SkillSet getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(SkillSet skillSet) {
        this.skillSet = skillSet;
    }
    
    

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UIComponent component) {
        this.component = component;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
    
    
    
    
    
    public String recruitRegistration(){
       try{
           
        
        rc.setDateCreated(new Date());
        reg.registerRecruit(rc, rct,file);
        error= true;
        context = FacesContext.getCurrentInstance();
        context.addMessage(component.getClientId(), new FacesMessage("Your Application has been received"));
        
        return "";
       }
       catch(IOException no){
        error=true;
        context = FacesContext.getCurrentInstance();
        context.addMessage(component.getClientId(), new FacesMessage(no.getMessage()));
        
           return "";
       }
       catch(JTechosException no){
        
         error= false;
        context = FacesContext.getCurrentInstance();
        context.addMessage(component.getClientId(), new FacesMessage(no.getMessage()));
        
           return "";
       }
           
    }
    
    
    
    public List getTechList(){
        
        return this.reg.getTechList();
    }
 
    
  
    
}
