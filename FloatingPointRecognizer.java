import java.util.Scanner;

public class FloatingPointRecognizer{
//UML State Diagrams 
 /**
  *  
  * @param args
  * This is main method which accepts the input string
  * as pass to the hasUNumber method
  * return nothing
  */
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
    System.out.println(hasUNumber(input));
    in.close();
  }
  
  /**********
   * This is the UNumber recognizer for the acceptor above.  The algorithm is the same.  The 
   * only difference is that these methods do not produce a UNumber.  They just return true or 
   * false based on what is found in the input.
   * 
   * This method processes the UNumber up to the exponent, States 0 through 5.  State 6 through
   * 8 are called from so many places, so we have factored that portion out and it is below.
   * 
   * @param src
   * @return 
   */
 
  public static boolean hasUNumber(String src) {
    String s = src + ';';                       // Add the sentinel at the end 
    int ndx = 0;                             // Start at the beginning of the string
    // State 0                                // We start in State 0
    if (s.charAt(0) >= '0'&&s.charAt(0) <= '9') {       // If the first character is a digit, 
      // State 1                              // transition to State 1 and process
      ndx = 1;                                // as many more digits as is there
      /*
       * This block of code checks whether the character is between 0 to 9
       */
      while (s.charAt(ndx) >= '0'&&s.charAt(ndx) <= '9') ndx++; // When we encounter a
      if (s.charAt(ndx) == '.') {                 // non-digit, see if it was a decimal 
        // State 2                            // point.  If so transition to State 2
        ndx++;                              // Accept it and see if there are more
        if (s.charAt(ndx) >= '0'&&s.charAt(ndx) <= '9') {// is another digit.  If so we
          // State 3                          // transition to State 3
          ndx++;                            // Accept the digit and then skip as 
          while (s.charAt(ndx) >= '0'&&s.charAt(ndx) <= '9') ndx++; // many as there are
                                      // When the end of the digit sequence 
          if (s.charAt(ndx) == 'E' || s.charAt(ndx) == 'e') // If there is an 'E' or 'e'
            return hasUNumberState6(s, ndx+1);       // use State 6 method and return result. 
          // End of State 3, but no exponent, so see if we are at the sentinel.  If so we
          else if (ndx + 1 == s.length()) 
            return true;    // done and we return true
          else
            return false;                    // otherwise, error and return false
          
        // State 2, but it is not a digit           // Therefore, we see if it might be an
        } else if (s.charAt(ndx) == 'E' || s.charAt(ndx) == 'e') { // an exponent.  If so
            return hasUNumberState6(s, ndx+1);         // return was State6 method does
          
        // State 2, but no digit or exponent          // If it is the sentinel, then we return
        } else if (ndx + 1 == s.length()) 
            return true;    // true
        
        // State 2, but not a digit, an exponent or the sentinel
        else
          return false;                      // It is an error, so return false
        
      // At the end of State 1, but it was not a decimal point that ended it; an exponent?  
      } else if (s.charAt(ndx) == 'E' || s.charAt(ndx) == 'e') { // Is it an 'E' or 'e'? If
          return hasUNumberState6(s, ndx+1);           // so, return the State6 method result
        
      // At the end of State 1, not a decimal point or an exponent? The sentinel?
      } else if (ndx + 1 == s.length())              // return, else check for the sentinel, 
          return true;                         // and return true if it is there,
      else                                  // else it is an error and 
        return false;                          // we should return false
    }
    
    // We are at State 0 the next character was not a digit, see if it is a decimal point
    else if (s.charAt(0) >= '.') {                 // If so, then we must transition to
      // State 4                              // State 4 to process any digits after
      if (s.charAt(1) >= '0'&&s.charAt(1) <= '9') {     // the decimal point.  Is there a digit?
        // state 5                            // If so, we need to accept the digit
        ndx++;                              // and set up to skip as many more 
        while (s.charAt(ndx) >= '0'&&s.charAt(ndx) <= '9') ndx++; // digits as can be found.  
                                          // Must be exponent, sentinel, or error.
        if (s.charAt(ndx) == 'E' || s.charAt(ndx) == 'e') {// If 'E' or 'e', then process the
          return hasUNumberState6(s, ndx+1);         // exponent and return what it finds.
        } else if (ndx + 1 == s.length()) 
        return true;    // If sentinel, return true.
        else
          return false;                      // else error and return false.
      }
      // Coming here means that there is no digit before or after the period.
      else
        return false;                        
    }
    // Coming here means the first character is not a digit or a decimal point.
    else
      return false;                          
  }
//UML State Diagrams 

  /**********
   * This is the recognizer for the acceptor above.  The algorithm is the same.  The only 
   * difference is that these methods do not produce a UNumber.  They just return true or false 
   * based on what is found in the input. This method processes the exponent, States 6, 7, and 8.
   * 
   * @param s   The input string to be check to see if it is a UNumber
   * 
   * @paramndx  The index of the location within the string to start the process
   * 
   * @return    The Boolean value of whether or not the input is a valid UNumber
   */
  private static boolean hasUNumberState6(String s, int ndx) {
    /* Write the code here */
    /*
     * This block of code checks if the character is between 0 to 9
     * it returns true if the number is valid otherwise false
     */
    if(s.charAt(ndx) >= '0' && s.charAt(ndx) <= '9') {
        ndx++;//point to next character in input string
        if(ndx + 1 == s.length())//return true if the end of string is reached 
            return true;
        else if (!(s.charAt(ndx) >= '0' && s. charAt(ndx) <= '9'))
            return false;
    }
    /*
     * this block of code checks if the character is + or minus then it should be followed 
     * by a number if it has to be valid number else it would be an invalid number 
     */
    else if(s.charAt(ndx) == '+' || s.charAt(ndx) == '-') {
        ndx++;//point to next character in input string
        if(s.charAt(ndx) >= '0' && s.charAt(ndx) <= '9') {//checks if the character is digit between 0 to 9
            ndx++;//point to next character in input string
            if(ndx + 1 == s.length())//return true if the end of string is reached 
                return true;
            else if (!(s.charAt(ndx) >= '0' && s. charAt(ndx) <= '9'))//checks if the character is digit between 0 to 9
                return false;//returns false if it is not a digit from 0 to 9
        } else 
          return false;//returns false if it is not a digit from 0 to 9
    }
    /*
     * This block of code checks if the characters are digits from 0 to 9
     * if so input is valid number else it is invalid
     * and returns true and false accordingly
     */
    while (s.charAt(ndx) >= '0' && s.charAt(ndx) <= '9') 
      ndx++;//point to next character in input string
    if(ndx + 1 == s.length()) //return true if the end of string is reached 
        return true;//if end of string, returns true 
    else
        return false;//if not end of string, returns false
  }
              
}