import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

 
public class Client {

 private static Socket socket;
 public static byte[] ipAddr  ;
 public static int port ;
 private static String sendMessage ;
 private static InetAddress address ;
 private OutputStream outMessage ;
 private OutputStreamWriter osw;
 private BufferedWriter bw;

private void sender(InetAddress ip,int id){
	try{
	address = InetAddress.getByAddress(ipAddr);
    socket = new Socket(address, port);	
    outMessage = socket.getOutputStream();
    osw = new OutputStreamWriter(outMessage);
    bw = new BufferedWriter(osw);  

    sendMessage = "Hello "+port+" "+ip+" "+id+" "+"\n";
    bw.write(sendMessage);
    bw.flush();
    System.out.println("Message sent to the server : "+sendMessage);
	}catch(IOException e){
		e.printStackTrace();
	}
	
}
 
 
 Client(InetAddress ip,int id) {
	  sender(ip,id);
     
}
}