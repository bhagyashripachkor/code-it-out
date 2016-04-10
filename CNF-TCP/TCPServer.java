import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class TCPServer {
 public static void main(String[] args) throws IOException{
	 //HashMap<HashMap<String,ArrayList<String>>, String> quiz = new HashMap<HashMap<String,ArrayList<String>>, String>();
	 ArrayList<String> answers = new ArrayList<String>();
	 HashMap<String, ArrayList<String>> questionOption = new HashMap<String, ArrayList<String>>();
	 ArrayList<String> options1 = new ArrayList<String>();
	 ArrayList<String> options2 = new ArrayList<String>();
	 ArrayList<String> options3 = new ArrayList<String>();
	 ArrayList<String> options4 = new ArrayList<String>();
	 ArrayList<String> options5 = new ArrayList<String>();
	 ArrayList<String> options6 = new ArrayList<String>();
	 ArrayList<String> options7 = new ArrayList<String>();
	 ArrayList<String> options8 = new ArrayList<String>();
	 ArrayList<String> options9 = new ArrayList<String>();
	 ArrayList<String> options10 = new ArrayList<String>();
	 //1
	 options1.add("Red");
	 options1.add("Green");
	 options1.add("Blue");
	 options1.add("White");
	 questionOption.put("National colour", options1);
	 answers.add("Red");

	 
	 //2
	 options2.add("Lion");
	 options2.add("Tiger");
	 options2.add("Goat");
	 options2.add("Giraffe");
	 questionOption.put("National animal", options2);	 
	 //quiz.put(questionOption, "Tiger");
	 answers.add("Tiger");

	 
	 //3
	 options3.add("Lotus");
	 options3.add("Rose");
	 options3.add("Lily");
	 options3.add("Jasmine");
	 questionOption.put("National flower", options3);
	 answers.add("Lotus");
	// quiz.put(questionOption, "Lotus");

	 
	 //4
	 options4.add("Delhi");
	 options4.add("Mumbai");
	 options4.add("Pune");
	 options4.add("Chennai");
	 questionOption.put("National capital", options4);
	 answers.add("Delhi");
	 //quiz.put(questionOption, "Delhi");

	 
	 //5
	 options5.add("Parrot");
	 options5.add("Peacock");
	 options5.add("Sparrow");
	 options5.add("Kiwi");
	 questionOption.put("National bird", options5);
	 answers.add("Peacock");
	 //quiz.put(questionOption, "Peacock");

	 
	 //6
	 options6.add("Pav-bhaji");
	 options6.add("Pani-puri");
	 options6.add("Dosa");
	 options6.add("Idli");
	 questionOption.put("National dish", options6);	 
	 answers.add("Dosa");
	 //quiz.put(questionOption, "Dosa");

	 
	//7
		 options7.add("5");
		 options7.add("8");
		 options7.add("4");
		 options7.add("6");
		 questionOption.put("5 + 2 - 1", options7);	 
		// quiz.put(questionOption, "6");
		 answers.add("6");

	 
		//8
		 options8.add("10");
		 options8.add("20");
		 options8.add("30");
		 options8.add("40");
		 questionOption.put("10 * 5 - 10", options8);
		 answers.add("40");
		 //quiz.put(questionOption, "40");

		 
		//9
		 options9.add("0");
		 options9.add("1");
		 options9.add("2");
		 options9.add("3");
		 questionOption.put("4 / 2", options9);	 
		 answers.add("2");
		 //quiz.put(questionOption, "2");

		 
		//10
		 options10.add("45");
		 options10.add("46");
		 options10.add("50");
		 options10.add("55");
		 questionOption.put("11 * 5 - 5", options10);	
		 answers.add("50");
		 //quiz.put(questionOption, "50");

		 
		 ServerSocket serverSocket = new ServerSocket(9999);

			//client socket
			Socket clientSocket = serverSocket.accept();

			DataInputStream dataIn = 
				new DataInputStream(clientSocket.getInputStream());
			DataOutputStream dataOut = 
				new DataOutputStream(clientSocket.getOutputStream());

			BufferedReader br = 
				new BufferedReader(
					new InputStreamReader(System.in));

			String str1="",str2="",str3="",ans="";
			str1=dataIn.readUTF();

			 
			 Set optionSet = questionOption.entrySet();
			 Iterator itrOption = optionSet.iterator();
			 int score = 0;
		 int x = 0;

			 
			 //question sending
			 while(itrOption.hasNext()) {
				   
					Map.Entry me = (Map.Entry)itrOption.next();
					str2 = me.getKey().toString();
	
					str3 = me.getValue().toString();

					dataOut.writeUTF(str2 + " "+ str3);

					dataOut.flush();
					int flag = 0;
					ans=dataIn.readUTF();
					for(String i  : answers) {
						if(ans.equalsIgnoreCase(i)){
							score++;
							
						}
					}
					
					
				 str2 ="";
				 str3="";
				}

			
			 

		 String res= "your score is " + Integer.toString(score);
		 dataOut.writeUTF(res);

			dataOut.flush();
		 dataIn.close();
			clientSocket.close();
			serverSocket.close();
 }
}
