/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import bl.GeneralEJB;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author johnson3yo
 */
@FacesConverter(value="sconvert")
public class SkillSetConverter implements Converter {

    GeneralEJB ge;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            ge = (GeneralEJB) new InitialContext().lookup("java:global/jtechos/GeneralEJB");
            
            return ge.getSkillSet(value);
        } catch (NamingException ex) {
        return null; 
        }
       
     
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      return value.toString();
    }
    
}
