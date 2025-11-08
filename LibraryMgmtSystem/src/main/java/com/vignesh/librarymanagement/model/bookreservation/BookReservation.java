package main.java.com.vignesh.librarymanagement.model.bookreservation;

import java.util.Date;

import main.java.com.vignesh.librarymanagement.enums.ReservationStatus;

public class BookReservation {
    private String id;
    private String memberId;  // Member who reserved
    private String bookId;
    private ReservationStatus reservationStatus;
    private Date creationDate;
    private Date expiryDate; // optional: reservation expires if not collected
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getBookId() {
        return bookId;
    }
    public BookReservation() {
    	
    }
    public BookReservation(String id, String memberId, String bookId, ReservationStatus reservationStatus) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.bookId = bookId;
		this.reservationStatus = reservationStatus;
		this.creationDate = new Date();
		this.expiryDate = null;
	}
	public BookReservation(String bookId, String memberId) {
		// TODO Auto-generated constructor stub
		this.bookId = bookId;
		this.memberId = memberId;
	}
	public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }
    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
