import java.util.Scanner;
import java.util.StringTokenizer;

public class DynamicArrayListTest {
public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    Scanner in = new Scanner(System.in);
    String input1,input2,input3,input4;
    String input5;

    input1 = in.nextLine();
      if (input1.equals("I")) {
        DynamicArrayList<Integer> dl = new DynamicArrayList<Integer>();
       while (!((input2 = in.nextLine()).equals("end"))) {
        StringTokenizer st = new StringTokenizer(input2);
         while (st.hasMoreElements()) {
        input3 = st.nextToken();

        switch(input3) {
          case "add" :  input4 = st.nextToken();
                        dl.addElements(Integer.parseInt(input4));
                        break;
                        
          case "removeElement" :input4 = st.nextToken();
                        dl.remove(Integer.parseInt(input4));
                        break;
                    
          case "read" : input4 = st.nextToken();
                        dl.read(Integer.parseInt(input4));
                        break;
                        
          case "modifyIndex" :input4 = st.nextToken();
                              input5 = st.nextToken();
                              dl.modifyIndex(Integer.parseInt(input4), Integer.parseInt(input5));
                          
                          break;
                          
          case "modifyElement" : input4 = st.nextToken();
                                  input5 = st.nextToken();
                                dl.modify(Integer.parseInt(input4), Integer.parseInt(input5));
                                break;
                          
          case "print" : dl.print();
                         break;
                         
          case "end" : break;
         }
       }
     }
    } else  if (input1.equals("C")) {
      DynamicArrayList<Character> dl = new DynamicArrayList<Character>();
     while (!((input2 = in.nextLine()).equals("end"))) {
      StringTokenizer st = new StringTokenizer(input2);
       while (st.hasMoreElements()) {
      input3 = st.nextToken();

      switch(input3) {
        case "add" :  input4 = st.nextToken();
                      dl.addElements(input4.charAt(0));
                      break;
                      
        case "removeElement" :input4 = st.nextToken();
                      dl.remove(input4.charAt(0));
                      break;
                  
        case "read" : input4 = st.nextToken();
                      dl.read(input4.charAt(0));
                      break;
                      
        case "modifyIndex" :input4 = st.nextToken();
                            input5 = st.nextToken();
                            dl.modifyIndex(input4.charAt(0), input5.charAt(0));
                        
                        break;
                        
        case "modifyElement" : input4 = st.nextToken();
                                input5 = st.nextToken();
                              dl.modify(input4.charAt(0),input5.charAt(0));
                              break;
                        
        case "print" : dl.print();
                       break;
                       
        case "end" : break;
       }
     }
   }
  } else  if (input1.equals("S")) {
    DynamicArrayList<String> dl = new DynamicArrayList<String>();
   while (!((input2 = in.nextLine()).equals("end"))) {
    StringTokenizer st = new StringTokenizer(input2);
     while (st.hasMoreElements()) {
    input3 = st.nextToken();

    switch(input3) {
      case "add" :  input4 = st.nextToken();
                    dl.addElements(input4);
                    break;
                    
      case "removeElement" :input4 = st.nextToken();
                    dl.remove(input4);
                    break;
                
      case "read" : input4 = st.nextToken();
                    dl.read(Integer.parseInt(input4));
                    break;
                    
      case "modifyIndex" :input4 = st.nextToken();
                          input5 = st.nextToken();
                          dl.modifyIndex(Integer.parseInt(input4), input5.toString());
                      
                      break;
                      
      case "modifyElement" : input4 = st.nextToken();
                              input5 = st.nextToken();
                            dl.modify(input4.toString(),input5.toString());
                            break;
                      
      case "print" : dl.print();
                     break;
                     
      case "end" : break;
     }
   }
 }
} else  if (input1.equals("F")) {
  DynamicArrayList<Float> dl = new DynamicArrayList<Float>();
 while (!((input2 = in.nextLine()).equals("end"))) {
  StringTokenizer st = new StringTokenizer(input2);
   while (st.hasMoreElements()) {
  input3 = st.nextToken();

  switch(input3) {
    case "add" :  input4 = st.nextToken();
                  dl.addElements(Float.parseFloat(input4));
                  break;
                  
    case "removeElement" :input4 = st.nextToken();
                  dl.remove(Float.parseFloat(input4));
                  break;
              
    case "read" : input4 = st.nextToken();
                  dl.read(Integer.parseInt(input4));
                  break;
                  
    case "modifyIndex" :input4 = st.nextToken();
                        input5 = st.nextToken();
                        dl.modifyIndex(Integer.parseInt(input4), Float.parseFloat(input4));
                    
                    break;
                    
    case "modifyElement" : input4 = st.nextToken();
                            input5 = st.nextToken();
                          dl.modify(Float.parseFloat(input4),Float.parseFloat(input4));
                          break;
                    
    case "print" : dl.print();
                   break;
                   
    case "end" : break;
   }
 }
}
}
      
      
   }
}
