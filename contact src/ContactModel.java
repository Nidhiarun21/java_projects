package com.uttara.contacts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactModel {

	@SuppressWarnings("null")
	public boolean birthdayReminder(String contactBookName) throws ParseException
	{
		
		BufferedReader br=null;
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal=new GregorianCalendar();
		try
		{
			String line;
			br=new BufferedReader(new FileReader(contactBookName+".txt"));
			while((line=br.readLine())!=null)
			{
				String[] sa=line.split(":");
				int currDay = cal.get(Calendar.DAY_OF_MONTH);
				System.out.println(currDay);
				int currMonth=cal.get(Calendar.MONTH)+1;
				System.out.println(currMonth);
				Date date = sdf.parse(sa[1]);
				System.out.println(sa[1]);
				Calendar cal1 = Calendar.getInstance();
				cal.setTime(date);
				int month=cal1.get(Calendar.MONTH)+1;
				System.out.println(month);
				int day=cal1.get(Calendar.DAY_OF_MONTH);
				System.out.println(day);
			
				if(currMonth==month && currDay==day)
				{
					return true;
				}

			}
			return false;
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
		finally
		{
			if(br==null)
				try
			{
					br.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();

			}
		}


	}


	public void update(String contactBookName,Collection<ContactBean> list){

		BufferedWriter bw = null;
		try {


			bw = new BufferedWriter(new FileWriter(contactBookName+".txt"));
			for (ContactBean cont : list) {

				bw.write(cont.toString());
				bw.newLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(bw!=null)
				try
			{
					bw.close();

			}
			catch(IOException e)
			{
				e.printStackTrace();
			}

		}
	}
	
	
	public boolean  checkContactBookExists(String contactBook)
	{
		return new File(contactBook+".txt").exists();
	}
	public boolean checkContactExists(String contactName)
	{
		return true;
	}
	public String addContact(ContactBean contact,String contactBook) 
	{
		BufferedWriter bw = null;
		try
		{
			bw = new BufferedWriter(new FileWriter(contactBook+".txt",true));
			bw.write(contact.toString());
			bw.newLine();
			return Constant.SUCCESS;
		}
		catch(IOException e)
		{
			e.printStackTrace();

			return "print the exception ="+e.getMessage();
		}
		finally
		{
			if(bw!=null)
				try
			{
					bw.close();

			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public List<ContactBean> getContacts(String contactBookName)
	{
		List<ContactBean> beans = new ArrayList<ContactBean>();


		BufferedReader br = null;
		try
		{
			String line;
			br = new BufferedReader(new FileReader(contactBookName+".txt"));
			while((line = br.readLine())!=null)
			{

				String[] sa = line.split(":");
				ContactBean 	bean = new ContactBean(sa[0],sa[1],sa[2],sa[3],sa[4],sa[5],sa[6],sa[7]);
				beans.add(bean);

			}

			return beans;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

		finally {
			if(br!=null)
				try
			{
					br.close();

			}
			catch(IOException e)
			{
				e.printStackTrace();
			}

		}


	}


	public Comparator<ContactBean> getComparator(int q) 
	{
		if(q==1)
			return new NameComparator();

		if(q==2)
			return new TagsComparator();
		if(q==3)
			return new CrtDateComparator();

		return new LengthComparator(); 
	}

	
	public Map<String,List<ContactBean>> findOcc(String word,String contactBookName)
	{
		Map<String,List<ContactBean>>occ=new HashMap<String,List<ContactBean>>();


		List<String> lk=new ArrayList<String>();
		List<String> lk1=new ArrayList<String>();
		List<String> lk2=new ArrayList<String>();
		List<ContactBean>b3=getContacts(contactBookName);
		int count5=0,count1=0,count2=0,count3=0;
		try {
			for(ContactBean b:b3)
			{
				if(b.getContactName().equals(word))
				{

					count5++;
					lk.add(b.getContactName());
				}


				String[] a2=b.getTag().toString().split(",");
				{
					for(String z1:a2)
					{
						if(z1.contains(word))
						{
							count1++;
							lk1.add(b.getContactName()+b.getPhn()+b.getEmail()+z1);
						}
					}
				}



				String[] a3=b.getEmail().toString().split(",");
				{
					for(String z:a3)
					{
						if(z.contains(word))
						{
							count2++;
							lk2.add(b.getContactName()+z);
						}
					}
				}
			}	



			int result=count5+count1+count2;
			System.out.println("total no of occurances=" +result);
			System.out.println("no of occrances in name="+count5);
			System.out.println("no of occrances in email"+count2);
			for(String l1:lk)
			{
				System.out.println(l1);
			}

			System.out.println("no of occurances in phone number is ="+count3);
			System.out.println("no of occrances in tags="+count1);
			for(String lp:lk1)
			{
				System.out.println(lp);
			}


		} catch (Exception e) {

			e.printStackTrace();
		}
		return occ;
	}



}





