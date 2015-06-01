/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

/**
 *
 * @author johnson3yo
 */
public class Codility {

    public static void main(String[] args) {

        int a = 7;
        int b = 3;
        int c = a * b;
        
        int count=0;

        String s = Integer.toBinaryString(c);
        char[] ca = s.toCharArray();
        
        System.out.println(ca);
        
        for(int i=0; i<ca.length; i++){
            if(ca[i]=='1'){
              count++;  
            }
            
        }
        
        System.out.println("count of 1 set bit is "+count);

    }
}
