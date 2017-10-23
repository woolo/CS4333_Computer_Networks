import java.net.DatagramPacket;
import edu.utulsa.unet.UDPSocket; 
//import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 *Sample programs to send and receive messages using UDP in Java using DatagramSocket 
 *(the class Java provides for UDP). We demonstrated how to use UDPSocket 
 *(a class that extends DatagramSocket which is contained in the unet.jar file) 
 *and gives the programmer the ability to control packet drop rates and message reordering. 
 */

public class udpsender {
	static final String SERVER = "linux1.ens.utulsa.edu";
	static final int PORT = 32456;

	public static void main(String[] args)
	{
		try {

			byte [] buffer = ("Hello World- or rather Mauricio saying hello through UDP").getBytes();
			UDPSocket socket = new UDPSocket(23456);
			//DatagramSocket socket = new DatagramSocket(23456);
			socket.send(new DatagramPacket(buffer, buffer.length,
 				InetAddress.getByName(SERVER), PORT));
		}
		catch(Exception e){ e.printStackTrace(); }
	}
}
