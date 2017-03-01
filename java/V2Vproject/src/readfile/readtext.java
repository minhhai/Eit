package readfile;

import java.io.BufferedReader;
import java.io.FileReader;
public class readtext {
	
	private static final String FILENAME = "/Users/haipham/Dropbox/Shared/data.txt"; 
	public static void main(String[] agrs)
	{
		BufferedReader br = null ;
		FileReader     fr = null;
			try {	
				
				fr = new FileReader(FILENAME);
				br = new BufferedReader(fr);
				String  sCurrentLine;
				br = new BufferedReader(new FileReader(FILENAME));
				 while ((sCurrentLine = br.readLine()) != null ){
					 System.out.println(sCurrentLine); 
				 }//while
				
			} catch (Exception e) {
			
				e.printStackTrace();
				
				// TODO: handle exception
			} finally {
				try
				{
					if (br != null)
						br.close();

					if (fr != null)
						fr.close();

				}
				catch(Exception e)
				{
										
					e.printStackTrace();
				}
					
			}//finally	
	}//main

}
