
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

 
public class Server
{
 
    private static Socket socket;
    private static byte[] ipAddr;
    private static InetAddress address;
    private static ServerSocket serverSocket ;
    private static int port = 25000,count=1,sum=0;
    private static int payload=(int)(Math.random() *1700)+300;
    private static String message="No message received";
    private static String parts[];
    private static String response;
    private static InputStream inStr;
    private static InputStreamReader isr;
    private static BufferedReader br ;
    private static long startTime;
    private static long endTime ;
    private static long allTime;
    private static double throughput;    
    private static OperatingSystemMXBean myOsBean= 
            ManagementFactory.getOperatingSystemMXBean();
    private static List<String> list=new ArrayList<String>();
  
    private static  void sResponse(){
       try{
        OutputStream os = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        parts=message.split(" ");
      
        
        
        	response="Welcome "+parts[3]+" "+payload;
            bw.write(response);
            bw.flush();
          
            
            System.out.println("Server said "+response);   
            
            count++;
            socket.close();
      
        

        
       }catch(IOException e){
    	   
       }
    }
    
    private static void listener(){
    	try{
    	startTime = System.currentTimeMillis();
        
	    socket = serverSocket.accept();
	   // System.out.println("s "+startTime+" ");
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
    	String[] s=args[0].split("\\.");
    	ipAddr = new byte[] { (byte)Integer.parseInt(s[0]),(byte)Integer.parseInt(s[1]),(byte)Integer.parseInt(s[2]),(byte)Integer.parseInt(s[3])};
    	address = InetAddress.getByAddress(ipAddr);
		serverSocket = new ServerSocket(port,1000000,address);
		}catch (Exception e){
		e.printStackTrace();
		}
         System.out.println("Server Started and listening to the port "+port);
     
     double load = myOsBean.getSystemLoadAverage();
     OperatingSystemMXBean operatingSystemMXBean ;
     long memory=0;
        while(true){           
        	listener();
          endTime=System.currentTimeMillis();
          allTime=allTime+(endTime-startTime);
           throughput=allTime/count;
           memory =memory+ Runtime.getRuntime().totalMemory() -  Runtime.getRuntime().freeMemory();
           operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
           load=load+     operatingSystemMXBean.getSystemLoadAverage();
          // System.out.println("load "+load);
           System.out.println("memory "+memory);
           System.out.println("Throughput is : "+throughput);
            
        	
      
        }
        
       
          
       
    }
}
