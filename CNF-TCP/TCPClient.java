import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
	 public static void main(String[] args) throws Exception{
		 Socket clientSocket = new Socket("localhost",9999);

			DataInputStream dataIn = 
				new DataInputStream(clientSocket.getInputStream());

			DataOutputStream dataOut = 
				new DataOutputStream(clientSocket.getOutputStream());

			BufferedReader br = 
				new BufferedReader(
					new InputStreamReader(System.in));

			String str1="",str2="",ans="",str3="",res="",ch="";
			int x = 0;
			str1 = br.readLine();
			dataOut.writeUTF(str1);
			dataOut.flush();
			while(x < 11){
				

				str2=dataIn.readUTF();
				System.out.println(str2);

				
				ans= br.readLine();
				dataOut.writeUTF(ans);
				dataOut.flush();
				

				x++;
				
			}
			res=dataIn.readUTF();
			System.out.println(res);
			dataOut.close();
			clientSocket.close();
	 }
}
