import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;


public class Plagarism {
  List<String> original = new ArrayList<String>();
  List<String> suspected = new ArrayList<String>();
  
  String file1 = "C:/Users/Dell/Workspaces/Eclipse IDE for Java EE Developers 422/Plagarism/src/original.txt";
  String file2 = "C:/Users/Dell/Workspaces/Eclipse IDE for Java EE Developers 422/Plagarism/src/suspected.txt";
  
  int originalWordCount= 0;
  int suspectedWordCount = 0;
  public String readDataFromFile(String fileName) {
    String line = null;
    StringBuffer data = new StringBuffer();
    try {
      BufferedReader br = new BufferedReader(
              new FileReader(fileName));
      
      while((line = br.readLine())!=null) {
        String[] parts = line.split(" ");
        for (String w : parts) {
          if (fileName.equals(file1))
          originalWordCount++;
          else
            suspectedWordCount++;
        }
        data.append(line);
       // System.out.println(data);
      }
      br.close();
    } catch(Exception ex) {
      ex.printStackTrace();
    }

    return data.toString();
  }
  
  public void addData(String fileName,List<String> input) {
    String data = readDataFromFile(fileName);
    StringTokenizer tokens = new StringTokenizer(data, ".");
    while (tokens.hasMoreTokens()) {
      String str = tokens.nextToken();
      input.add(str);
     }
    //System.out.println(input);
  }
  
  public void calculateFrequency() {
    double percent = (suspectedWordCount * 100) / originalWordCount;
    System.out.println("Original Words:- " + originalWordCount);
    System.out.println("Suspected Words:- " + suspectedWordCount);
    System.out.println("Match is :-" + percent + "%");
  }
  public void compareFiles(List<String> input,List<String> input1) {
    int matchedWords = 0;
    ListIterator<String> itr1 = original.listIterator();
    ListIterator<String> itr2 = suspected.listIterator();
    while (itr1.hasNext() || itr2.hasNext()) {
      String s1 = itr1.next();
      String s2 = itr2.next();
      if (s1.equals(s2)) {
        matchedWords++;
      }
    }
  }
  public static void main(String[] args) {
    Plagarism p = new Plagarism();
    p.addData(p.file1,p.original);
    p.addData(p.file2,p.suspected);
    p.compareFiles(p.original, p.suspected);
    p.calculateFrequency();
  }
}
