package com.uttara.contacts;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;



public class ContactApp{

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner sc1=new Scanner(System.in);
		Scanner sc2=new Scanner(System.in);

		try
		{
			int ch1=0,ch2=0,ch3=0,ch6=0,ch7=0,ch4=0;
			String contactBookName=null,contactName,petName,tag,email,phno;
			ContactModel model=new ContactModel();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Set<String> petNameSet,tagSet;
			Set<String> emailSet,phnoSet;

			//---------------------------------------------------------------------------------------------------------

		while(ch1!=7)
			{

				System.out.println("Press 1 to create ContactBook");
				System.out.println("Press 2 to Load ContactBook");
				System.out.println("Press 3 to Search ContactsBook");
				System.out.println("Press 4 to List ContactsBook");
				System.out.println("Press 5 for Birthday Remainders");
				System.out.println("Press 6 to Exit");
				System.out.println("enter your choice");
				ch1=sc1.nextInt();
				//**************************************************************************
				switch(ch1)
				{
				case 1:
					System.out.println("Enter the name of Contact Book");
					contactBookName=sc2.nextLine();

					while(!ContactsUtil.validateName(contactBookName))
					{
						System.out.println("contact name muste be sigle word ");
						System.out.println("start with letter");
						System.out.println("only alphanumeric");
						System.out.println("enter proper input");
						contactBookName = sc2.nextLine();
					}

					if(model.checkContactBookExists(contactBookName))
					{
						System.out.println("Enter Unique contact name,Contact book already exists");

					}
					else
					{
						while(ch2!=6)
						{
							System.out.println("Press 1 to add a contact");
							System.out.println("Press 2 to edit  a contact");
							System.out.println("Press 3 to Remove a contact");
							System.out.println("Press 4 to List a contact");
							System.out.println("Press 5 to search a contact");
							System.out.println("Press 6 to go back");
							System.out.println("Enter your choice");
							ch2=sc1.nextInt();

							switch(ch2)
							{
							case 1:System.out.println("Enter unique the contact name");
							contactName=sc2.nextLine();

							System.out.println("enter dob");
							String dob1=sc2.nextLine();
							Date d=sdf.parse(dob1);

							System.out.println("Enter Address(Homenum,street,city,pin)comma separated");
							String add=sc2.nextLine();
							AddressBean ab=new AddressBean(add);

							System.out.println("Enter the petname");
							petName=sc2.nextLine();
							petNameSet= new HashSet<String>();
							String [] sa= petName.split(",");
							for(int i=0;i<sa.length;i++)
							{
								petNameSet.add(sa[i]);
							}

							System.out.println("enter the tag(comma separated");
							tag=sc2.nextLine();
							tagSet=new HashSet<String>();
							String [] sa1= tag.split(",");
							for(int i=0;i<sa1.length;i++)
							{
								tagSet.add(sa1[i]);
							}

							System.out.println("enter the emails(comma separated)");
							email=sc2.nextLine();
							emailSet= new HashSet<String>();
							String [] sa2= email.split(",");
							for(int i=0;i<sa2.length;i++)
							{
								emailSet.add(sa2[i]);
							}

							System.out.println("enter the phone number(comma separated)");
							phno=sc2.nextLine();
							phnoSet= new HashSet<String>();
							String [] sa3= phno.split(",");
							for(int i=0;i<sa3.length;i++)
							{
								phnoSet.add(sa3[i]);
							}

							System.out.println("enter created date");
							String crt=sc2.nextLine();
							Date d1=sdf.parse(crt);
							ContactBean bean=new ContactBean(contactName,d,ab,petNameSet,tagSet,emailSet,phnoSet,d1);
							String result=model.addContact(bean, contactBookName);
							if(result.equals(Constant.SUCCESS ))
								System.out.println("contact"+contactBookName+"got added success");
							else
								System.out.println("Task addtion failed. Msg"+result);
							break;

							case 2:System.out.println("editing the contact");
							List<ContactBean> list=model.getContacts(contactBookName);

							for (int i = 0; i < list.size(); i++) {
								System.out.println(list.get(i)+" "+i);
							}
							System.out.println("Enter the index of file");
							ch4=sc1.nextInt();
							System.out.println("Enter the contactbean to edit");
							ContactBean b=list.get(ch4);
							while(ch4!=9)
							{
								System.out.println("Press 1 to edit a contact name");
								System.out.println("Press 2 to edit dob");
								System.out.println("Press 3 to edit address");
								System.out.println("Press 4 to edit petname");
								System.out.println("Press 5 to edit tag");
								System.out.println("Press 6 to edit email");
								System.out.println("Press 7 to edit phonenumber");
								System.out.println("Press 8 to edit created date");
								System.out.println("Press 9 to go back");
								ch4=sc1.nextInt();
								switch(ch4)
								{
								//++++++++++++++++++++++++++++++++++++++++++++++++++
								case 1:
									System.out.println("editing name...");
									System.out.println("enter the new name ");
									String newName=sc2.nextLine();
									b.setContactName(newName);
									model.update(contactBookName,list);
									break;

								case 2:
									System.out.println("editing dob");
									System.out.println("enter the  new dob in dd/MM/yyyy");
									String date=sc2.nextLine();
									Date d4=sdf.parse(date);
									b.setDob(d4);
									model.update(contactBookName,list);
									break;

								case 3:System.out.println("editing addresss");
								System.out.println("enter the new address(homeNum, street, city,pinCode)in comma separated values");
								String address1= sc2.nextLine();
								AddressBean ab1= new  AddressBean(address1);
								b.setAddr(ab1);
								model.update(contactBookName,list);
								break;

								case 4:System.out.println("editing pet names");
								System.out.println("enter the pet name to edit");
								String newPetName=sc2.nextLine();
								Set<String>Set2=new HashSet<String>();
								Set2.add(newPetName);
								b.setPetname(Set2);
								model.update(contactBookName,list);				  
								break;

								case 5:
									System.out.println("editing tags");
									System.out.println("enter the tags to edit");
									String newTags=sc2.nextLine();
									Set<String>Set1=new HashSet<String>();
									Set1.add(newTags);
									b.setTag(Set1);
									model.update(contactBookName,list);
									break;

								case 6: System.out.println("editing email...");
								System.out.println("enter the new email");
								String newEmail=sc2.nextLine();
								Set<String> s=new HashSet<String>();
								s.add(newEmail);
								b.setEmail(s);
								model.update(contactBookName,list);
								break;

								case 7: System.out.println("editing phone number");
								System.out.println("enter the phone number to be edited");
								String newPhno=sc2.nextLine();
								Set<String> s1=new HashSet<String>();
								s1.add(newPhno);
								b.setPhn(s1);
								model.update(contactBookName,list);
								break;

								case 8:System.out.println("editing created date");
								System.out.println("enter the created date in dd/MM/yyyy");
								String date1=sc2.nextLine();
								Date d5=sdf.parse(date1);
								b.setDob(d5);
								model.update(contactBookName,list);

								default:
									System.out.println("enter the integers between 1-8");
									break;
								}
								//+++++++++++++++++++++++++++++++++++++++++++++++++++++
							}
							break;
							case 3:System.out.println("Removing the contact");
							List<ContactBean> bean3=model.getContacts(contactBookName);
							for(int i=0;i<bean3.size();i++)
							{
								System.out.println(bean3.get(i)+" "+i);
							}
							System.out.println("Enter the contact index to remove");
							int a=sc1.nextInt();
							bean3.remove(a);
							model.update(contactBookName,bean3);
							break;

							case 4:	System.out.println("Listing contacts");

							System.out.println("Press 1 to List contacts by alphabetical listing by name");
							System.out.println("Press 2 to List contacts by alphabetical ordering of tag");
							System.out.println("Press 3 to List contacts by created date");
							System.out.println("Press 4 to List contacts by string length (length of entire line info on contact)");
							int q=sc1.nextInt();

							List<ContactBean>list1=model.getContacts(contactBookName);

							Collections.sort(list1,model.getComparator(q));
							System.out.println(list1);
						   break;

							case 5:	System.out.println("Enter the contact to search");
							
							String tn=sc2.nextLine();
							boolean b2=false;
							List<ContactBean> bean2=model.getContacts(contactBookName);
							for (ContactBean bean4 : bean2) {
								if(bean4.getContactName().equals(tn))
								{
									b2=true;

							}
							}
							if(b2=true)
							{
								System.out.println("Contact exits");
							}
							else
								System.out.println("Contact does not exists");
							System.out.println(" ");
							System.out.println("number of occurence of word");
							File f1=new File("B:\\New folder\\ContactProject");

							System.out.println("enter Contact to search");
							String word=sc2.nextLine();
							model.findOcc(word, contactBookName);
							break;

							case 6:System.out.println("going back");
							break;

							default :System.out.println("enter the integers between 1-6");
							break;


							}
						}
					}
					break;


					//***************************************************************************************
				case 2:System.out.println("loading contBooks");
				File fa=new File("B:\\New folder\\ContactProject");
				File[] fg=fa.listFiles();
				for(int i=0;i<fg.length;i++)
				{
					if(fg[i].getName().endsWith(".txt"))
					System.out.println(fg[i].getName()+"   "+i);
				}
				System.out.println("choose sl no to load contactBook");
				int c1=sc1.nextInt();
				String contacts=fg[c1].getName().replace(".txt","");  		        		

				while(ch6!=6)
				{
					System.out.println("Press 1 to add a contact");
					System.out.println("Press 2 to edit  a contact");
					System.out.println("Press 3 to Remove a contact");
					System.out.println("Press 4 to List a contact");
					System.out.println("Press 5 to search a contact");
					System.out.println("Press 6 to go back");
					System.out.println("Enter your choice");
					ch6=sc1.nextInt();


					switch(ch6)
					{
					case 1:System.out.println("Enter unique the contact name");
					contactName=sc2.nextLine();

					System.out.println("enter dob");
					String dob1=sc2.nextLine();
					Date d=sdf.parse(dob1);

					System.out.println("Enter Address(Homenum,street,city,pin)comma separated");
					String add=sc2.nextLine();
					AddressBean ab=new AddressBean(add);

					System.out.println("Enter the petname");
					petName=sc2.nextLine();
					petNameSet= new HashSet<String>();
					String [] sa= petName.split(",");
					for(int i=0;i<sa.length;i++)
					{
						petNameSet.add(sa[i]);
					}

					System.out.println("enter the tag(comma separated");
					tag=sc2.nextLine();
					tagSet=new HashSet<String>();
					String [] sa1= tag.split(",");
					for(int i=0;i<sa1.length;i++)
					{
						tagSet.add(sa1[i]);
					}

					System.out.println("enter the emails(comma separated)");
					email=sc2.nextLine();
					emailSet= new HashSet<String>();
					String [] sa2= email.split(",");
					for(int i=0;i<sa2.length;i++)
					{
						emailSet.add(sa2[i]);
					}

					System.out.println("enter the phone number(comma separated)");
					phno=sc2.nextLine();
					phnoSet= new HashSet<String>();
					String [] sa3= phno.split(",");
					for(int i=0;i<sa3.length;i++)
					{
						phnoSet.add(sa3[i]);
					}

					System.out.println("enter created date");
					String crt=sc2.nextLine();
					Date d1=sdf.parse(crt);
					ContactBean bean=new ContactBean(contactName,d,ab,petNameSet,tagSet,emailSet,phnoSet,d1);
					String result=model.addContact(bean,contacts);
					if(result.equals(Constant.SUCCESS ))
						System.out.println("contact"+contacts+"got added success");
					else
						System.out.println("Task addtion failed. Msg"+result);
					break;

					case 2:System.out.println("editing the contact");
					List<ContactBean> Set=model.getContacts(contacts);
					for (int i = 0; i < Set.size(); i++) {
						System.out.println(Set.get(i)+" "+i);
					}

					System.out.println("Enter the contactbean to edit");
					ch3=sc1.nextInt();
					ContactBean b=Set.get(ch3);
					while(ch3!=9)
					{
						System.out.println("Press 1 to edit a contact name");
						System.out.println("Press 2 to edit dob");
						System.out.println("Press 3 to edit address");
						System.out.println("Press 4 to edit petname");
						System.out.println("Press 5 to edit tag");
						System.out.println("Press 6 to edit email");
						System.out.println("Press 7 to edit phonenumber");
						System.out.println("Press 8 to edit created date");
						System.out.println("Press 9 to go back");
						ch7=sc1.nextInt();
						switch(ch7)
						{
						case 1:
							System.out.println("editing name...");
							System.out.println("enter the new name ");
							String newName=sc2.nextLine();
							b.setContactName(newName);
							model.update(contacts,Set);
							break;

						case 2:
							System.out.println("editing dob");
							System.out.println("enter the  new dob in dd/MM/yyyy");
							String date=sc2.nextLine();
							Date d4=sdf.parse(date);
							b.setDob(d4);
							model.update(contacts,Set);
							break;

						case 3:System.out.println("editing addresss");
						System.out.println("enter the new address(homeNum, street, city,pinCode)in comma separated values");
						String address1= sc2.nextLine();
						AddressBean ab1= new  AddressBean(address1);
						b.setAddr(ab1);
						model.update(contacts,Set);
						break;

						case 4:System.out.println("editing pet names");
						System.out.println("enter the pet name to edit");
						String newPetName=sc2.nextLine();
						Set<String>Set2=new HashSet<String>();
						Set2.add(newPetName);
						b.setPetname(Set2);
						model.update(contacts,Set);				  
						break;

						case 5:
							System.out.println("editing tags");
							System.out.println("enter the tags to edit");
							String newTags=sc2.nextLine();
							Set<String>Set1=new HashSet<String>();
							Set1.add(newTags);
							b.setTag(Set1);
							model.update(contacts,Set);
							break;

						case 6: System.out.println("editing email...");
						System.out.println("enter the new email");
						String newEmail=sc2.nextLine();
						Set<String> s=new HashSet<String>();
						s.add(newEmail);
						b.setEmail(s);
						model.update(contacts,Set);
						break;

						case 7: System.out.println("editing phone number");
						System.out.println("enter the phone number to be edited");
						String newPhno=sc2.nextLine();
						Set<String> s1=new HashSet<String>();
						s1.add(newPhno);
						b.setPhn(s1);
						model.update(contacts,Set);
						break;

						case 8:System.out.println("editing created date");
						System.out.println("enter the created date in dd/MM/yyyy");
						String date1=sc2.nextLine();
						Date d5=sdf.parse(date1);
						b.setDob(d5);
						model.update(contacts,Set);
						break;
						case 9:System.out.println("going back");
						break;

						default:
							System.out.println("enter the integers between 1-9");
							break;
						}
						break;
					}
					break;
					case 3:System.out.println("Removing the contact");
					List<ContactBean> bean3=model.getContacts(contacts);
					for(int i=0;i<bean3.size();i++)
					{
						System.out.println(bean3.get(i)+" "+i);
					}
					System.out.println("Ebter the contact index to remove");
					int a=sc1.nextInt();
					bean3.remove(a);
					model.update(contacts,bean3);
					break;

					case 4:System.out.println("Listing the Contacts");

					System.out.println("Listing contacts");

					System.out.println("Press 1 to list contacts by alphabetical listing by name");
					System.out.println("Press 2 to list contacts by alphabetical ordering of tag");
					System.out.println("Press 3 to list contacts by created date");
					System.out.println("Press 4 to list contacts by string length (length of entire line info on contact)");
					int q=sc1.nextInt();

					List<ContactBean>list=model.getContacts(contacts);

					Collections.sort(list,model.getComparator(q));
					System.out.println(list);
					break;

					case 5:System.out.println("Enter the contact to search");
					System.out.println(" enter contactname to search ");
					String tn=sc2.nextLine();
					boolean b2=false;
					List<ContactBean> bean2=model.getContacts(contacts);
					for (ContactBean bean4 : bean2) {
						if(bean4.getContactName().equals(tn))
						{
							b2=true;

						}
					}
					if(b2=true)
					{
						System.out.println("Contact exits");
					}
					else
						System.out.println("Contact does not exists");
					System.out.println(" ");
					System.out.println("number of occurence of word");
					File f1=new File("B:\\New folder\\ContactProject");
            
					System.out.println("enter Contact to search");
					String word=sc2.nextLine();
					Map<String,List<ContactBean>>occurances=model.findOcc(word,contacts);
					int total=0;
					for(Entry<String,List<ContactBean>>e:occurances.entrySet())
					{
						total=total+e.getValue().size();
						System.out.println(e.getKey()+"occured"+e.getValue().size());

					}
					System.out.println("total"+total);
					break;

					case 6:System.out.println("going back");
					break;

					default :System.out.println("enter the integers between 1-6");
					break;

					}
				}
				break;
				case 3:
					File f1=new File("B:\\New folder\\ContactProject");
					if(f1.isDirectory())
					{
						File[] fa1=f1.listFiles();
						boolean b1=false;

						System.out.println("enter the file name to be searched");
						String ss=sc2.nextLine();

						for (File g:fa1) 
						{
							if(g.getName().endsWith(".txt"))
							{
								String h=g.getName().replace(".txt","");
								System.out.println(h);
								if(h.equals(ss))
									b1=true;
							}
						}
						if(b1==true)
						{
							System.out.println("contactBook exists");

						}
						else
							System.out.println("contactBook doesn't exists");
					}
					else
						System.out.println("not a file");
					break;

				case 4:
					File fa1=new File("B:\\New folder\\ContactProject");
					File[] fg1=fa1.listFiles();
					for(int i=0;i<fg1.length;i++)
					{
						if(fg1[i].getName().endsWith(".txt"))
						System.out.println(fg1[i].getName());
					}
					break;


				case 5:System.out.println("birthday Reminder");
				File f3=new File("B:\\New folder\\ContactProject");
				if(f3.exists() && f3.isDirectory())
				{
					File[] fa3=f3.listFiles();
					for(int i=0;i<fa3.length;i++)
					{
						if(fa3[i].getName().endsWith(".txt"))
						System.out.println(fa3[i]+" : " +i);
					}
					System.out.println("please choose the contactbook from the list above");
					int ch5=sc1.nextInt();
					System.out.println(" contact book choosen  ="+fa3[ch5]);
					String name2=fa3[ch5].getName().replaceAll(".txt","");
					boolean res=model.birthdayReminder(name2);
					if(res)
					{
						List<ContactBean> bean=model.getContacts(name2);
						System.out.println("birthday reminder of "+bean.get(0));
					}
					else
						System.out.println("no birthday today!!!");

				}

				break;
				case 6:System.out.println("Exited");
				break;
		
				default:System.out.println("Enter numbers between 1-6");
					break;
				} 
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			sc1.close();
			sc2.close();
		}

	}
}
