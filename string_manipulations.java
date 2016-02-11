import java.util.*; 
import java.io.*;

class Function {  
String LetterChanges(String str) { 
	    String answer="";
	    for(int i = 0; i<str.length(); i++){
	    	Character a = str.charAt(i);
	    	int val = (int) a;
          if(Character.isLetter(a)){
            if(a=='z')
              answer+="A";
	    	else if(!"aeiou".contains(Character.toString((char) (val +1))))
	    		answer+= Character.toString((char) (val +1)); 
	    	else  answer +=Character.toString((char) (val - 31)); 
          } else answer += a;
	    }
	       
	    return answer;
	    
	  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    Function c = new Function();
    System.out.print(c.LetterChanges(s.nextLine())); 
  }   
  
}           
