package main.java.com.vignesh.librarymanagement.model.book;

public class Rack {
	private String number ;
	private String locationIdentifier;
	public Rack(String locationIdentifier,String number) {
		super();
		this.number = number;
		this.locationIdentifier = locationIdentifier;
	}
	@Override
	public String toString() {
		return "Rack [number=" + number + ", locationIdentifier=" + locationIdentifier + "]";
	}
	
}
