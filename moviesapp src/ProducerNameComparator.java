package com.uttara.movieapp;

import java.util.Comparator;

public class ProducerNameComparator implements  Comparator<MovieBean>
{

	
	public int compare(MovieBean o1, MovieBean o2) 
	{
		
        return (o1.getProducerName().compareTo(o2.getProducerName()));
		
	}

	
	
	
}
