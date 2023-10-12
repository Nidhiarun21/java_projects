package com.uttara.movieapp;

import java.util.Comparator;

public class DirectorNameComparator implements  Comparator<MovieBean>
{

	public int compare(MovieBean o1, MovieBean o2) 
	{
		
		
		
		return  (o1.getDirectorName().compareTo(o2.getDirectorName()));
		
	}

	
	
	
}
