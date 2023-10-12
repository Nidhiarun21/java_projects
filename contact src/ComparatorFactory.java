package com.uttara.contacts;

import java.util.Comparator;

 class CrtDateComparator implements Comparator<ContactBean>{
	 
	public int compare(ContactBean o1,ContactBean o2)
	{
		
		
		return (o1.getCrtdate().compareTo(o2.getCrtdate()));
	}
	
}
 
 
 class TagsComparator implements Comparator<ContactBean>{
	 
	public int compare(ContactBean o1,ContactBean o2)
	{
		
		
		return o1.getTag().toString().compareTo(o2.getTag().toString());
	}
	
}
 class NameComparator implements Comparator<ContactBean>{
	 
	public int compare(ContactBean o1,ContactBean o2)
	{
		
		
		return o1.getContactName().compareTo(o2.getContactName());
	}
 }
	
	class LengthComparator implements Comparator<ContactBean>{
		 
		public int compare(ContactBean o1,ContactBean o2)
		{
		  return o1.toString().compareTo(o2.toString());
		  
		}
	
     }
 