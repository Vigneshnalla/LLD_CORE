package main.java.com.vignesh.librarymanagement.model.people;

import java.util.Date;

import main.java.com.vignesh.librarymanagement.LibraryManagementSystem;
import main.java.com.vignesh.librarymanagement.model.book.BookItem;

public class Librarian extends Account {

    private Date joiningDate;
    private final LibraryManagementSystem librarySystem;

    // ---------- Constructor ----------
    public Librarian(LibraryManagementSystem librarySystem) {
        this.librarySystem = librarySystem;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    // ---------- Core Librarian Responsibilities ----------

    /** Add a new book item to the library */
    public boolean addBookItem(BookItem bookItem) {
        return librarySystem.addBookItem(bookItem, this);
    }

    /** Remove an existing book item from the library */
    public boolean removeBookItem(BookItem bookItem) {
        return librarySystem.removeBookItem(bookItem, this);
    }

    /** Add a new library member (registration) */
    public boolean addMember(Member member) {
        return librarySystem.addMember(member, this);
    }

    /** Remove a library member */
    public boolean removeMember(String memberId) {
        return librarySystem.removeMember(memberId, this);
    }

    /** Block a library member account */
    public boolean blockMember(String memberId) {
    	return librarySystem.blockMember(memberId,this);
    }

    /** Unblock a library member account */
    public boolean unblockMember(String memberId) {
    	return librarySystem.unblockMember(memberId, this);
    }

    // ---------- Helper ----------
    public LibraryManagementSystem getLibrarySystem() {
        return librarySystem;
    }

    @Override
    public String toString() {
        return super.toString() + 
               "\nLibrarian [joiningDate=" + joiningDate + "]";
    }
}
