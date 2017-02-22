package Melding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class vanligbil {
	private static Socket socket;
	public static void main(String[] args)
	{
		try {
			
			int port1 = 25000;
			ServerSocket serverSocket = new ServerSocket(port1);
			System.out.println("Lastebil listen from lederbil all time via port 25000");
			
			while(true)
			{
				
				socket = serverSocket.accept();
				InputStream is	= socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String melding = br.readLine();
				System.out.println("message is recieved :" + melding);
				String returnMessage = "hello babe";
				try{
					
				}catch (NumberFormatException e) {
					// TODO: handle exception
					
					returnMessage = "data is not correct format\n" ;
				}// catch
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);
				bw.write(returnMessage);
				System.out.println("answer to client:  " +returnMessage);
				bw.flush();
				
				
			}//while
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}//catch1
		finally
		{
			try {
				socket.close();
				
			}catch(Exception e){}//catch
			}//finally
		
		
		
		
		try
		{
			String host = "localhost";
			int port = 26000;
			InetAddress address = InetAddress.getByName(host);
			socket = new Socket(address, port);
			
			OutputStream os = socket.getOutputStream();
			
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			String melding = "hello from the laste lastebil ";
			
			
			String sendMessage = melding + "\n";
			bw.write(sendMessage);
			bw.flush();
			System.out.println("Message sent to the vanligbil3: "+sendMessage);
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String message = br.readLine();
			System.out.println("Message received from the vanligbil3: " +message);	
			
		}
		 catch (Exception exception)
        {
            exception.printStackTrace();
        }// catch 
		 finally
	        {
	            //Closing the socket
	            try
	            {
	                socket.close();
	            }
	            catch(Exception e)
	            {
	                e.printStackTrace();
	            }
	        }// finally

		
		
		
	}//main


}