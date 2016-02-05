import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;


public class Capitalization {
  public static void main(String[] args) throws IOException {


    String line = null;

    StringTokenizer tokens;
    String str = null;
    FileReader in = new FileReader("C:/Users/Dell/Workspaces/Eclipse IDE for Java EE Developers 422/DSModule1/src/input.txt");
    BufferedReader br = new BufferedReader(in);
    System.out.println("After Capitalization");
    try {
    String file1 = "C:/Users/Dell/Workspaces/Eclipse IDE for Java EE Developers 422/DSModule1/src/output.txt";
    File file = new File(file1);

    if (!file.exists()) {
      file.createNewFile();
    }

    FileWriter fw = new FileWriter(file.getAbsoluteFile());
    BufferedWriter bw = new BufferedWriter(fw);
    while ((line = br.readLine())!= null) {
       tokens = new StringTokenizer(line, ".?!",true);
       while (tokens.hasMoreTokens()) {
       str = tokens.nextToken();
       str = str.trim();
       str = str.substring(0, 1).toUpperCase() + str.substring(1);
       System.out.print(str);
       bw.write(str);
     }
    }
    in.close();
    bw.close();
    

  } catch (IOException e) {
  
  e.printStackTrace();
}
}
 
}
