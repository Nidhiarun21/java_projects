package com.uttara.movieapp;

import java.util.Comparator;

public class ReviewComparator implements  Comparator<MovieBean>
{

	
	public int compare(MovieBean o1, MovieBean o2) 
	{
		
		return o1.getReviews().compareTo(o2.getReviews());
		
		
		
	}

	
	
	
}
