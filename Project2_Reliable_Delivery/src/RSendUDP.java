/*
Operation requirements
RSendUDP
1. Should print an initial message indicating the local IP, the ARQ algorithm (indicating the value of
n if appropriate) in use and the local source UDP port used by the sender.
2. Upon successful initial connection, a line should be printed indicating address and port used by
the receiver.
3. For each sent message print the message sequence number and number of data bytes in the message
4. For each received ACK print a message indicating which sequence number is being acknowledged
5. If a timeout occurs, i.e. an ACK has been delayed or lost, and a message needs to be resent, print
a message indicating this condition
6. Upon successful file transmission, print a line indicating how many bytes were sent and how long
it took.
*/

package edu.utulsa.unet;
import java.net.InetSocketAddress;

public interface RSendUDPI {
	public boolean setMode(int mode);
	public int getMode();
	public boolean setModeParameter(long n);
	public long getModeParameter();
	public void setFilename(String fname);
	public String getFilename();
	public boolean setTimeout(long timeout);
	public long getTimeout();
	public boolean setLocalPort(int port);
	public int getLocalPort();
	public boolean setReceiver(InetSocketAddress receiver);
	public InetSocketAddress getReceiver();
	public boolean sendFile();
}

/*
The setMode method specifies the algorithm used for reliable delivery where mode is 0 or 1 (to specify
stop-and-wait and sliding window respectively). If the method is not called, the mode should default to
stop-and-wait. Its companion, getMode simply returns an int indicating the mode of operation.

The setModeParameter method is used to indicate the size of the window in bytes for the sliding
window mode. A call to this method when using stop-and-wait should have no effect. The default value
should be 256 for the sliding window algorithm. Hint: your program will have to use this value and the
MTU (max payload size) value to calculate the maximum number of outstanding frames you can send if
using the Sliding Window algorithm. For instance, if the window size is 2400 and the MTU is 20 you
could have up to 120 outstanding frames on the network.

The setFilename method is used to indicate the name of the file that should be sent (when used by the
sender) or the name to give to a received file (when used by the receiver).
The setTimeout method specifies the timeout value in milliseconds. Its default value should be one
second.

A sender uses setReceiver to specify IP address (or fully qualified name) of the receiver and the
remote port number. Similarly, setLocalPort is used to indicate the local port number used by the
host. The sender will send data to the specified IP and port number. The default local port number is 12987
and if an IP address is not specified then the local host is used.

The methods sendFile and receiveFile initiate file transmission and reception respectively.
Methods returning a boolean should return true if the operation succeeded and false otherwise.
*/
public class RSendUDP {

}


