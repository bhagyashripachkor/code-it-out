import java.util.Scanner;


public class DNATest {
  public static void main(String[] args){
    String input = null;
    Scanner in = new Scanner(System.in);
    input = in.nextLine();
    DNA d = new DNA();
    d.complement(input);
    in.close();    
  }
}

import java.util.ArrayList;
import java.util.Collections;


public class DNA {
  ArrayList<String> compl = new ArrayList<String>();
  ArrayList<String> revcompl = new ArrayList<String>();
  ArrayList<String> substrs = new ArrayList<String>();
  ArrayList<Integer> finalsubstrs = new ArrayList<Integer>();

  public void reverse(ArrayList<String> s, String cstr, String input) {
    revcompl = s;
    Collections.reverse(revcompl);
    String revcomp = "";
    for (String st : s)
    {
        revcomp += st;
    }
    substring(revcomp,input);
  }
  
  private void substring(String revcomp, String input) {

    int length = 0,c= 0,i=0,x=1,len=0,flag=0;
    String sub="";
    length = revcomp.length();   
    

    for( c = 0 ; c < length ; c++ )
    {
       for( i = 1 ; i <= length - c ; i++ )
       {
          
          sub = revcomp.substring(c, c+i);
          len=sub.length();
          if (input.contains(sub)) {
            if (len > x) {
              flag = 1;
              substrs.add(sub);
              finalsubstrs.add(sub.length());
            }
          }
          x=len;
       }
    }
    
    if (flag == 0)
      System.out.println("No reverse palindromic substrings available");
    else {
      Collections.sort(finalsubstrs);
      Collections.sort(substrs);
      int size = finalsubstrs.get(finalsubstrs.size()-1);
      for (int m = 0; m < finalsubstrs.size();m++ )
        if (substrs.get(m).length() == size)
          System.out.println(substrs.get(m));
     }
  }

 
  public void complement(String input) {
    
   
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == 'A') {
        
        compl.add("T");
      }
      else if(input.charAt(i) == 'C') {
        compl.add("G");
      }
      else if(input.charAt(i) == 'G') {
        compl.add("C");
      }
      else if(input.charAt(i) == 'T') {
        compl.add("A");
      }
     
    }
    
    String cstr = "";

    for (String s : compl)
    {
        cstr += s;
    }
    
    reverse(compl,cstr,input);
  }
}





