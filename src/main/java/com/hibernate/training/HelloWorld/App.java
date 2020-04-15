package com.hibernate.training.HelloWorld;

import com.hibernate.training.HelloWorld.crudservice.CRUDService;
import com.hibernate.training.HelloWorld.model.Book;
import com.hibernate.training.HelloWorld.util.HibernateUtil;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {

	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		// create
//		Book book = new Book();
//		book.setBookName("Sapiens");
//		book.setISBN("7343-AAB");
//		logger.info("newly created book id :" + CRUDService.createBook(book));

		// update
//		Book bookWithUpdatedFields = new Book();
//		bookWithUpdatedFields.setBookName("God of small things v2");
//		bookWithUpdatedFields.setISBN("6677");
//		CRUDService.UpdateBook(2L,bookWithUpdatedFields); 
//		logger.info("===updated book detils====");
//		Book updatedBook = CRUDService.getBookByID(2L);
//		logger.info("book id :"+updatedBook.getBookId());
//		logger.info("book name :"+updatedBook.getBookName());  
//		logger.info("book ISBN	 :"+updatedBook.getISBN());
//		logger.info("==========================");

		// remove
		// CRUDService.removeBook(4L);

		// List

		List<Book> bookList = CRUDService.ListBooks();
		logger.info("====Listing the books=======");
		for (Book book : bookList) {
			logger.info("book id :" + book.getBookId());
			logger.info("book name :" + book.getBookName());
			logger.info("book ISBN	 :" + book.getISBN());
		}
		logger.info("===========");

		HibernateUtil.shutdown();

	}
}
