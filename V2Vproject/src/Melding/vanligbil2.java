package Melding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class vanligbil2 {

	private static Socket socket;
	public static void main(String[] args){
		
		try
		{
			int port1 = 25000;
			int port2 = 26000;
			ServerSocket serverSocket = new ServerSocket(port2);
			System.out.println("The third lastebil listen from the second bil via port 26000");
			
			while(true)
			{
				socket = serverSocket.accept();
				InputStream is	= socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String melding = br.readLine();
				System.out.println("message is recieved :" + melding);
				String returnMessage = "hello from the last one";
				try{
					
				}catch (NumberFormatException e) {
					// TODO: handle exception
					
					returnMessage = "data is not correct format\n" ;
				}// catch
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);
				bw.write(returnMessage);
				System.out.println("answer to the second : " +returnMessage);
				bw.flush();
				
			}// while
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}//finally
		{
			try {
				socket.close();
				
			}catch(Exception e){}//catch
			}//finally
		
		
		
	}//main 
	
	
}
