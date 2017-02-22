package Melding;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class lederbil {
private static Socket socket;

	public static void main(String args[]){
		
		try
		{
			String host = "localhost";
			int port = 25000;
			InetAddress address = InetAddress.getByName(host);
			socket = new Socket(address, port);
			
			OutputStream os = socket.getOutputStream();
			
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			String melding = "hello from the other side";
			
			
			String sendMessage = melding + "\n";
			bw.write(sendMessage);
			bw.flush();
			System.out.println("Message sent to the vanligbil: "+sendMessage);
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String message = br.readLine();
			System.out.println("Message received from the vanligbil: " +message);	
			
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