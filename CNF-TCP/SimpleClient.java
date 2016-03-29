import java.net.*;
import java.io.*;
class SimpleClient{
	public static void main(String args[])throws Exception{

		Socket clientSocket = new Socket("localhost",9999);

		DataInputStream dataIn = 
			new DataInputStream(clientSocket.getInputStream());

		DataOutputStream dataOut = 
			new DataOutputStream(clientSocket.getOutputStream());

		BufferedReader br = 
			new BufferedReader(
				new InputStreamReader(System.in));

		String str1="",str2="";
		
			str1 = br.readLine();
			dataOut.writeUTF(str1);
			dataOut.flush();

			str2=dataIn.readUTF();
			System.out.println(str2);

		dataOut.close();
		clientSocket.close();
	}
}
