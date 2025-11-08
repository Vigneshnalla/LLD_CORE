// package main.java.com.vignesh.librarymanagement;
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import main.java.com.vignesh.librarymanagement.BookItem;
// import main.java.com.vignesh.librarymanagement.BookLending;
// import main.java.com.vignesh.librarymanagement.LibraryCard;
// import main.java.com.vignesh.librarymanagement.LibraryManagementSystem;
// import main.java.com.vignesh.librarymanagement.Librarian;
// import main.java.com.vignesh.librarymanagement.Member;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// public class LibraryManagementSystemTest {

//     private LibraryManagementSystem librarySystem;
//     private Librarian librarian;
//     private Member member;
//     private BookItem bookItem1;
//     private BookItem bookItem2;
//     private BookLending bookLending;

//     @BeforeEach
//     public void setup() {
//         librarySystem = LibraryManagementSystem.getInstance();
//         librarian = new Librarian(librarySystem);
//         member = new Member(librarySystem);
//         bookItem1 = new BookItem("B001", "Book 1", new Author("A001", "Author 1", "Description 1", new Date(), "Country 1"), BookFormat.HARD_COVER, new Date());
//         bookItem2 = new BookItem("B002", "Book 2", new Author("A002", "Author 2", "Description 2", new Date(), "Country 2"), BookFormat.PAPER_BACK, new Date());
//         bookLending = new BookLending(bookItem1, member, LocalDate.now(), null);
//     }

//     @Test
//     public void testAddBookItem() {
//         Assertions.assertTrue(librarySystem.addBookItem(bookItem1, librarian));
//         Assertions.assertTrue(librarySystem.addBookItem(bookItem2, librarian));
//         List<BookItem> bookItems = librarySystem.getBookItems();
//         Assertions.assertEquals(2, bookItems.size());
//         Assertions.assertTrue(bookItems.contains(bookItem1));
//         Assertions.assertTrue(bookItems.contains(bookItem2));
//     }

//     @Test
//     public void testRemoveBookItem() {
//         librarySystem.addBookItem(bookItem1, librarian);
//         librarySystem.addBookItem(bookItem2, librarian);
//         List<BookItem> bookItems = librarySystem.getBookItems();
//         Assertions.assertEquals(2, bookItems.size());
//         Assertions.assertTrue(librarySystem.removeBookItem(bookItem1, librarian));
//         Assertions.assertFalse(librarySystem.removeBookItem(null, librarian));
//         bookItems = librarySystem.getBookItems();
//         Assertions.assertEquals(1, bookItems.size());
//         Assertions.assertFalse(bookItems.contains(bookItem1));
//         Assertions.assertTrue(bookItems.contains(bookItem2));
//     }

//     @Test
//     public void testSearchBookByISBN() {
//         librarySystem.addBookItem(bookItem1, librarian);
//         librarySystem.addBookItem(bookItem2, librarian);
//         BookItem foundBook = librarySystem.searchBookByISBN(bookItem1.getISBN());
//         Assertions.assertNotNull(foundBook);
//         Assertions.assertEquals(bookItem1.getTitle(), foundBook.getTitle());
//         BookItem notFoundBook = librarySystem.searchBookByISBN("not found");
//         Assertions.assertNull(notFoundBook);
//     }

//     @Test
//     public void testSearchBookByTitle() {
//         librarySystem.addBookItem(bookItem1, librarian);
//         librarySystem.addBookItem(bookItem2, librarian);
//         BookItem foundBook = librarySystem.searchBookByTitle(bookItem1.getTitle());
//         Assertions.assertNotNull(foundBook);
//         Assertions.assertEquals(bookItem1.getISBN(), foundBook.getISBN());
//         BookItem notFoundBook = librarySystem.searchBookByTitle("not found");
//         Assertions.assertNull(notFoundBook);
//     }

//     @Test
//     @Test
//     public void testGetBookItems() {
//         librarySystem.addBookItem(bookItem1, librarian);
//         librarySystem.addBookItem(bookItem2, librarian);
//         List<BookItem> bookItems = librarySystem.getBookItems();
//         Assertions.assertEquals(2, bookItems.size());
//         Assertions.assertTrue(bookItems.contains(bookItem1));
//         Assertions.assertTrue(bookItems.contains(bookItem2));
//     }

//     @Test
//     public void testGetMember() {
//         Assertions.assertNull(librarySystem.getMember("not found"));
//         Member foundMember = librarySystem.getMember(member.getLibraryCard().getCardNumber());
//         Assertions.assertNotNull(foundMember);
//         Assertions.assertEquals(member.getLibraryCard().getCardNumber(), foundMember.getLibraryCard().getCardNumber());
//     }

//     @Test
//     public void testAddMember() {
//         Member newMember = new Member(librarySystem);
//         Assertions.assertTrue(librarySystem.addMember(newMember));
//         List<Member> members = librarySystem.getMembers();
//         Assertions.assertEquals(1, members.size());
//         Assertions.assertTrue(members.contains(newMember));
//     }

//     @Test
//     public void testRemoveMember() {
//         Member newMember = new Member(librarySystem);
//         librarySystem.addMember(newMember);
//         List<Member> members = librarySystem.getMembers();
//         Assertions.assertEquals(1, members.size());
//         Assertions.assertTrue(librarySystem.removeMember(newMember.getLibraryCard().getCardNumber()));
//         members = librarySystem.getMembers();
//         Assertions.assertEquals(0, members.size());
//     }

//     @Test
//     public void testAddBookLending() {
//         BookLending newBookLending = new BookLending(bookItem1, member, LocalDate.now(), null);
//         Assertions.assertTrue(librarySystem.addBookLending(newBookLending));
//         List<BookLending> bookLendings = librarySystem.getBookLendings();
//         Assertions.assertEquals(1, bookLendings.size());
//         Assertions.assertTrue(bookLendings.contains(newBookLending));
//     }

//     @Test
//     public void testRemoveBookLending() {
//         BookLending newBookLending = new BookLending(bookItem1, member, LocalDate.now(), null);
//         librarySystem.addBookLending(newBookLending);
//         List<BookLending> bookLendings = librarySystem.getBookLendings();
//         Assertions.assertEquals(1, bookLendings.size());
//         Assertions.assertTrue(librarySystem.removeBookLending(newBookLending));
//         bookLendings = librarySystem.getBookLendings();
//         Assertions.assertEquals(0, bookLendings.size());
//     }

//     @Test
//     public void testGetBookLendings() {
//         BookLending newBookLending = new BookLending(bookItem1, member, LocalDate.now(), null);
//         librarySystem.addBookLending(newBookLending);
//         List<BookLending> bookLendings = librarySystem.getBookLendings();
//         Assertions.assertEquals(1, bookLendings.size());
//         Assertions.assertTrue(bookLendings.contains(newBookLending));
//     }

//     @Test
//     public void testGetBookLending() {
//         BookLending newBookLending = new BookLending(bookItem1, member, LocalDate.now(), null);
//         librarySystem.addBookLending(newBookLending);
//         BookLending foundBookLending = librarySystem.getBookLending(newBookLending.getBookItem().getISBN(), member.getLibraryCard().getCardNumber());
//         Assertions.assertNotNull(foundBookLending);
//         Assertions.assertEquals(newBookLending.getBookItem().getISBN(), foundBookLending.getBookItem().getISBN());
//         BookLending notFoundBookLending = librarySystem.getBookLending("not found", member.getLibraryCard().getCardNumber());
//         Assertions.assertNull(notFoundBookLending);
//     }

//     @Test
//     public void testExtendBookLending() {
//         BookLending newBookLending = new BookLending(bookItem1, member, LocalDate.now(), null);
//         librarySystem.addBookLending(newBookLending);
//                LocalDate extendedDate = LocalDate.now().plusDays(7);
//         Assertions.assertTrue(librarySystem.extendBookLending(newBookLending, extendedDate));
//         BookLending foundBookLending = librarySystem.getBookLending(newBookLending.getBookItem().getISBN(), member.getLibraryCard().getCardNumber());
//         Assertions.assertNotNull(foundBookLending);
//         Assertions.assertEquals(extendedDate, foundBookLending.getReturnDate());
//         Assertions.assertFalse(librarySystem.extendBookLending(newBookLending, LocalDate.now().minusDays(1));
//         BookLending notFoundBookLending = librarySystem.getBookLending("not found", member.getLibraryCard().getCardNumber());
//         Assertions.assertNull(notFoundBookLending);
//     }
// }