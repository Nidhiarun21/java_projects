package com.uttara.movieapp;

public class TaskUtil 
{
	
	
	public static boolean validateName(String str)
	{
		if(str.isEmpty())
			return false;
		if(str.trim().equals(""))
			return false;
		if(!Character.isLetter(str.charAt(0)))
			return false;
		if(str.split(" ").length>1)
			return false;
		
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			if(!(Character.isDigit(c)||Character.isLetter(c)))
					return false;
			
		}
		
		return true;
	}
	
	
	public static boolean validateMName(String str)
	{
		if(str.isEmpty()||str.equals(" "))
			return false;
		if(str.trim().equals(""))
			return false;
		if(str.length()>200)
			return false;
		
		
		
		
		return true;
	}
	
	
	
	public static boolean validateDName(String s)
	{
		if(s.isEmpty()||s.equals(" "))
			return false;
		if(s.trim().equals(""))
			return false;
		if(s.length()>200)
			return false;
		
		
		return true;
		
		
	}
	
	
public static boolean validateReview(String g)
{
	if(g.isEmpty()||g.equals(" "))
		return false;
	if(g.trim().equals(""))
		return false;
	if(g.length()>200)
		return false;
	

	return true;
	
}
	
	public static boolean validateRating(int k)
	{
		if(k<=0||k>10)
			return false;
		
		return true;
	}
	
	

}
