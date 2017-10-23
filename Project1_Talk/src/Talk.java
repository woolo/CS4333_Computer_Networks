/**
* @author Zimo Chai (Jerry)
* Student ID: 1495687
* Lab Section: 1
* Date: 9/1/2017
* Description: This program is a very basic implementation of client-server communicaton.
*/

import java.io.*;
import java.net.*;

public class Talk {
	public static void main(String[] args) {
		String IP = "localhost";  // localhost is prefered to 127.0.0.1
		int port = 12987; // This is a hardcoded magic number, theoretically, any port number 1024-65535 can be binded without root privilege
		
		/*
		// This following section of code is for debugging use.
		System.out.printf("Input parameters: ");
		for(int i =0; i < args.length; i++){
			System.out.printf(args[i] + " ");
		}
		System.out.printf("\n");
		*/

		if(args.length > 0){
			switch (args[0]){ // This will be the first parameter, which is expected to be a command        	
		        case "-h":
	        		if(args.length == 1){
	        			System.out.printf("Warning: No specified hostname or IPaddress. Will use default hostname: %s\n", IP);
	        			System.out.printf("Warning: No specified port. Will use default port: %d\n", port);
	        		}
	        		else{
	        			if(args[1].charAt(0) == '-'){
	        				if(args[1].equals("-p")){  // -p
	        					System.out.printf("Warning: No specified hostname or IPaddress. Will use default hostname: %s\n", IP);
			        			try{
			        				port = Integer.parseInt(args[2]);
		        				}catch(ArrayIndexOutOfBoundsException e){
		        					//throw new IllegalArgumentException("Error: No specified port. See -help command for how to run this program.\n");
		        					System.out.printf("Error: No specified port. See -help command for how to run this program.\n");
		        					System.exit(-1);
					        	}catch(NumberFormatException e){
					        		//throw new IllegalArgumentException("Error: Invalid expected port number, see details:\n" + e);
					        		System.out.printf("Error: Invalid expected port number.\n");
					        		System.exit(-1);
				        		}
	        				}else{ // eg. -k -wrong
	        					//throw new IllegalArgumentException("Error: Invalid option. See -help command for how to run this program.");
	        					System.out.printf("Error: Invalid option. See -help command for how to run this program.\n");
	        					System.exit(-1);
	        				}	        				
	        			}else{  // IP
	        				IP = args[1];
	        				if (args.length == 2){
	        					System.out.printf("Warning: No specified port. Will use default port: %d\n", port);
	        				}
	        				else if(args.length > 2 & args.length < 5){
	        					if(args[2].equals("-p")){  // -p
				        			try{
				        				port = Integer.parseInt(args[3]);
					        		}catch(ArrayIndexOutOfBoundsException e){
					        			//throw new IllegalArgumentException("Error: No specified port. See -help command for how to run this program.\n");
					        			System.out.printf("Error: No specified port. See -help command for how to run this program.\n");
					        			System.exit(-1);
			        				}catch(NumberFormatException e){
			        					//throw new IllegalArgumentException("Error: Invalid expected port number, see details:\n" + e);
			        					System.out.printf("Error: Invalid expected port number.\n");
			        					System.exit(-1);
					        		}
		        				}else{ // eg. -k -wrong
		        					//throw new IllegalArgumentException("Error: Invalid option. See -help command for how to run this program.");
		        					System.out.printf("Error: Invalid option. See -help command for how to run this program.\n");
		        					System.exit(-1);
		        				}
	        				}
	        				else{  // length != 2 and length != 4
	        					//throw new IllegalArgumentException("Error: Invalid option. See -help command for how to run this program.");
	        					System.out.printf("Error: Invalid option. See -help command for how to run this program.\n");
	        					System.exit(-1);
	        				}
	        			}
	        		}
		        	try{
			        	new TalkClient(IP, port);
		        	}catch(RuntimeException e){
		        		System.out.println(e);
		        		System.exit(-1);
		        	}
		            break;
		        case "-s":
		        	if(args.length == 1){
		        		System.out.printf("Warning: No specified port. Will use default port: %d\n", port);
		        	}
		        	else if(args.length > 1 & args.length < 4){
			        	if (args[1].equals("-p")){
			        		try{
			        			port = Integer.parseInt(args[2]);
			        		}catch(ArrayIndexOutOfBoundsException e){
			        			//throw new IllegalArgumentException("Error: No specified port. See -help command for how to run this program.\n");
			        			System.out.printf("Error: No specified port. See -help command for how to run this program.\n");
			        			System.exit(-1);
			        		}catch(NumberFormatException e){
			        			//throw new IllegalArgumentException("Error: Invalid expected port number, see details:\n" + e);
			        			System.out.printf("Error: Invalid expected port number.\n");
			        			System.exit(-1);
			        		}
			        	}else{
			        		//throw new IllegalArgumentException("Error: Invalid option. See -help command for how to run this program.");
			        		System.out.printf("Error: Invalid option. See -help command for how to run this program.\n");
			        		System.exit(-1);
			        	}
		        	}else{  // when the number of parameter is more than 3
		        		//throw new IllegalArgumentException("Error: Invalid option. See -help command for how to run this program.");
		        		System.out.printf("Error: Invalid option. See -help command for how to run this program.\n");
		        		System.exit(-1);
		        	}
		        	try{
		        		new TalkServer(port);
		        	}catch(RuntimeException e){
		        		System.out.println(e);
		        		System.exit(-1);
		        	}
		            break;
		        case "-a":
	        		if(args.length == 1){
	        			System.out.printf("Warning: No specified hostname or IPaddress. Will use default hostname: %s\n", IP);
	        			System.out.printf("Warning: No specified port. Will use default port: %d\n", port);
	        		}
	        		else{
	        			if(args[1].charAt(0) == '-'){
	        				if(args[1].equals("-p")){  // -p
	        					System.out.printf("Warning: No specified hostname or IPaddress. Will use default hostname: %s\n", IP);
			        			try{
			        				port = Integer.parseInt(args[2]);
		        				}catch(ArrayIndexOutOfBoundsException e){
		        					//throw new IllegalArgumentException("Error: No specified port. See -help command for how to run this program.\n");
		        					System.out.printf("Error: No specified port. See -help command for how to run this program.\n");
		        					System.exit(-1);
					        	}catch(NumberFormatException e){
					        		//throw new IllegalArgumentException("Error: Invalid expected port number, see details:\n" + e);
					        		System.out.printf("Error: Invalid expected port number.\n");
					        		System.exit(-1);
				        		}
	        				}else{ // eg. -k -wrong
	        					//throw new IllegalArgumentException("Error: Invalid option. See -help command for how to run this program.");
	        					System.out.printf("Error: Invalid option. See -help command for how to run this program.\n");
	        					System.exit(-1);
	        				}	        				
	        			}else{  // IP
	        				IP = args[1];
	        				if (args.length == 2){
	        					System.out.printf("Warning: No specified port. Will use default port: %d\n", port);
	        				}
	        				else if(args.length > 2 & args.length < 5){
	        					if(args[2].equals("-p")){  // -p
				        			try{
				        				port = Integer.parseInt(args[3]);
					        		}catch(ArrayIndexOutOfBoundsException e){
					        			//throw new IllegalArgumentException("Error: No specified port. See -help command for how to run this program.\n");
					        			System.out.printf("Error: No specified port. See -help command for how to run this program.\n");
					        			System.exit(-1);
			        				}catch(NumberFormatException e){
			        					//throw new IllegalArgumentException("Error: Invalid expected port number, see details:\n" + e);
			        					System.out.printf("Error: No specified port. See -help command for how to run this program.\n");
			        					System.exit(-1);
					        		}
		        				}else{ // eg. -k -wrong
		        					//throw new IllegalArgumentException("Error: Invalid option. See -help command for how to run this program.");
		        					System.out.printf("Error: Invalid option. See -help command for how to run this program.\n");
		        					System.exit(-1);
		        				}
	        				}
	        				else{  // length != 2 and length != 4
	        					//throw new IllegalArgumentException("Error: Invalid option. See -help command for how to run this program.");
	        					System.out.printf("Error: Invalid option. See -help command for how to run this program.\n");
	        					System.exit(-1);
	        				}
	        			}
	        		}
		        	try{ // try run as a client first
		        		System.out.println("Using 'auto' mode, try run as a client first:");
		        		new TalkClient(IP, port);
		        	}catch(RuntimeException e){ // when failed, try run as a server
		        		System.out.println(e);
		        		System.out.println("Warning: Run as an client failed, try run as a server instead:");
		        		try{
		        			new TalkServer(port);
		        		}catch(RuntimeException error){
		        			System.out.println(error);
		        			System.exit(-1);
		        		}
		        	}
		            break;
		        case "-help":
		        	if(args.length > 1){
		        		//throw new IllegalArgumentException("Error: Invalid option. See -help command for how to run this program.");
		        		System.out.printf("Error: Invalid option. See -help command for how to run this program.\n");
		        		System.exit(-1);
		        	}else{
			        	System.out.printf(
			        			"Talk is a little java program written by Zimo Chai (Jerry).\n"
					        	+ "\n"
			        			+ "Usage: Talk [COMMANDS...] [OPTION...]\n"
			        			+ "\n"
			        			+ "COMMANDS:\n"
			        			+ "-h [hostname | IPaddress]                run as a client, use localhost as default if IP is not specified\n"
			        			+ "-s                                       run as a server\n"
			        			+ "-a [hostname | IPaddress]                auto mode, try running as a client first, if failed, run as a server\n"
			        			+ "-help                                    print author name and instructions on how to use this program\n"
			        			+ "\n"
			        			+ "OPTIONS:\n"
			        			+ "-p [portnumber]                          specify a port number to use, use 12987 as default if not specified\n"
			        			+ "\n"
			        			+ "Examples:\n"
			        			+ "-h 129.244.136.36 -p 8788                run as a client, trying to connection to 129.244.136.36:8788\n"
			        			+ "-s 9057                                  run as a server, listening to 9507\n"
			        			);		        		
		        	}
		            break;
		        default: 
		        	//throw new IllegalArgumentException("Error: Invalid command. See -help command for how to run this program.");
		        	System.out.printf("Error: Invalid command. See -help command for how to run this program.\n");
		        	System.exit(-1);
	        }
		}
		else{
			//throw new IllegalArgumentException("Error: No parameters given. See -help command for how to run this program.");
			System.out.printf("Error: No parameters given. See -help command for how to run this program.\n");
			System.exit(-1);
		}
	}
	
	public static class TalkClient{
		public TalkClient(String IP, int port){
			System.out.println("Starting TalkClient...");
			String serverName= IP;	
			int serverPortNumber= port;	
			String message=null;    
			try{       
				Socket socket = new Socket(serverName, serverPortNumber); // Create socket connection	

				BufferedReader inFromLocal =new BufferedReader(new InputStreamReader(System.in)); // Get the input by user typed on screen
				BufferedReader inFromRemote = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Get the input from the socket (server)
		       	PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		       	while(true){
		       		   if (inFromLocal.ready()){
		       				message = inFromLocal.readLine();
		       				if(message.equals("STATUS")){
		       					System.out.printf("[System] CONNECTION STATUS is as follows:\n"
		       							+ "[System] Local IP: %s, Local port %d\n"
		       							+ "[System] Remote IP: %s, Remote port %d\n"
		       							, socket.getLocalAddress(), socket.getLocalPort(), socket.getInetAddress(), socket.getPort());
		       				}else{
			       				out.println(message);			       					
		       				}
		       		   }
					   if (inFromRemote.ready()) {
						   message= "[remote] " + inFromRemote.readLine();
						   System.out.println(message);
					   }
		       	}
		     } catch (UnknownHostException e) {
		    	 throw new java.lang.RuntimeException("Error: Client unable to communicate with server, see details:\n"
								+ "Unknown host:" + serverName);
		     } catch  (IOException e) {
		    	 throw new java.lang.RuntimeException("Error: Client unable to communicate with server, see details:\n"
								+ "No I/O");
		     }
		}
	}
	
	public static class TalkServer{
		public TalkServer(int port){
			System.out.println("Starting TalkServer...");
			
			BufferedReader inFromLocal=null;
			BufferedReader inFromRemote=null;
			PrintWriter out=null;
			
			int serverPortNumber= port;
			String message=null;
			Socket client=null;
			ServerSocket server=null;
			try{
				server= new ServerSocket(serverPortNumber);
				System.out.println("Server listening on port "+serverPortNumber);
			}catch (IOException e){
				throw new java.lang.RuntimeException("Error: Server unable to listen on specified port, see details:\n"
						+ "Could not listen on port "+serverPortNumber);
			}
			try{
				client=server.accept();
				System.out.println("Server accepted connection from "+client.getInetAddress());
			}catch (IOException e){
				throw new java.lang.RuntimeException("Error: Server unable to listen on specified port, see details:\n"
						+ "Accept failed on port "+ serverPortNumber);
			}
			try{
				inFromLocal =new BufferedReader(new InputStreamReader(System.in)); // Get the input by user typed on screen
				inFromRemote = new BufferedReader(new InputStreamReader(client.getInputStream())); // Get the input from the socket (user)
				out = new PrintWriter(client.getOutputStream(), true);
			}catch (IOException e){
				throw new java.lang.RuntimeException("Error: Server unable to listen on specified port, see details:\n"
						+ "Couldn't get an inputStream from the client");
			}
			try{
				while(true){
					if (inFromLocal.ready()){  // use .ready() to "inform whether the stream is ready to be read"
						message = inFromLocal.readLine();  // .readLine() is a blocking operation, which means the call does not return something until is read from the input stream    
	       				if(message.equals("STATUS")){
	       					System.out.printf("[System] CONNECTION STATUS is as follows:\n"
	       							+ "[System] Local IP: %s, Local port %d\n"
	       							+ "[System] Remote IP: %s, Remote port %d\n"
	       							, client.getLocalAddress(), client.getLocalPort(), client.getInetAddress(), client.getPort());
	       				}else{
	       					out.println(message);  // we also would like to see what message we send to others, so we print that out, too			       					
	       				}

					}

					if (inFromRemote.ready()) {
						message= "[remote] " + inFromRemote.readLine();
						System.out.println(message);
					}
				}
			}catch (IOException e){
				System.out.println("Read failed");
				System.exit(-1);
			}
		}
	}
}

