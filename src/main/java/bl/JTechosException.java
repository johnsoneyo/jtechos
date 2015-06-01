/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

/**
 *
 * @author johnson3yo
 */
public class JTechosException extends Exception {

    private String message;
    
    public JTechosException(String wrong_answer) {
        message = wrong_answer;
    }
    
    
    public String getMessage(){
        return message;
    }
    
}
