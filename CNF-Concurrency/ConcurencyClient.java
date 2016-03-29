
import java.io.*;
import java.net.*;

class ConcurencyClient {
    public static void main(String argv[]) throws Exception {
        Socket s=new Socket("localhost",2343);
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String roll="",str2="",rolltime="",reply="";
        

            roll=br.readLine();
            dout.writeUTF(roll);
            dout.flush();
            str2=din.readUTF();
            System.out.println(str2);
            rolltime = br.readLine();
            dout.writeUTF(rolltime);
            dout.flush();
            reply=din.readUTF();
            System.out.println(reply);
            dout.close();
            s.close();

        dout.close();
        s.close();
    }
}
