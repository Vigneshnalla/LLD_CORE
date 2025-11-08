package main.java.com.vignesh.librarymanagement.model.book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Book {
	private String title;
	private String ISBN;
	private Date publishedDate;
	private String subject;
	private List<Author> authors = new ArrayList<>();

	private String description;
	private String language;
	private int numberOfPages;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
    public Book(String title, String ISBN, Date publishedDate, String subject,
            List<Author> authors, String description, String language, int numberOfPages) {
    this.title = title;
    this.ISBN = ISBN;
    this.publishedDate = publishedDate;
    this.subject = subject;
    this.authors = authors;
    this.description = description;
    this.language = language;
    this.numberOfPages = numberOfPages;
}
    @Override
	public String toString() {
		return "Book [title=" + title + ", ISBN=" + ISBN + ", publishedDate=" + publishedDate + ", subject=" + subject
				+ ", authors=" + authors + ", description=" + description + ", language=" + language
				+ ", numberOfPages=" + numberOfPages + "]";
	}
	public Book() {
    	
    }
	
}
