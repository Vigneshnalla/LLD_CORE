package main.java.com.vignesh.librarymanagement.model.people;

public class Address {
	private String streetNo;
	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address() {
		super();
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Address(String streetNo, String city, String state, String country, String zipCode) {
		super();
		this.streetNo = streetNo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	@Override
	public String toString() {
		return "Address [streetNo=" + streetNo + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", zipCode=" + zipCode + "]";
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	private String city;
	private String state;
	private String country;
	private String zipCode;
	
}
