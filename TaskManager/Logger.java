package ProjectB94;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
	
	    private String path="C:\\Users\\MONIKA\\Desktop\\b1.txt";
		private static boolean LOGTOMONITOR = true;
		
		
		private Logger()
		{
			
		}
		
		private static Logger obj = null;
		
		public static Logger getInstance()
		{
			
			if(obj == null)
				obj = new Logger();
			
			return obj;
		}
		
		
		public void log(String data)
		{
			
				new Thread (new Runnable()
						{
					public void run()
					{
						BufferedWriter bw = null;
						Date dt = new Date();
					try
					{
						
					bw = new BufferedWriter(new FileWriter(path,true));
					
					bw.write(dt.toString()+":"+data);
					bw.newLine();
					if(Logger.LOGTOMONITOR==true)
						System.out.println("msg  "+dt.toString()+":"+data);
						
				}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(bw!=null)
					try 
				{
						bw.close();
			    } 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
					}
						}).start();
				}
	}


