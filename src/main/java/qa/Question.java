/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qa;

/**
 *
 * @author johnson3yo
 */
public class Question {
    
    

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    
   
    private String question;
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    
}
