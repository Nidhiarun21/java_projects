package com.uttara.movieapp;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;



public class MovieModel 
{

	public static boolean checkMovieWishListExists(String moviewl)
	{
		return new File("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewl+".to").exists();
	}
	
	
	
	public static String addMovie(MovieBean movie,String moviewishl)
	{
		
		BufferedWriter bw=null;
		
		try
		{
			bw=new BufferedWriter(new FileWriter("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewishl+".to",true));
			
			
			String line=movie.getMovieName()+":"+movie.directorName+":"+movie.getProducerName()+":"+movie.getReviews()+":"+movie.getRatings();                                                       
			
			bw.write(line);
			bw.newLine();
			
			return Constants.SUCCESS;
		
			
			
		} 
		
		
		
		catch (IOException e) {
			
			e.printStackTrace();
			
			return "Something bad happened in writing to file"+e.getMessage();
			
		}
		
		
		finally
		{
			if(bw!=null)
				try {
					bw.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		}
		
		
		
	}


public static List<MovieBean> getMovies(String moviewishl) 
{
	BufferedReader br=null;
	List<MovieBean> l=new ArrayList<MovieBean>();
	MovieBean b=null;
	try
	{
		
		br=new BufferedReader(new FileReader("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewishl+".to"));
		
		String line="";
		
		while((line=br.readLine())!=null)
		{
			b=new MovieBean();
			String[] sa=line.split(":");
			b.setMovieName(sa[0]);
			b.setDirectorName(sa[1]);
			b.setProducerName(sa[2]);
			b.setReviews(sa[3]);
			b.setRatings(Integer.parseInt(sa[4]));
			
			l.add(b);
			
		}
		Collections.sort(l);
		
		return l;
		
		
	} 
	
	catch (IOException e) 
	{
		e.printStackTrace();
		return null;
	}
	
	finally
	{
		if(br!=null)
			try 
		{
				br.close();
		}
		catch (IOException e) 
		{
				e.printStackTrace();
		}
	}
	
	
	
}

	
	public  static void update(String moviewl,List<MovieBean> bean) 
	{
            BufferedWriter bw=null;
		
		try
		{
			bw=new BufferedWriter(new FileWriter("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewl+".to"));
			
			
			for(MovieBean beanie:bean)
			{
				
		     bw.write(beanie.toString());
		     bw.newLine();
		     bw.flush();
		     
			}
		   
			bw.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(bw!=null)
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}
	
	
	
	/*public static String delete(String movieName,String moviewl)
	{
		BufferedReader br=null;
		BufferedWriter bw=null;
		List<MovieBean> l1=new ArrayList<MovieBean>();
		List<MovieBean> l2=new ArrayList<MovieBean>();
		List<MovieBean> l3=new ArrayList<MovieBean>();
		MovieBean b=null;
		try
		{
			
			bw=new BufferedWriter(new FileWriter("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewl+".to"));
			String line="";
			
			l1=MovieModel.getMovies(moviewl);
			
			for(MovieBean j:l1)
			{
				if(j.getMovieName().equals(movieName))
				{
				l2.add(j);
				}
				else
				{
					l3.add(j);
				}
					
			}
			
			System.out.println(l2);
			System.out.println(l3);
			l1.removeAll(l2);
			
			for(MovieBean a:l3)
			{
				bw.write(a.toString());
				bw.newLine();
				bw.flush();
			}
			
			bw.close();
			
			return Constants.SUCCESS;
			
		} 
		
		
		catch (IOException e) 
		{
			
			e.printStackTrace();
			return "Oops Something Bad Happened"+e.getMessage();
		}
		
		
		finally
		{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			if(bw!=null)
				try {
					bw.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		}
	}*/
	
	
	public static String delete(String movieName,String moviewishl)
	{
		
		BufferedReader br=null;
		BufferedWriter bw=null;
		List<MovieBean> be=new ArrayList<MovieBean>();
		MovieBean m=null;
		try
		{
			br=new BufferedReader(new FileReader("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewishl+".to"));
			String line="";
			while((line=br.readLine())!=null)
			{
				m=new MovieBean();
				String [] sa=line.split(":");
				m.setMovieName(sa[0]);
				m.setDirectorName(sa[1]);
				m.setProducerName(sa[2]);
				m.setReviews(sa[3]);
				m.setRatings(Integer.parseInt(sa[4]));
				be.add(m);
			
			}
			
			
			Iterator<MovieBean> it=be.iterator();
			
			while(it.hasNext())
			{
				if(it.next().getMovieName().equals(movieName))
				it.remove();
				
			}
			
			br.close();
			
			bw=new BufferedWriter(new FileWriter("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewishl+".to"));
			
			for(MovieBean a:be)
			{
				bw.write(a.toString());
				bw.newLine();
				bw.flush();
			}
			
			
			
			bw.close();
			
			
			return Constants.SUCCESS;
			
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
			return "Oops Something bad happened"+e.getMessage();
		}
		
		
		finally
		{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			if(bw!=null)
				try {
					bw.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		}
		
		
		
		
	}
	
	public static List<MovieBean> search(String word,String moviewl)
	{
		BufferedReader br=null;
		List<MovieBean> beans=new ArrayList<MovieBean>();
		MovieBean an=null;
		
		try
		{
			String line="";
		br=new BufferedReader(new FileReader("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewl+".to"));
		
		  an=new MovieBean();
		while((line=br.readLine())!=null)
		{
			
			if(line.contains(word))
			{
				String s[]=line.split(":");
				an.setMovieName(s[0]);
				an.setDirectorName(s[1]);
				an.setProducerName(s[2]);
				an.setReviews(s[3]);
				an.setRatings(Integer.parseInt(s[4]));
				beans.add(an);
			}
			
		}
	    return beans;
			
		} 
		 catch (IOException e)
		   {
			 
			e.printStackTrace();
			return null;
		}
		
		
		
		
		
		finally
		{
			if(br!=null)
				try 
			    {
					br.close();
				} 
			    catch (IOException e) 
			    {
					e.printStackTrace();
				}
		}
		
		
		
		
	}
	
	
	
	public static int totalNoOfOcc(String word,String moviewl)
	{
		BufferedReader br=null;
		
		int totalCount=0;
		int pos=0;
		String line="";
		try
		{
		br=new BufferedReader(new FileReader("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewl+".to"));
		
		
			while((line=br.readLine())!=null)
			{
				String [] q=line.split(":");
				
				for(String g:q)
				{
					while((pos=g.indexOf(word,pos))!=-1)
					{
						totalCount++;
						pos++;
					}
				}
			}
			
			
			
			
		
		return totalCount;
		
		} 
		 
		catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
		finally
		{
			if(br!=null)
				try 
			      {
				br.close();
				  }  
			    catch (IOException e) 
			       {
					
					e.printStackTrace();
				   }
		}
		
		
		
	}
	
	
	
	public static int noOfOccInMovieNames(String word,String moviewl)
	{
         BufferedReader br=null;
		
         
		int totalCount1=0;
	
		int pos1=0;

		
		String line="";
		try
		{
		br=new BufferedReader(new FileReader("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewl+".to"));
		
		
			while((line=br.readLine())!=null)
			{
				String [] q=line.split(":");
				
				
				while((pos1=q[0].indexOf(word,pos1))!=-1)
				{
					totalCount1++;
					pos1++;
					
				}
				
					
			}
			
		
		return totalCount1;
		}
		
		catch (IOException e) 
		{
	    	e.printStackTrace();
	    	return 0;
	    	
		}
		finally
		{
			if(br!=null)
				try 
			    {
					br.close();
				} 
			catch (IOException e) 
			    {
					e.printStackTrace();
				}
		}
		
	}
	
	
	
	public static int noOfOccInDirNames(String word,String moviewl)
	{
         BufferedReader br=null;
		int totalCount2=0;
		int pos2=0;
		String line="";
		try
		{
		br=new BufferedReader(new FileReader("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewl+".to"));
		
		
			while((line=br.readLine())!=null)
			{
				String [] q=line.split(":");
				
				while((pos2=q[1].indexOf(word,pos2))!=-1)
				{
					totalCount2++;
					pos2++;
					
				}
					
			}
			
			
			return totalCount2;
		
		}
		
		catch (IOException e) 
		{
	    	e.printStackTrace();
	    	return 0;
	    	
		}
		finally
		{
			if(br!=null)
				try 
			    {
					br.close();
				} 
			catch (IOException e) 
			    {
					e.printStackTrace();
				}
		}
		
	}
	
	
	public static int noOfOccInProNames(String word,String moviewl)
	{
         BufferedReader br=null;
		
      
		int totalCount3=0;
		int pos3=0;
		
		String line="";
		try
		{
		br=new BufferedReader(new FileReader("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewl+".to"));
		
		
			while((line=br.readLine())!=null)
			{
				String [] q=line.split(":");
				while((pos3=q[2].indexOf(word,pos3))!=-1)
				{
					totalCount3++;
					pos3++;
					
				}

			}
			
			return totalCount3;
			
		
		}
		
		catch (IOException e) 
		{
	    	e.printStackTrace();
	    	return 0;
	    	
		}
		finally
		{
			if(br!=null)
				try 
			    {
					br.close();
				} 
			catch (IOException e) 
			    {
					e.printStackTrace();
				}
		}
		
	}
	
	
	public static int noOfOccInReviews(String word,String moviewl)
	{
         BufferedReader br=null;
		
		int totalCount4=0;

		int pos4=0;
		
		String line="";
		try
		{
		br=new BufferedReader(new FileReader("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewl+".to"));
		
		
			while((line=br.readLine())!=null)
			{
				String [] q=line.split(":");
				

				while((pos4=q[3].indexOf(word,pos4))!=-1)
				{
					totalCount4++;
					pos4++;
					
				}
				
					
			}

			return totalCount4;
		
		}
		
		catch (IOException e) 
		{
	    	e.printStackTrace();
	    	return 0;
	    	
		}
		finally
		{
			if(br!=null)
				try 
			    {
					br.close();
				} 
			catch (IOException e) 
			    {
					e.printStackTrace();
				}
		}
		
	}

	
	
	public static List<MovieBean> getMoviesBasedOnDirectorName(String moviewishl)
	{
		BufferedReader br=null;
		List<MovieBean> l=new ArrayList<MovieBean>();
		MovieBean b=null;
		try
		{
			
			br=new BufferedReader(new FileReader("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewishl+".to"));
			
			String line="";
			
			while((line=br.readLine())!=null)
			{
				b=new MovieBean();
				String[] sa=line.split(":");
				b.setMovieName(sa[0]);
				b.setDirectorName(sa[1]);
				b.setProducerName(sa[2]);
				b.setReviews(sa[3]);
				b.setRatings(Integer.parseInt(sa[4]));
				
				l.add(b);
				
			}
			
			DirectorNameComparator dn=new DirectorNameComparator();
			
			Collections.sort(l, dn);
			return l;
		} 
		
	    catch (IOException e) 
		{
	    	
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(br!=null)
				try 
			    {
					br.close();
				}
			catch (IOException e) 
			   {

					e.printStackTrace();
				}
		}
		
		
	}
	
	
	public static List<MovieBean> getMoviesBasedOnProducerName(String moviewishl)
	{
		BufferedReader br=null;
		List<MovieBean> l=new ArrayList<MovieBean>();
		MovieBean b=null;
		try
		{
			
			br=new BufferedReader(new FileReader("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewishl+".to"));
			
			String line="";
			
			while((line=br.readLine())!=null)
			{
				b=new MovieBean();
				String[] sa=line.split(":");
				b.setMovieName(sa[0]);
				b.setDirectorName(sa[1]);
				b.setProducerName(sa[2]);
				b.setReviews(sa[3]);
				b.setRatings(Integer.parseInt(sa[4]));
				
				l.add(b);
				
			}
			
			ProducerNameComparator pn=new ProducerNameComparator();
			
			Collections.sort(l, pn);
			return l;
		} 
		
	    catch (IOException e) 
		{
	    	
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(br!=null)
				try 
			    {
					br.close();
				}
			catch (IOException e) 
			   {

					e.printStackTrace();
				}
		}
		
		
	}
	
	
	public static List<MovieBean> getMoviesBasedOnReviews(String moviewishl)
	{
		BufferedReader br=null;
		List<MovieBean> l=new ArrayList<MovieBean>();
		MovieBean b=null;
		try
		{
			
			br=new BufferedReader(new FileReader("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewishl+".to"));
			
			String line="";
			
			while((line=br.readLine())!=null)
			{
				b=new MovieBean();
				String[] sa=line.split(":");
				b.setMovieName(sa[0]);
				b.setDirectorName(sa[1]);
				b.setProducerName(sa[2]);
				b.setReviews(sa[3]);
				b.setRatings(Integer.parseInt(sa[4]));
				
				l.add(b);
				
			}
			
			ReviewComparator rr=new ReviewComparator();
			
			Collections.sort(l, rr);
			return l;
		} 
		
	    catch (IOException e) 
		{
	    	
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(br!=null)
				try 
			    {
					br.close();
				}
			catch (IOException e) 
			   {

					e.printStackTrace();
				}
		}
		
		
	}
	
	
	public static List<MovieBean> getMoviesBasedOnRating(String moviewishl)
	{
		BufferedReader br=null;
		List<MovieBean> l=new ArrayList<MovieBean>();
		MovieBean b=null;
		try
		{
			
			br=new BufferedReader(new FileReader("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewishl+".to"));
			
			String line="";
			
			while((line=br.readLine())!=null)
			{
				b=new MovieBean();
				String[] sa=line.split(":");
				b.setMovieName(sa[0]);
				b.setDirectorName(sa[1]);
				b.setProducerName(sa[2]);
				b.setReviews(sa[3]);
				b.setRatings(Integer.parseInt(sa[4]));
				
				l.add(b);
				
			}
			
			RatingComparator rt=new RatingComparator();
			
			Collections.sort(l, rt);
			return l;
		} 
		
	    catch (IOException e) 
		{
	    	
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(br!=null)
				try 
			    {
					br.close();
				}
			catch (IOException e) 
			   {

					e.printStackTrace();
				}
		}
		
		
	}
	
	
}
