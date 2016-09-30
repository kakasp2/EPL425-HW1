import java.net.InetAddress;
import java.net.UnknownHostException;

public class User implements Runnable{
	int i=0;

	public void run(){
		int count=0;
		 while(count<800){
			try {
			new Client(InetAddress.getLocalHost(),(int) Thread.currentThread().getId());
			}catch (UnknownHostException e) {
			e.printStackTrace();
			}
			count++;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		
	String[]  s=args[0].split("\\."); 
	Client.ipAddr = new byte[] { (byte)Integer.parseInt(s[0]),(byte)Integer.parseInt(s[1]),(byte)Integer.parseInt(s[2]),(byte)Integer.parseInt(s[3]) };
	Client.port=Integer.parseInt(args[1]);

	User user1=new User();
	Thread u1=new Thread(user1);
	u1.start();

	User user2=new User();
	Thread u2=new Thread(user2);
	u2.start();
	User user3=new User();
	Thread u3=new Thread(user3);
	u3.start();
	
	}

}
