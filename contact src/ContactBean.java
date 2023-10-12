package com.uttara.contacts;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ContactBean implements Comparable<ContactBean>,Serializable{

	private static final long serialVersionUID = 1L;
private String contactName;
private Date dob;
private AddressBean addr;
private Set<String> petname;
private Set<String> tag;
private Set<String> email;
private Set<String> phn;
private Date crtdate;

SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");

@Override
public String toString() {
	return  contactName+":" + sdf.format(dob) + ":"+ addr + ":"+ petname+ ":" + tag +":"+ email + ":" + phn + ":"+ sdf.format(crtdate);
}



public String getContactName() {
	return contactName;
}
public void setContactName(String contactName) {
	this.contactName = contactName;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public AddressBean getAddr() {
	return addr;
}
public void setAddr(AddressBean addr) {
	this.addr = addr;
}
public Set<String> getPetname() {
	return petname;
}
public void setPetname(Set<String> petname) {
	this.petname = petname;
}
public Set<String> getTag() {
	return tag;
}
public void setTag(Set<String> tag) {
	this.tag = tag;
}
public Set<String> getEmail() {
	return email;
}
public void setEmail(Set<String> email) {
	this.email = email;
}
public Set<String> getPhn() {
	return phn;
}
public void setPhn(Set<String> phn) {
	this.phn = phn;
}
public Date getCrtdate() {
	return crtdate;
}
public void setCrtdate(Date crtdate) {
	this.crtdate = crtdate;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((addr == null) ? 0 : addr.hashCode());
	result = prime * result + ((contactName == null) ? 0 : contactName.hashCode());
	result = prime * result + ((crtdate == null) ? 0 : crtdate.hashCode());
	result = prime * result + ((dob == null) ? 0 : dob.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((petname == null) ? 0 : petname.hashCode());
	result = prime * result + ((phn == null) ? 0 : phn.hashCode());
	result = prime * result + ((tag == null) ? 0 : tag.hashCode());
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
	ContactBean other = (ContactBean) obj;
	if (addr == null) {
		if (other.addr != null)
			return false;
	} else if (!addr.equals(other.addr))
		return false;
	if (contactName == null) {
		if (other.contactName != null)
			return false;
	} else if (!contactName.equals(other.contactName))
		return false;
	if (crtdate == null) {
		if (other.crtdate != null)
			return false;
	} else if (!crtdate.equals(other.crtdate))
		return false;
	if (dob == null) {
		if (other.dob != null)
			return false;
	} else if (!dob.equals(other.dob))
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (petname == null) {
		if (other.petname != null)
			return false;
	} else if (!petname.equals(other.petname))
		return false;
	if (phn == null) {
		if (other.phn != null)
			return false;
	} else if (!phn.equals(other.phn))
		return false;
	if (tag == null) {
		if (other.tag != null)
			return false;
	} else if (!tag.equals(other.tag))
		return false;
	return true;
}
public ContactBean(String contactName, Date dob, AddressBean addr, Set<String> petname, Set<String> tag, Set<String> email, Set<String> phn,
		Date crtdate) {
	super();
	this.contactName = contactName;
	this.dob = dob;
	this.addr = addr;
	this.petname = petname;
	this.tag = tag;
	this.email = email;
	this.phn = phn;
	this.crtdate = crtdate;
}
public ContactBean() {
	super();
}
public ContactBean(String contactName, String dob, String addr, String petname, String tag, String email, String phn,
		String crtdate) throws ParseException {
	super();
	this.contactName = contactName;
	this.dob = sdf.parse( dob);
	this.addr = new AddressBean( addr);
	this.petname = toSet(petname);
	this.tag = toSet(tag);
	this.email = toSet(email);
	this.phn = toSet(phn);
	this.crtdate =sdf.parse(crtdate);
}


private Set<String> toSet(String petname) 
{
	Set<String>Set=new HashSet<String>();
	
	petname=petname.replaceAll("\\[|\\]", "");
	for(String str:petname.split(", "))
		Set.add(str);
	
	return Set;
}



@Override
public int compareTo(ContactBean o) {
			
	return this.contactName.compareTo(o.contactName);	
	}
}
