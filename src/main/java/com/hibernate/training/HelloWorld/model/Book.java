package com.hibernate.training.HelloWorld.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="book_tbl")
public class Book {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="book_id")
	private Long bookId;
	
	@Column(name="book_name" , nullable = false, unique = true, length = 50)
	private String bookName;

	@Column(name="book_isbn" , nullable = false, unique = true, length = 50)
	private String ISBN;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "book")
	private BookCover bookCover;
	
	
	public BookCover getBookCover() {
		return bookCover;
	}

	public void setBookCover(BookCover bookCover) {
		this.bookCover = bookCover;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

}
