/*
Operation requirements
RReceiveUDP
1. Should print an initial message indicating the local IP, the ARQ algorithm (indicating the value of
n if appropriate) in use and the UDP port where the connection is expected.
2. Upon successful initial connection from a sender, a line should be printed indicating IP address
and port used by the sender.
3. For each received message print its sequence number and number of data bytes
4. For each ACK sent to the sender, print a message indicating which sequence number is being
acknowledged
5. Upon successful file reception, print a line indicating how many messages/bytes were received
and how long it took.
 * 
 */
package edu.utulsa.unet;
public interface RReceiveUDPI {
	public boolean setMode(int mode);
	public int getMode();
	public boolean setModeParameter(long n);
	public long getModeParameter();
	public void setFilename(String fname);
	public String getFilename();
	public boolean setLocalPort(int port);
	public int getLocalPort();
	public boolean receiveFile();
}

public class RReceiveUD {

}
