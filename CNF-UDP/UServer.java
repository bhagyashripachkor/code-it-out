import java.io.*; 
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set; 
class UServer {    
	public static void main(String args[]) throws Exception{  
		
		DatagramSocket serverSocket = new DatagramSocket(9876);             
		byte[] receiveData = new byte[1024];             
		byte[] sendData = new byte[1024];    
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		HashMap<String, String> rollNumber = new HashMap<String, String>();
		int records = 0;
		for(int i = 1; i < 11; i++){
			String rno = "IH2015850"+Integer.toString(i);
			//String dt = dateFormat.format(date);
			String dt = "";
			rollNumber.put(rno, dt);
			rno = "";
			dt="";
			records++;
		}

		FileWriter fstream;
	    BufferedWriter out;
	    fstream = new FileWriter("rolllist.txt");
	    out = new BufferedWriter(fstream);
	    
		//@SuppressWarnings("rawtypes")
		Set set = rollNumber.entrySet();
		 //@SuppressWarnings("rawtypes")
		Iterator i = set.iterator();
		 int count = 0;
		 while (i.hasNext() && count < records) {

		        // the key/value pair is stored here in pairs
		        //@SuppressWarnings("unchecked")
				Map.Entry<String, String> pairs = (Entry<String, String>) i.next();
		        //System.out.println(pairs.getKey() + pairs.getValue());

		        // since you only want the value, we only care about pairs.getValue(), which is written to out
		        out.write(pairs.getKey() +  "@" + pairs.getValue());
		        out.newLine();
		        // increment the record count once we have printed to the file
		        count++;
		    }
		    // lastly, close the file and end
		    out.close();
		    
		while(true){                   
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);                   
			serverSocket.receive(receivePacket);                  
			String sentence = new String( receivePacket.getData());
			String[] inp = sentence.split("@");
			System.out.println("RECEIVED: " + inp[0]); 
			System.out.println("RECEIVED: " + inp[1]);
			boolean flag = false;
			for (String name: rollNumber.keySet()){

				String key =name.toString();
				if(key.equals(inp[0])){

					rollNumber.put(inp[0],dateFormat.format(date));
					flag = true;
					break;
				}
			}
			String s="";
			if(flag == true){
				s = inp[0]+ " is set to "+dateFormat.format(date);
				int cnt=0;
				 while (i.hasNext() && cnt < records) {

				        // the key/value pair is stored here in pairs
				        //@SuppressWarnings("unchecked")
						Map.Entry<String, String> pairs = (Entry<String, String>) i.next();
				        //System.out.println(pairs.getKey() + pairs.getValue());

				        // since you only want the value, we only care about pairs.getValue(), which is written to out
				        out.write(pairs.getKey() + "@" +  pairs.getValue());
				        out.newLine();

				        // increment the record count once we have printed to the file
				        cnt++;
				    }
				    // lastly, close the file and end
				    out.close();
			}
			else
				s = "Roll number not found";
			InetAddress IPAddress = receivePacket.getAddress();                   
			int port = receivePacket.getPort();                   
                 
			sendData = s.getBytes();                   
			DatagramPacket sendPacket =                  
					new DatagramPacket(sendData, sendData.length, IPAddress, port);                   
			serverSocket.send(sendPacket);    
			//serverSocket.close();
			} 
		
		} 
	} 