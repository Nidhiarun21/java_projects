package com.uttara.movieapp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartApp 
{
	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		Scanner sc2=new Scanner(System.in);
		
	
		
		
		int ch1=0,ch2=0;
		
		String moviewishl;
		String movieName,directorName,producerName,reviews;
		
		String nmovieName,ndirectorName,nproducerName,nreviews;
		
		int ratings;
		int nratings;
		
		String search;
		
		List<MovieBean> l1=new ArrayList<MovieBean>();
		List<MovieBean> l2=new ArrayList<MovieBean>();
		
	try
	{
		MovieBean old=null;
		while(ch1!=5)
		{
			System.out.println("Press 1 to Create MovieWishList");
			System.out.println("Press 2 to Load   MovieWishList");
			System.out.println("Press 3 to Search MovieWishList");
			System.out.println("Press 4 to List   MovieWishList");
			System.out.println("Press 5 to Exit");

			
			while(!sc1.hasNextInt())
			{
				System.out.println("Enter Integer Input only");
				sc1.next();
			}
			ch1=sc1.nextInt();
			
			
			Logger.getInstance().log("Choice Entered= "+ch1);
			
			
			switch(ch1)
			{
			
////CASE 1----------------------------------------------------------------------->CREATE			
			case 1:
				
				System.out.println("Enter Name of MovieWishList");
				moviewishl=sc2.nextLine();
				
				while(!TaskUtil.validateName(moviewishl))
				{
					
					System.out.println("Enter MovieWishList name ,Start with alphabets followed by numerics,no special charecter");
					
					moviewishl=sc2.nextLine();
					
				}
				
				//File f=new File("/home/uttara/Desktop/VIKAS/MovieProject/"+moviewishl+".to");
				
				
				if(MovieModel.checkMovieWishListExists(moviewishl))
				{
					System.out.println("Enter A Unique MovieWishList");
					
				}
				else
				{
					
					while(ch2!=6)
					{
						System.out.println("Press 1 to Add    A  Movie");
						System.out.println("Press 2 to Edit   A  Movie");
						System.out.println("Press 3 to Remove A  Movie");
						System.out.println("Press 4 to List   A  Movies");
						System.out.println("Press 5 to Search A  Movie");
						System.out.println("Press 6 to Go Back");
						
						ch2=sc1.nextInt();
						
						while(!sc1.hasNextInt())
						{
							System.out.println("Enter Integer Input only");
							sc1.next();
						}
						ch2=sc1.nextInt();
						
						switch(ch2)
						{
						case 1:
							
							System.out.println("Enter A Movie Name");
							movieName=sc2.nextLine();
							while(!TaskUtil.validateName(movieName))
							{
								System.out.println("Enter Movie Correctly  ");
								movieName=sc2.nextLine();
							}
							
							System.out.println("Enter Movie Director Name");
							directorName=sc2.nextLine();
							
							while(!TaskUtil.validateDName(directorName))
							{
								System.out.println("Enter Director Name, within 200 charecters,only alphabets and numbers ");
								directorName=sc2.nextLine();
							}
							
							System.out.println("Enter Movie Producer Name");
							producerName=sc2.nextLine();
							
							while(!TaskUtil.validateDName(producerName))
							{
								System.out.println("Enter Producer Name, within 200 charecters,only alphabets and numbers  ");
								producerName=sc2.nextLine();
							}
							
							
							System.out.println("Enter Movie Review");
							reviews=sc2.nextLine();
							
							while(!TaskUtil.validateReview(reviews))
							{
								System.out.println("Enter Movie review, within 200 charecters,only alphabets and numbers  ");
								reviews=sc2.nextLine();
							}
							
							
							System.out.println("Enter Movie Rating");
							ratings=sc1.nextInt();
							
							
							
							while(!TaskUtil.validateRating(ratings))
							{
								System.out.println("Enter Movie Rating,Rate the movie according to 1 to 10 ");
								ratings=sc1.nextInt();
							}
							
							MovieBean bean=new MovieBean(movieName,directorName,producerName,reviews,ratings);
							
							String msg=MovieModel.addMovie(bean, moviewishl);
							
							if(msg.equals(Constants.SUCCESS))
							{
								System.out.println("Movie "+movieName+ " added successfully To "+moviewishl+" MovieWishList" );
							}
							
							else
							{
								 System.out.println("Oops theres been a problem Msg is "+msg);
							}
							
							 
							
							break;
							
							
						case 2:
							
							int ch3=0;
							
							System.out.println("Enter A Movie Name To Edit");
							
							movieName=sc2.nextLine();
							while(!TaskUtil.validateName(movieName))
							{
								System.out.println("Enter Movie Correctly  ");
								movieName=sc2.nextLine();
							}
						
							List<MovieBean> bea=MovieModel.getMovies(moviewishl);
							
							
						
							for(MovieBean a:bea)
							{
								if(a.getMovieName().equals(movieName))
								{
							
								    old=a;
									l1.add(old);
								}
								else
								{
									
									l2.add(a);
								}
							}
							
							
							System.out.println("The Movie Details are "+old);
							System.out.println("");
						   	
							while(ch3!=6)
							{
								System.out.println("");
								System.out.println("Press 1 to Change MovieName");
								System.out.println("Press 2 to Change DirectorName");
								System.out.println("Press 3 to Change ProducerName");
								System.out.println("Press 4 to Change Review");
								System.out.println("Press 5 to Change Ratings");
								System.out.println("Press 6 to Go Back");
								
								
								ch3=sc1.nextInt();
								
								while(!sc1.hasNextInt())
								{
									System.out.println("Enter Integer Input only");
									sc1.next();
								}
								ch3=sc1.nextInt();
								
								
								switch(ch3)
								{
								case 1:
									System.out.println("Enter MovieName ");
									nmovieName=sc2.nextLine();
									while(!TaskUtil.validateName(nmovieName))
									{
										System.out.println("Enter Movie Correctly  ");
										nmovieName=sc2.nextLine();
									}
									
									
									
									old.setMovieName(nmovieName);
									break;
								case 2:
									System.out.println("Enter DirectorName");
									ndirectorName=sc2.nextLine();
									
									while(!TaskUtil.validateDName(ndirectorName))
									{
										System.out.println("Enter Director Name, within 200 charecters,only alphabets and numbers ");
										ndirectorName=sc2.nextLine();
									}
									
									
									old.setDirectorName(ndirectorName);
									break;
								case 3:
									System.out.println("Enter ProducerName");
									nproducerName=sc2.nextLine();
									
									while(!TaskUtil.validateDName(nproducerName))
									{
										System.out.println("Enter Producer Name, within 200 charecters,only alphabets and numbers  ");
										nproducerName=sc2.nextLine();
									}
									
									
									old.setProducerName(nproducerName);
									break;
									
								case 4:
									System.out.println("Enter Review");
									nreviews=sc2.nextLine();
									
									while(!TaskUtil.validateReview(nreviews))
									{
										System.out.println("Enter Movie review, within 200 charecters,only alphabets and numbers  ");
										nreviews=sc2.nextLine();
									}
									
									
									old.setReviews(nreviews);
									break;
								case 5:
									System.out.println("Enter Ratings");
									nratings=sc1.nextInt();
									
									while(!TaskUtil.validateRating(nratings))
									{
										System.out.println("Enter Movie Rating,Rate the movie according to 1 to 10 ");
										nratings=sc1.nextInt();
									}
									old.setRatings(nratings);
									break;
									
								case 6:
									break;
									
								}
									
							}
							
							System.out.println("The Edited Movie Details are "+old);
							System.out.println(" ");
							l2.addAll(l1);
							
							MovieModel.update(moviewishl, l2);
							
							l2.clear();
							bea.clear();
							l1.clear();
							
							break;
							
							
						case 3:
							
							System.out.println("Removing");
							System.out.println("");
							    
							    System.out.println("The MovieWishList "+moviewishl+"contains below movies");
							    System.out.println("");

								 List<MovieBean> bea1=MovieModel.getMovies(moviewishl);
									
								    for(MovieBean n:bea1)
								     {
									   System.out.println(n);
								     }
							    
							    
							System.out.println("Choose MovieName To Remove from WishList");
							movieName=sc2.nextLine();
							
							while(!TaskUtil.validateName(movieName))
							{
								System.out.println("Enter Movie Correctly  ");
								movieName=sc2.nextLine();
							}
							
												
							String ms=MovieModel.delete(movieName, moviewishl);
							
							if(ms.equals(Constants.SUCCESS))
							{
								System.out.println("Movie "+movieName+ " Deleted successfully From "+moviewishl+" MovieWishList" );
							}
							
							else
							{
								 System.out.println("Oops theres been a problem Msg is "+ms);
							}
							
							
							
						 break;	
						case 4:
							
							    List<MovieBean> bea11=MovieModel.getMovies(moviewishl);
							
							    System.out.println("The MoviesList contains Below  MovieDetails ");
							    System.out.println("");
							    
							    
							    for(MovieBean n:bea11)
							     {
								   System.out.println("MovieName: "+n.getMovieName()+", DirectorName: "+n.getDirectorName()+", ProducerName :"+n.getProducerName()+", Reviews: "+n.getReviews()+", Ratings: "+n.getRatings());
							     }
			
							
							break;
							
						case 5:
							System.out.println("Enter A Input to Search");
							search=sc2.nextLine();
							
							List<MovieBean> b=MovieModel.search(search, moviewishl);
							
							System.out.println("The Input Word is  found In these below Movies");
							
							for(MovieBean e:b)
							{
								   System.out.println("MovieName: "+e.getMovieName()+", DirectorName: "+e.getDirectorName()+", ProducerName :"+e.getProducerName()+", Reviews: "+e.getReviews()+", Ratings: "+e.getRatings());

							}
							
							
							
							break;
						case 6:
							break;
							
						}
					}
				}
				
				
				break;
				
		////////CASE 2--------------------------------------------------------------------------> LOADING			
				
			case 2:
				int ch5=0;
				
				System.out.println("Loading the MovieWishList");
				
				
				File fa=new File("/home/uttara/Desktop/VIKAS/MovieProject");
			     
				System.out.println("The MovieWishList is");
				System.out.println("");
				
				File [] fs=fa.listFiles();
				
				for(File fd:fs)
				{
					System.out.println(fd.getName());
					
					
				}
				
				
				System.out.println("Enter any one of MovieWishList Name To perform actions");
				
				moviewishl=sc2.nextLine();
				
				while(!TaskUtil.validateName(moviewishl))
				{
					
					System.out.println("Enter MovieWishList name ,Start with alphabets followed by numerics,no special charecter");
					
					moviewishl=sc2.nextLine();
					
				}
				
				
				
				System.out.println(" ");
				
				
				
				while(ch5!=6)
				{
					System.out.println("Press 1 to Add    A  Movie");
					System.out.println("Press 2 to Edit   A  Movie");
					System.out.println("Press 3 to Remove A  Movie");
					System.out.println("Press 4 to List   A  Movies");
					System.out.println("Press 5 to Search A  Movie");
					System.out.println("Press 6 to Go Back");
					
					ch5=sc1.nextInt();
					
					while(!sc1.hasNextInt())
					{
						System.out.println("Enter Integer Input only");
						sc1.next();
					}
					
					ch5=sc1.nextInt();
					
					switch(ch5)
					{
					case 1:
						
						System.out.println("Enter A Movie Name");
						movieName=sc2.nextLine();
						while(!TaskUtil.validateName(movieName))
						{
							System.out.println("Enter Movie Correctly  ");
							movieName=sc2.nextLine();
						}
						
						System.out.println("Enter Movie Director Name");
						directorName=sc2.nextLine();
						
						while(!TaskUtil.validateDName(directorName))
						{
							System.out.println("Enter Director Name, within 200 charecters,only alphabets and numbers ");
							directorName=sc2.nextLine();
						}
						
						System.out.println("Enter Movie Producer Name");
						producerName=sc2.nextLine();
						
						while(!TaskUtil.validateDName(producerName))
						{
							System.out.println("Enter Producer Name, within 200 charecters,only alphabets and numbers  ");
							producerName=sc2.nextLine();
						}
						
						
						System.out.println("Enter Movie Review");
						reviews=sc2.nextLine();
						
						while(!TaskUtil.validateReview(reviews))
						{
							System.out.println("Enter Movie review, within 200 charecters,only alphabets and numbers  ");
							reviews=sc2.nextLine();
						}
						
						
						System.out.println("Enter Movie Rating");
						ratings=sc1.nextInt();
						
						while(!TaskUtil.validateRating(ratings))
						{
							System.out.println("Enter Movie Rating,Rate the movie according to 1 to 10 ");
							ratings=sc1.nextInt();
						}
						
						MovieBean bean=new MovieBean(movieName,directorName,producerName,reviews,ratings);
						
						String msg=MovieModel.addMovie(bean, moviewishl);
						
						if(msg.equals(Constants.SUCCESS))
						{
							System.out.println("Movie "+movieName+ " added successfully To "+moviewishl+" MovieWishList" );
						}
						
						else
						{
							 System.out.println("Oops theres been a problem Msg is "+msg);
						}
						
						 
						
						break;
						
						
					case 2:
						
						int ch6=0;
					
						
						System.out.println("Enter A Movie Name To Edit");
						
						movieName=sc2.nextLine();
						
						while(!TaskUtil.validateName(movieName))
						{
							System.out.println("Enter MovieName Correctly  ");
							movieName=sc2.nextLine();
						}
					
						List<MovieBean> bea=MovieModel.getMovies(moviewishl);
						
						
					
						for(MovieBean a:bea)
						{
							if(a.getMovieName().equals(movieName))
							{
						
							    old=a;
								l1.add(old);
							}
							else
							{
								
								l2.add(a);
							}
						}
						
						
						System.out.println("The Movie Details are "+old);
					   	
						while(ch6!=6)
							
						{
							System.out.println("");
							System.out.println("Press 1 to Change MovieName");
							System.out.println("Press 2 to Change DirectorName");
							System.out.println("Press 3 to Change ProducerName");
							System.out.println("Press 4 to Change Review");
							System.out.println("Press 5 to Change Ratings");
							System.out.println("Press 6 to Go Back");
							
							
							ch6=sc1.nextInt();
							
							
							while(!sc1.hasNextInt())
							{
								System.out.println("Enter Integer Input only");
								sc1.next();
							}
							ch6=sc1.nextInt();
							
							
							switch(ch6)
							{
							case 1:
								System.out.println("Enter MovieName ");
								nmovieName=sc2.nextLine();
								old.setMovieName(nmovieName);
								break;
							case 2:
								System.out.println("Enter DirectorName");
								ndirectorName=sc2.nextLine();
								old.setDirectorName(ndirectorName);
								break;
							case 3:
								System.out.println("Enter ProducerName");
								nproducerName=sc2.nextLine();
								old.setProducerName(nproducerName);
								break;
								
							case 4:
								System.out.println("Enter Review");
								nreviews=sc2.nextLine();
								old.setReviews(nreviews);
								break;
							case 5:
								System.out.println("Enter Ratings");
								nratings=sc1.nextInt();
								old.setRatings(nratings);
								break;
								
							case 6:
								break;
								
							}
								
						}
						
						System.out.println(old);
						l2.addAll(l1);
						
						MovieModel.update(moviewishl, l2);
						
						l2.clear();
						bea.clear();
						l1.clear();
						
						break;
						
						
					case 3:
						
						    
						    System.out.println("The MovieWishList "+moviewishl+"contains below movies");

							 List<MovieBean> bea1=MovieModel.getMovies(moviewishl);
								
							    for(MovieBean n:bea1)
							     {
								   System.out.println(n);
							     }
						    
						    
						System.out.println("Enter MovieName To Remove");
						movieName=sc2.nextLine();
						
						while(!TaskUtil.validateName(movieName))
						{
							System.out.println("Enter Movie Correctly  ");
							movieName=sc2.nextLine();
							
						}
						

						
						
											
						String ms=MovieModel.delete(movieName, moviewishl);
						
						if(ms.equals(Constants.SUCCESS))
						{
							System.out.println("Movie "+movieName+ " Deleted successfully From "+moviewishl+" MovieWishList" );
						}
						
						else
						{
							 System.out.println("Oops theres been a problem Msg is "+ms);
						}
						
						
						
						
						
					 break;	
					case 4:
						
                         System.out.println("Listing the Movies in "+moviewishl);
						
						    List<MovieBean> bea11=MovieModel.getMovies(moviewishl);
						
						    System.out.println("The Movies Are");
						    System.out.println("");
						    
						    
						    for(MovieBean n:bea11)
						     {
							   System.out.println("MovieName: "+n.getMovieName()+" DirectorName: "+n.getDirectorName()+", ProducerName :"+n.getProducerName()+", Reviews: "+n.getReviews()+", Ratings: "+n.getRatings());
						     }
		
						
						break;
						
					case 5:
						System.out.println("Enter A Input to Search");
						search=sc2.nextLine();
						
						List<MovieBean> b=MovieModel.search(search, moviewishl);
						
						System.out.println("The Input Search Word is  Found In these Movies");
						
						for(MovieBean e:b)
						{
							   System.out.println("MovieName: "+e.getMovieName()+", DirectorName: "+e.getDirectorName()+", ProducerName :"+e.getProducerName()+", Reviews: "+e.getReviews()+", Ratings: "+e.getRatings());

						}
						
						
						
						break;
					case 6:
						break;
						
						
						
					}
				}
					break;
				
////////CASE 3------------------------------------------------------------------>SEARCH	
				
			case 3:
				
				System.out.println("Enter A word To Search");
				String word=sc2.nextLine();
				
				File fa1=new File("/home/uttara/Desktop/VIKAS/MovieProject");
			     
				System.out.println("");
				
				System.out.println("The MovieWishList are");
				System.out.println("");
				
				File [] fs1=fa1.listFiles();
				
				for(File fd:fs1)
				{
					System.out.println(fd.getName());
					
					
				}
				
				System.out.println("");
				
				
				System.out.println("Enter MovieWishListName To search given Word");
				moviewishl=sc2.nextLine();
				
				
				int totalNoOfOcc=MovieModel.totalNoOfOcc(word, moviewishl);
				
				System.out.println("Total No Of Occurances of Word "+word+"="+totalNoOfOcc);
				
				int noOfoccInMov=MovieModel.noOfOccInMovieNames(word, moviewishl);
				
				System.out.println("Total No Of Occurances of Word In MovieNames "+word+"="+noOfoccInMov);
				
				int occ2=MovieModel.noOfOccInDirNames(word, moviewishl);
				
				System.out.println("Total No Of Occurances of Word In DirectorNames "+word+"="+occ2);
				
				int occ3=MovieModel.noOfOccInProNames(word, moviewishl);
				
				System.out.println("Total No Of Occurances of Word In ProducerNames "+word+"="+occ3);
				
				int occ4=MovieModel.noOfOccInReviews(word, moviewishl);
				
				System.out.println("Total No Of Occurances of Word In Reviews "+word+"="+occ4);
				
				
				break;
				
///CASE 4------------------------------------------------------------------------------->LISTING				
			case 4:
				
				
				
				File fa2=new File("/home/uttara/Desktop/VIKAS/MovieProject");
			     
				System.out.println("");
				
				System.out.println("The MovieWishList are");
				System.out.println("");
				
				File [] fs3=fa2.listFiles();
				
				for(File fd:fs3)
				{
					System.out.println(fd.getName());
					
					
				
				}
				
				System.out.println("Choose MovieWishList Name To List the Contents");
				moviewishl=sc2.nextLine();
				
				
				while(!TaskUtil.validateName(moviewishl))
				{
					
					System.out.println("Enter MovieWishList name ,Start with alphabets followed by numerics,no special charecter");
					
					moviewishl=sc2.nextLine();
					
				}
				
				System.out.println("");
				
				int ch7=0;
				
				while(ch7!=6)
				{
					System.out.println("Press 1 to List moviees by Alphabetical listing by moviename");
					System.out.println("Press 2 to List moviees by Directorname");
					System.out.println("Press 3 to List moviees by Producername");
					System.out.println("Press 4 to List moviees by Review");
					System.out.println("Press 5 to List moviees by Ratings");
					System.out.println("Press 6 to Exit");
					
					
					ch7=sc1.nextInt();
					
					while(!sc1.hasNextInt())
					{
						System.out.println("Enter Integer Input only");
						sc1.next();
					}
					
					ch7=sc1.nextInt();
					
					
					switch(ch7)
					{
					
					case 1:
						System.out.println("Listing Based on MovieName");
						List<MovieBean> mb1=MovieModel.getMovies(moviewishl);
						System.out.println("");
						
						for(MovieBean m:mb1)
						{
							System.out.println("MovieName: "+m.getMovieName()+" DirectorName: "+m.getDirectorName()+" ProducerName: "+m.getProducerName()+" Reviews: "+m.getReviews()+" Ratings: "+m.getRatings());
						}
						
						break;
					case 2:
						System.out.println("Listing Based on DirectorName");
						List<MovieBean> mb2=MovieModel.getMoviesBasedOnDirectorName(moviewishl);
						System.out.println("");
						for(MovieBean m:mb2)
						{
							System.out.println("MovieName: "+m.getMovieName()+" DirectorName: "+m.getDirectorName()+" ProducerName: "+m.getProducerName()+" Reviews: "+m.getReviews()+" Ratings: "+m.getRatings());
						}
						
						break;
					case 3:
						System.out.println("Listing Based on ProducerName");
						List<MovieBean> mb3=MovieModel.getMoviesBasedOnProducerName(moviewishl);
						System.out.println("");
						for(MovieBean m:mb3)
						{
							System.out.println("MovieName: "+m.getMovieName()+" DirectorName: "+m.getDirectorName()+" ProducerName: "+m.getProducerName()+" Reviews: "+m.getReviews()+" Ratings: "+m.getRatings());
						}
						
						break;
					case 4:
						System.out.println("Listing Based on Reviews");
						List<MovieBean> mb4=MovieModel.getMoviesBasedOnReviews(moviewishl);
						System.out.println("");
						for(MovieBean m:mb4)
						{
							System.out.println("MovieName: "+m.getMovieName()+" DirectorName: "+m.getDirectorName()+" ProducerName: "+m.getProducerName()+" Reviews: "+m.getReviews()+" Ratings: "+m.getRatings());
						}
						
						break;
					case 5:
						System.out.println("Listing Based on Ratings");
						List<MovieBean> mb5=MovieModel.getMoviesBasedOnRating(moviewishl);
						System.out.println("");
						for(MovieBean m:mb5)
						{
							System.out.println("MovieName: "+m.getMovieName()+" DirectorName: "+m.getDirectorName()+" ProducerName: "+m.getProducerName()+" Reviews: "+m.getReviews()+" Ratings: "+m.getRatings());
						}
						
						break;
				
					case 6:
						break;
					
					
					
					
					
					
					
					
					
					
					}
					
					
				}
					
				break;
/////CASE 5-------------------------------------------------------------------------------->EXIT				
			case 5:
				break;
				
				
				
			}
			
			
		}
		
		
		
	}
	
	
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	finally
	{
		sc1.close();
		sc2.close();
	}
	
	
	
	}

}
