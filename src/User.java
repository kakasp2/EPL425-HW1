import java.net.InetAddress;
import java.net.UnknownHostException;

public class User implements Runnable{
	int i=0;

	public void run(){
		int count=0;
		 while(count<300){
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
	
	User user4=new User();
	Thread u4=new Thread(user4);
	u4.start();

	User user5=new User();
	Thread u5=new Thread(user5);
	u5.start();

	User user6=new User();
	Thread u6=new Thread(user6);
	u6.start();

	User user7=new User();
	Thread u7=new Thread(user7);
	u7.start();

	User user8=new User();
	Thread u8=new Thread(user8);
	u8.start();

	User user9=new User();
	Thread u9=new Thread(user9);
	u9.start();

	User user10=new User();
	Thread u10=new Thread(user10);
	u10.start();
	
	/*User user11=new User();
	Thread u11=new Thread(user6);
	u11.start();

	User user12=new User();
	Thread u12=new Thread(user7);
	u12.start();

	User user13=new User();
	Thread u13=new Thread(user8);
	u13.start();

	User user14=new User();
	Thread u14=new Thread(user9);
	u14.start();

	User user15=new User();
	Thread u15=new Thread(user10);
	u15.start();
	
		User user16=new User();
	Thread u16=new Thread(user6);
	u16.start();

	User user17=new User();
	Thread u17=new Thread(user7);
	u17.start();

	User user18=new User();
	Thread u18=new Thread(user8);
	u18.start();

	User user19=new User();
	Thread u19=new Thread(user9);
	u19.start();

	User user20=new User();
	Thread u20=new Thread(user10);
	u20.start();*/
	}

}
