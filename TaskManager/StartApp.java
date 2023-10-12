package ProjectB94;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;



public class StartApp 
{
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
       try {
    	   
    	Scanner sc1=new Scanner(System.in);
   		Scanner sc2=new Scanner(System.in);
   		int ch1=0;
   		int ch2=0;

   		Logger.getInstance().log("Starting Task Manager... ");
   		TaskModel model=new TaskModel();
    			
		while(ch1!=5)
					{
					System.out.println("Press 1 to  Create Category");	
					System.out.println("Press 2 to Load Category");
					System.out.println("Press 3 to Search");		
					System.out.println("Press 4 to List");
					System.out.println("Press 5 to Exit");
					String catName = null,taskName,desc,tags,cr_Dt,end_Dt, priority,status;
					
					ch1=sc1.nextInt();
					switch (ch1) {
					case 1:
			
							 System.out.println("creating  category");
							 System.out.println("Enter category name");
							 catName=sc2.nextLine();
							 boolean b=TestUtil.validateName(catName);
							 while(b==false)
							 {
						       System.out.println("cat name must be single word.. enter cat name");
						       catName=sc2.nextLine();
						       b=TestUtil.validateName(catName);
							 }
							
							 if(model.CheckCategoryExists(catName))
							 {
								System.out.println("duplicate not allowed,enter unique cat name");
							 }
							 else
							 {
					inn:	 while(ch1!=7)
									{
								 
										System.out.println("Press 1 to Add a Task");	
										System.out.println("Press 2 to Edit a Task");
										System.out.println("Press 3 to Remove a Task");		
										System.out.println("Press 4 to List the Tasks");
										System.out.println("Press 5 to Search");
										System.out.println("Press 6 to Go back");
										
										ch2=sc1.nextInt();
										switch (ch2) {
										case 1:
											
												Logger.getInstance().log("Starting Task Manager... ");
												System.out.println("enter task name");
												taskName=sc2.nextLine();
												System.out.println("enter description");
												desc =sc2.nextLine();
												System.out.println("enter tags(comma separated)");
												tags =sc2.nextLine();
												System.out.println("enter planned create date (dd/mm/yy)");
												cr_Dt=sc2.nextLine();
												System.out.println("enter planned end date (dd/mm/yy)");
												end_Dt=sc2.nextLine();
												System.out.println("enter priority(1- high to 10-low)");
												priority =sc2.nextLine();
												System.out.println("enter status");
												status =sc2.nextLine();
												
												TaskBean bean=new TaskBean(taskName,desc,tags,status,cr_Dt,end_Dt,priority);
												String result=model.addTask(bean , catName);
												if(result.equals( Constants.success))
												System.out.println("Task "+taskName+"  got added successfully");
												else
													System.out.println("task added failed msg is "+result);
												
										break;
										
										case 2:
												 System.out.println("editing tasks");
							                   	 List<TaskBean> tasks1=model.getTasks(catName);
							                   	 for(int i=0;i<tasks1.size();i++)
							                   	 {
							                   		 System.out.println(tasks1.get(i)+"   "+i);
							                   	 }
							                   	 System.out.println("enter the taskbean to edit");
							                   	 int ch3=sc1.nextInt();
							                   	 TaskBean  v=tasks1.get(ch3);
					                   	 while(ch3!=9)
					                   	 {
					                   		 
						                   		System.out.println("press 1 to edit name");
						                   	    System.out.println("press 2 to edit discription");
						                   		System.out.println("press 3 to edit tags(comma separated)");
						                   		System.out.println("press 4 to edit planned create date (dd/mm/yy)");
						                   		System.out.println("press 5 to edit planned end date (dd/mm/yy)");
						                   		System.out.println("press 6 to edit priority(1- high to 10-low)");
						                   		System.out.println("press 7 to edit status");
						                   		System.out.println("press 8 to go back");
						                   		ch3=sc1.nextInt();
					                   	 switch(ch3)
					                   		 {
					                   	 
					                   		 case 1:
					                   			 
						                   			 System.out.println("enter new name to edit");
						                   			 String taskName1=sc2.nextLine();
						                   			 v.setTaskName(taskName1);
						                   			 model.update(catName,tasks1);
						                   			 
						                   	 break;
					                   			 
					                   		 case 2:
					                   			 
						                   			 System.out.println("enter new desc to edit");
						                   			 String taskDesc1=sc2.nextLine();
						                   			 v.setDesc(taskDesc1);
						                   			 model.update(catName,tasks1);
						                   			 
						                   	break;
					                   			 
					                   		case 3:
						                   			
					                   				 System.out.println("enter new tags(comma separated) to edit");
						                   			 String taskTag1=sc2.nextLine();
						                   			 v.setTags(taskTag1);
						                   			 model.update(catName,tasks1);
						                   			 
						                   	break;
						                   			 
					                   		case 4:
					                  			 
						                   			System.out.println("enter new planned end date  (dd/mm/yy) to edit");
						                  			String cr_Dt1=sc2.nextLine();
						                  			SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
						                  			Date a=sdf2.parse(cr_Dt1);
						                  			v.setCr_Dt(a);
						                  			model.update(catName,tasks1);
						                  			 
						                  	break;
						                  	
					                   		case 5:
						                   			 System.out.println("enter new planned end date  (dd/mm/yy) to edit");
						                   			 String end_Dt1=sc2.nextLine();
						                   			 SimpleDateFormat sdf3=new SimpleDateFormat("dd/MM/yyyy");
						                   			 Date a1=sdf3.parse(end_Dt1);
						                   			 v.setEnd_Dt(a1);
						                   			 model.update(catName,tasks1);
						                   			
						                   	break;
						                   			 
					                   		case 6:
					                   			
						                  			 System.out.println("enter new priority(1- high to 10-low) to edit");
						                  			 int taskpriority1=sc1.nextInt();
						                  			 v.setPriority(taskpriority1);
						                  			 model.update(catName,tasks1);
						                  			
						                  	break;
						                  	
					                   		case 7:
					                   			 
			                   		    	     System.out.println("enter new status to edit");
						                   		 String taskStatus1=sc2.nextLine();
						                   		 v.setStatus(taskStatus1);
						                   		 model.update(catName,tasks1);
						                   			
						                   break;
					                   		 case 8:
					                   			 System.out.println("go back");
					                  			 break;
					                  			 
					                  	   default :  
					                  				 
					                  		   	      System.out.println("option not supported");
					                  		break;
					                   		
					                     	}
					                   	 }
					                   	 	
					                   	 break;
					                   	 
										case 3:
												 System.out.println("remove task");
												 List<TaskBean> tasks2=model.getTasks(catName);
							                   	 for(int i=0;i<tasks2.size();i++)
							                   	 {
							                   		 System.out.println(tasks2.get(i)+"   "+i);
							                   	 }
							                   	 System.out.println("enter the taskbean to remove");
							                   	 int r=sc1.nextInt();
							                   	 tasks2.remove(r);
							                	 model.update(catName,tasks2);
							                   	 System.out.println("list of tasks= "+tasks2);
												
							            break;
							            
					                   case 4:
						                    	
						                    	System.out.println("Listing tasks");
						                    	System.out.println("Press 1 to list tasks by alphabetical listing by name!");
						 						System.out.println("Press 2 to list tasks by due date");
						 						System.out.println("Press 3 to list tasks by created date!");
						 						System.out.println("Press 4 to list tasks by longest time");
						 						int y=sc1.nextInt();
						 						List<TaskBean> list=model.getTasks(catName);
						 						Collections.sort(list,model.getComparator(y));
						 						System.out.println(list);
						 						
					 		           break;
					 					
		                               case 5:
		                            	   
		                            	   
		                            		 System.out.println("enter task to search");
					                         String word=sc2.nextLine();
					                    	 Map<String, List<TaskBean>>occurances=model.findOcc(word,catName);
					                    	 int total=0;
					                    	 for(Entry<String, List<TaskBean>>e:occurances.entrySet())
					                    	 {
					                    		 total=total+e.getValue().size();
					                    		 System.out.println(e.getKey()+" occured "+e.getValue().size());
					                    	 }
					                    	 System.out.println(" total "+total);
					                    	 
					                    		 boolean t1=false;
					                         List<TaskBean> task=model.getTasks(catName);
					                       	 for(int i=0;i<task.size();i++)
					                       	 {
					                       		 System.out.println(task.get(i)+"   "+i);
					                       	 }
					                         int i;
					                    	 for (TaskBean task1 : task) {
												if(task1.getTaskName().equals(word))
												{
												   t1=true;
												}
											   }
					                    	 if(t1==true)
					                    	 {
					                    		 System.out.println("task exists");
					                    	 }
					                    	 else
					                    		 System.out.println("task does not exist");
					                    	 for( i=0;i<task.size();i++)
					                    	 {
					                    		 if(task.toString().contains(word))
					                    		 {
						                    		 System.out.println("present in line "+ i);
						                    		
					                    		 }
					                    		
					                    		 else
					                    		 {
					                    			 continue;
					                    		 }
					                    	 }
					                    	 
					               	 
						               break;
										
					                   case 6:
											 
					                	        System.out.println("go back");
									  break ;
										
					                   default:
												System.out.println("opt not supported");
									  break inn;
										}
									}
									
				
						 }
						break;
							
							
			
							
			         case 2:
					        	 System.out.println("Load  Category");
								 File fa=new File("C:\\Users\\MONIKA\\Desktop\\TaskManager");
						     	 File[] fg=fa.listFiles();
								for (int i = 0; i < fg.length; i++)
								{
									File fl=fg[i];
									if(fl.isFile() && fl.getName().endsWith(".todo") && (fl.isHidden()==false))
									{
											System.out.println(" file num "+i+" "+fl.getName().replace(".todo", ""));
									}
									
								}
								
								System.out.println("choose a number to load category");
							    ch2=sc1.nextInt();
								String CatName1=(fg[ch2].getName().replace(".todo", ""));
								System.out.println(CatName1);
							//	ch2=-1;
							
							   while(ch2 !=7)
								{
									System.out.println("Press 1 to Add a Task");	
									System.out.println("Press 2 to Edit a Task");
									System.out.println("Press 3 to Remove a Task");		
									System.out.println("Press 4 to List the Tasks");
									System.out.println("Press 5 to Search");
									System.out.println("Press 6 to Go back");
									ch2=sc1.nextInt();
									switch (ch2) {
									case 1:
											Logger.getInstance().log("Starting Task Manager... ");
											System.out.println("enter task name");
											taskName=sc2.nextLine();
											System.out.println("enter description");
											desc =sc2.nextLine();
											System.out.println("enter tags(comma separated)");
											tags =sc2.nextLine();
											System.out.println("enter planned create date (dd/mm/yy)");
											cr_Dt=sc2.nextLine();
											System.out.println("enter planned end date (dd/mm/yy)");
											end_Dt=sc2.nextLine();
											System.out.println("enter priority(1- high to 10-low)");
											priority =sc2.nextLine();
											System.out.println("enter status");
											status =sc2.nextLine();
											
											TaskBean bean=new TaskBean(taskName,desc,tags,status,cr_Dt,end_Dt,priority);
											String result=model.addTask(bean , catName);
											if(result.equals( Constants.success))
											System.out.println("Task "+taskName+"  got added successfully");
											else
												System.out.println("task added failed msg is "+result);
											
									break;
									
									case 2:
													
												 System.out.println("editing tasks");
							                   	 List<TaskBean> tasks1=model.getTasks(CatName1);
							                   	 for(int i=0;i<tasks1.size();i++)
							                   	 {
							                   		 System.out.println(i+"   "+tasks1.get(i));
							                   	 }
							                   	 System.out.println("enter the taskbean to edit");
							                   	 int ch3=sc1.nextInt();
							                   	 TaskBean  v=tasks1.get(ch3);
							                   	 while(ch3!=8)
								                 {
								                   	System.out.println("press 1 to edit name");
								                   	System.out.println("press 2 to edit discription");
								                   	System.out.println("press 3 to edit tags(comma separated)");
								                   	System.out.println("press 4 to edit planned create date (dd/mm/yy)");
								                   	System.out.println("press 5 to edit planned end date (dd/mm/yy)");
								                   	System.out.println("press 6 to edit priority(1- high to 10-low)");
								                	System.out.println("press 7 to edit status");
								                	System.out.println("8 to go back");
								                   	ch3=sc1.nextInt();
								                   	switch(ch3)
											       	{
							                   		      case 1:
							                   		    	  
									                   			 System.out.println("enter new name to edit");
									                   			 String taskName1=sc2.nextLine();
									                   			 v.setTaskName(taskName1);
									                   			 model.update(CatName1,tasks1);
									                   			
									                   	  break;
									                   			 
							                   		     case 2:
										                   			 
							                   		    	     System.out.println("enter new desc to edit");
										                   		 String taskDesc1=sc2.nextLine();
										                   		 v.setDesc(taskDesc1);
										                   		 model.update(CatName1,tasks1);
										                   			
										                 break;
							                   			 
							                   		    case 3:
									                   			 System.out.println("enter new tags(comma separated) to edit");
									                   			 String taskTag1=sc2.nextLine();
									                   			 v.setTags(taskTag1);
									                   			 model.update(CatName1,tasks1);
									                   			
									                   	break;
									                   			 
							                   			 
								                   		case 4:
									                  			
								                   			     System.out.println("enter new planned end date  (dd/mm/yy) to edit");
									                  			 String cr_Dt1=sc2.nextLine();
									                  			 SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
									                  			 Date a=sdf2.parse(cr_Dt1);
									                  			 v.setCr_Dt(a);
									                  			 model.update(CatName1,tasks1);
									                  			
									                  	break;
								                   		 
								                   	   case 5:
							                   			 
										                   		 System.out.println("enter new planned end date  (dd/mm/yy) to edit");
									                   			 String end_Dt1=sc2.nextLine();
									                   			 SimpleDateFormat sdf3=new SimpleDateFormat("dd/MM/yyyy");
									                   			 Date a1=sdf3.parse(end_Dt1);
									                   			 v.setEnd_Dt(a1);
									                   			 model.update(CatName1,tasks1);
									                   			
									                  break;
							                   			 
							                   		  case 6:
									                  			 System.out.println("enter new priority(1- high to 10-low) to edit");
									                  			 int taskpriority1=sc1.nextInt();
									                  			 v.setPriority(taskpriority1);
									                  			 model.update(CatName1,tasks1);
									                  			
									                  break;
									                  
							                   		 case 7:
							                   			 
					                   		    	     System.out.println("enter new status to edit");
								                   		 String taskStatus1=sc2.nextLine();
								                   		 v.setStatus(taskStatus1);
								                   		 model.update(CatName1,tasks1);
								                   			
								                   break;
							                   		 case 8:
							                   			 System.out.println("go back");
							                  			 break;
							                  		 default : 
							                  			 
							                  				   System.out.println("option not supported");
							                  				 
							                  		 break;
							                   	}
				                   	 }
			
								break;
									
								case 3:
										
										 System.out.println("remove task");
										 List<TaskBean> tasks2=model.getTasks(CatName1);
					                   	 for(int i=0;i<tasks2.size();i++)
					                   	 {
					                   		 System.out.println(tasks2.get(i)+"   "+i);
					                   	 }
					                   	 System.out.println("enter the taskbean to remove");
					                   	 int r=sc1.nextInt();
					                   	 tasks2.remove(r);
					                	 model.update(CatName1,tasks2);
					                   	 System.out.println("list of tasks= "+tasks2);
								
					            break;
										
								case 4:
										
										    System.out.println("Listing tasks");
										    List<TaskBean>list=model.getTasks(CatName1);
										    for (TaskBean taskBean : list) {
												System.out.println(taskBean );
											}
					 						System.out.println("Press 1 to list tasks by alphabetical listing by name!");
					 						System.out.println("Press 2 to list tasks by due date");
					 						System.out.println("Press 3 to list tasks by created date!");
					 						System.out.println("Press 4 to list tasks by longest time");
					 						int y=sc1.nextInt();
					 						List<TaskBean>list1=model.getTasks(CatName1);
					 						Collections.sort(list1,model.getComparator(y));
					 						System.out.println(list1);
										
								 break;
									 
								case 5:
				                    	 
				                    	 System.out.println("enter task to search");
				                         String word=sc2.nextLine();
				                    	 Map<String, List<TaskBean>>occurances=model.findOcc(word,CatName1);
				                    	 int total=0;
				                    	 for(Entry<String, List<TaskBean>>e:occurances.entrySet())
				                    	 {
				                    		 total=total+e.getValue().size();
				                    		 System.out.println(e.getKey()+" occured "+e.getValue().size());
				                    	 }
				                    	 System.out.println(" total "+total);
				                    	 
				                    		 boolean t1=false;
				                         List<TaskBean> task=model.getTasks(CatName1);
				                       	 for(int i=0;i<task.size();i++)
				                       	 {
				                       		 System.out.println(task.get(i)+"   "+i);
				                       	 }
				                         int i;
				                    	 for (TaskBean task1 : task) {
											if(task1.getTaskName().equals(word))
											{
											   t1=true;
											}
										   }
				                    	 if(t1==true)
				                    	 {
				                    		 System.out.println("task exists");
				                    	 }
				                    	 else
				                    		 System.out.println("task does not exist");
				                    	 for( i=0;i<task.size();i++)
				                    	 {
				                    		
				                    		
				                    		 if(task.toString().contains(word))
				                    		 {
					                    		 System.out.println("present in line "+ i);
					                    		
				                    		 }
				                    		
				                    		 else
				                    		 {
				                    			 continue;
				                    		 }
				                    	 }
				                    	 
				                    	 
				                    	
				                    	 
				                       						
					             break;
									
								case 6:
										
									    System.out.println("go back");
									    break ;
										
								default:
											
									     System.out.println("opt not supported");
											
							    break; 
							    
							    
							    
							    
											
									
				}
						}	
										break;
							
								
			        case 3:
			        	File f1=new File("C:\\Users\\MONIKA\\Desktop\\TaskManager");
			        	 if(f1.isDirectory())
			        	 {
			        		 File[] fa1=f1.listFiles();
			        		 boolean b1=false;
			        	
			        	 System.out.println("enter cat to search");
			        	 System.out.println("enter the catname to search");
			        	 String t=sc2.nextLine();
			        	
			            
			             for (File g :fa1) 
			             {
							if(g.getName().endsWith(".todo"))
							{
							  
								String h=g.getName().replace(".todo", "");
								System.out.println(h);
								if(h.equals(t))
								b1=true;
							}
						  }
			        	 if(b1==true)
			        	 {
			        		 System.out.println("category exists");
			        	 }
			        	 else
			        		 System.out.println("category does not exist");
			        	 }
			        	 else
			        		 System.out.println("not a file");
			        		    						
				   break;
							
			       case 4:
					        	
					    	   System.out.println("Listing tasks");
					           List<String> t11=model.getCategories();
					           for (String task1 : t11)
					           {
					        	   System.out.println(task1 );	
					 		   }
									
				  break;
					        	 
				  case 5:
					        		
					            System.out.println("exited");
				
				  break;
					
				 default:
								
					            System.out.println("option not supported");
				
			     break;
							}
						
										}
							
		}
        catch (Throwable t)
       {
		t.printStackTrace();
	   }

	}
}



