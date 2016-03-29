import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;
class SimpleServer {
	public static void main(String args[])throws Exception {
	// list of roll numbers	
		ArrayList<String> rollnum = new ArrayList<String>();
		for(int i = 0; i < 11; i++){
			String s = "IH2015850"+Integer.toString(i);
			rollnum.add(s);
			s="";
		}

		//server socket 
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

		String str1="",str2="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

			str1=dataIn.readUTF();
			boolean flag = false;
			for (String rno : rollnum) {
	               if(str1.equalsIgnoreCase(rno)){
	            	   str2=dateFormat.format(date);
	            	   flag = true;
	            	   break;
	               }
	            	   
	           }

			if(flag == true)
				str2=dateFormat.format(date);
			else
				str2 = "Roll number not found";
			dataOut.writeUTF(str2);
			dataOut.flush();

		dataIn.close();
		clientSocket.close();
		serverSocket.close();
	}
}