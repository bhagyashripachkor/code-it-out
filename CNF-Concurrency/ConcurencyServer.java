
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.*;

public class ConcurencyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listeningSocket = true;

        try {
            serverSocket = new ServerSocket(2343);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 2343");
        }

        while(listeningSocket) {
            Socket clientSocket = serverSocket.accept();
            MyServer mini = new MyServer(clientSocket);
            mini.start();
        }
        serverSocket.close();       
    }
}

class MyServer extends Thread {
    Socket s;

    DataInputStream din;
    DataOutputStream dout;
    BufferedReader br;
    public MyServer(Socket s) {
        this.s = s;
    }

    synchronized public void run() {
        try {
            String str="",str2="",rolltime;

            	Calendar cal = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                din=new DataInputStream(s.getInputStream());
                dout=new DataOutputStream(s.getOutputStream());
                br=new BufferedReader(new InputStreamReader(System.in));
                
                str=din.readUTF();
                System.out.println(str);
                str2=dateFormat.format(cal.getTime());

                dout.writeUTF(str2);
                dout.flush();
                rolltime = din.readUTF();
                String[] sp = rolltime.split("@");
                String[] t = sp[1].split(":");
                int sec = Integer.parseInt(t[2]);
                String msg="";
                if(dateFormat.SECOND_FIELD-sec > 10){
                	msg="TIME OUT";
                	dout.writeUTF(msg);
                    dout.flush();

                }
                else{
                	msg="THANK YOU";
                	dout.writeUTF(msg);
                    dout.flush();

                }

            din.close();
            s.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}