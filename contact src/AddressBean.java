package com.uttara.contacts;

public class AddressBean {
	private String homeno;
	private String street;
	private String city;
	private String pin;
	public AddressBean() {
		super();
	}
	public AddressBean(String address) {
		super();
		address=address.replaceAll("\\[|\\]", "");
		
		String [] arr= address.split(",");
	    this.homeno= arr[0];
		this.street=arr[1];
		this.city=arr[2];
		this.pin=arr[3];
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((homeno == null) ? 0 : homeno.hashCode());
		result = prime * result + ((pin == null) ? 0 : pin.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		AddressBean other = (AddressBean) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (homeno == null) {
			if (other.homeno != null)
				return false;
		} else if (!homeno.equals(other.homeno))
			return false;
		if (pin == null) {
			if (other.pin != null)
				return false;
		} else if (!pin.equals(other.pin))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "["+ homeno + "," + street + "," + city + "," + pin+"]";
	}
	public String getHomeno() {
		return homeno;
	}
	public void setHomeno(String homeno) {
		this.homeno = homeno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}

}
