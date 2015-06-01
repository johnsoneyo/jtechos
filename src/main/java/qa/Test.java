/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author johnson3yo
 */
public class Test {
    
    public static Question load(){
        
        List<Question> testList = new ArrayList(); 
        testList.add(new Question("President of united states","obama"));
        testList.add(new Question("Eifel Tower is in what state ","paris"));
        testList.add(new Question("Facebook founder","mark zuckerberg"));
        testList.add(new Question("Founder of Apple Inc","steve jobs"));
        
        return  shuffleList(testList);
    }

    private static Question shuffleList(List<Question> testList) {
        
        Collections.shuffle(testList);
        
        return testList.get(0);
    }
    
  
    
}
