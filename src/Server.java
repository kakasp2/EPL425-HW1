import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

 
public class Server
{
 
    private static Socket socket;
    private static byte[] ipAddr = new byte[] { (byte)192,(byte) 168,(byte) 56,(byte)1};
    private static InetAddress address;
    private static ServerSocket serverSocket ;
    private static int port = 25000;
    private static int payload=(int)(Math.random() *1700)+300;
    private static String message="No message received";
    private static String parts[];
    private static String response;
    private static InputStream inStr;
    private static InputStreamReader isr;
    private static BufferedReader br ;
    
   private static  void sResponse(){
       try{
        OutputStream os = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        parts=message.split(" ");
      
        
        if(parts.length==4){
        	response="Welcome "+parts[3]+payload;
            bw.write(response);
            bw.flush();
            System.out.println("Server said "+response);   
            socket.close();
        }
        
        
        
       }catch(IOException e){
    	   
       }
    }
    
    private static void listener(){
    	try{
	    socket = serverSocket.accept();
	    inStr = socket.getInputStream();
	    isr = new InputStreamReader(inStr);
	    br = new BufferedReader(isr);
	     
	    if(br.ready()){
	       message = br.readLine();
	       System.out.println("Client said: "+message );
	       sResponse();
	    }
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
    
    public static void main(String[] args)
    {
    	try{  
    	address = InetAddress.getByAddress(ipAddr);
		serverSocket = new ServerSocket(port,100000,address);
		}catch (Exception e){
		e.printStackTrace();
		}
        System.out.println("Server Started and listening to the port "+port);
        while(true)           
        	listener();
     
    }
}