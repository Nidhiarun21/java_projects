package com.uttara.movieapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger 
{

	public static Logger obj=null;
	
	
	public static Logger getInstance()
	{
		if(obj==null)
			obj=new Logger();
		
		return obj;
		
		
	}
	
	
	private Logger()
	{
		
	}
	
	public void log(final String data)
	{
		
		new Thread(new Runnable()
		{
		public void run()
		{
			BufferedWriter bw=null;
			try
			{
				bw=new BufferedWriter(new FileWriter(Constants.LOGPATH,true));
				Date dt=new Date();
				bw.write(dt.toString()+":"+data);
				bw.newLine();
				
				if(Constants.LOOGER_Mode)
					System.out.println(data);
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
