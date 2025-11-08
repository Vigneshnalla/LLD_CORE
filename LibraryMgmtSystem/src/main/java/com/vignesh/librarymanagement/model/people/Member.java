package main.java.com.vignesh.librarymanagement.model.people;

import java.util.Date;
import java.util.List;

import main.java.com.vignesh.librarymanagement.LibraryManagementSystem;
import main.java.com.vignesh.librarymanagement.model.book.BookItem;

public class Member extends Account {
    private Date dateOfMembership;
    private int totalBooksCheckedOut;
    private final LibraryManagementSystem librarySystem;

    public Member(LibraryManagementSystem librarySystem) {
        this.librarySystem = librarySystem;
        this.totalBooksCheckedOut = 0;
        this.dateOfMembership = new Date(); // set to current date
    }

    public Date getDateOfMembership() {
        return dateOfMembership;
    }

    @Override
	public String toString() {
		return "Member [dateOfMembership=" + dateOfMembership + ", totalBooksCheckedOut=" + totalBooksCheckedOut
				 + super.toString() + "] \n";
	}

	public void setDateOfMembership(Date dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public int getTotalBooksCheckedOut() {
        return totalBooksCheckedOut;
    }

    public void setTotalBooksCheckedOut(int totalBooksCheckedOut) {
        this.totalBooksCheckedOut = totalBooksCheckedOut;
    }

    public BookItem searchBookByTitle(String title) {
        return librarySystem.searchBookByTitle(title);
    }

    public BookItem searchBookBySubject(String subject) {
        return librarySystem.searchBookBySubject(subject);
    }

    public BookItem searchBookByPublishedDate(Date date) {
        return librarySystem.searchBookByPublishedDate(date);
    }

    public BookItem searchBookByAuthor(String author) {
        return librarySystem.searchBookByAuthor(author);
    }
    
    public boolean checkOut(BookItem bookItem) {
    	return librarySystem.issueBook(bookItem, this);
    }
    public boolean returnBook(BookItem bookItem) {
    	return librarySystem.collectBookitem(bookItem,this);
    }
    
    public boolean renewBook(BookItem bookItem) {
    	return librarySystem.renewBookItem(bookItem, getId());
    }
    public double viewFineAmount() {
    	return librarySystem.computeFineAmount(this.getId());
    }
    
    public boolean addReservation(BookItem bookItem) {
    	return librarySystem.addReservation(bookItem,this.getId());
    }
    
    public boolean removeReservation(BookItem bookItem) {
    	return librarySystem.removeReservation(bookItem,this.getId());
    }
    
    public List<BookItem> getMemberBorrowedBooks(){
    	return librarySystem.getMemberIssuedBooks(this.getId());
    }
    
    
}
