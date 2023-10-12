package com.uttara.movieapp;

public class MovieBean implements Comparable
{
   String movieName;
   String directorName;
   String producerName;
   String reviews;
   int ratings;
   
   
   public MovieBean()
   {
	   
   }


public MovieBean(String movieName, String directorName, String producerName, String reviews, int ratings)
{
	super();
	this.movieName = movieName;
	this.directorName = directorName;
	this.producerName = producerName;
	this.reviews = reviews;
	this.ratings = ratings;
}


public String getMovieName() {
	return movieName;
}


public void setMovieName(String movieName) {
	this.movieName = movieName;
}


public String getDirectorName() {
	return directorName;
}


public void setDirectorName(String directorName) {
	this.directorName = directorName;
}


public String getProducerName() {
	return producerName;
}


public void setProducerName(String producerName) {
	this.producerName = producerName;
}


public String getReviews() {
	return reviews;
}


public void setReviews(String reviews) {
	this.reviews = reviews;
}


public int getRatings() {
	return ratings;
}


public void setRatings(int ratings) {
	this.ratings = ratings;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((directorName == null) ? 0 : directorName.hashCode());
	result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
	result = prime * result + ((producerName == null) ? 0 : producerName.hashCode());
	result = prime * result + ratings;
	result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	MovieBean other = (MovieBean) obj;
	if (directorName == null) {
		if (other.directorName != null)
			return false;
	} else if (!directorName.equals(other.directorName))
		return false;
	if (movieName == null) {
		if (other.movieName != null)
			return false;
	} else if (!movieName.equals(other.movieName))
		return false;
	if (producerName == null) {
		if (other.producerName != null)
			return false;
	} else if (!producerName.equals(other.producerName))
		return false;
	if (ratings != other.ratings)
		return false;
	if (reviews == null) {
		if (other.reviews != null)
			return false;
	} else if (!reviews.equals(other.reviews))
		return false;
	return true;
}


@Override
public String toString() 
{
	
	return movieName+":"+directorName+":"+producerName+":"+reviews+":"+ratings;
}


@Override
public int compareTo(Object o)
{
	if(o instanceof MovieBean)
	{
		MovieBean m=(MovieBean) o;
		
		return (this.movieName.compareTo(m.movieName));
		
	}
	else
	{
		throw new IllegalArgumentException("Type");
	}
	

}
   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
