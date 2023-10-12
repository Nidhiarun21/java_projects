package com.uttara.movieapp;

import java.util.Comparator;

public class RatingComparator implements  Comparator<MovieBean>
{

	
	public int compare(MovieBean o1, MovieBean o2)
	{
		
		return (o1.getRatings()-o2.getRatings());
		
		
		
	}

	
}
