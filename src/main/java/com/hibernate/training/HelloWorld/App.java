package com.hibernate.training.HelloWorld;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hibernate.training.HelloWorld.crudservice.CRUDService;
import com.hibernate.training.HelloWorld.model.Author;
import com.hibernate.training.HelloWorld.model.AuthorProfile;
import com.hibernate.training.HelloWorld.model.Book;
import com.hibernate.training.HelloWorld.model.BookCover;
import com.hibernate.training.HelloWorld.model.PrintingCompany;
import com.hibernate.training.HelloWorld.model.PrintingCompanyBranch;
import com.hibernate.training.HelloWorld.util.HibernateUtil;

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

//		List<Book> bookList = CRUDService.ListBooks();
//		logger.info("====Listing the books=======");
//		for (Book book : bookList) {
//			logger.info("book id :" + book.getBookId());
//			logger.info("book name :" + book.getBookName());
//			logger.info("book ISBN	 :" + book.getISBN());
//		}
//		logger.info("===========");

		
		//one to one uni-directional association 
	
//		Author author = new Author();
//		author.setFirstName("Salman");
//		author.setLastName("Rushdi");
//		AuthorProfile authorProfile = new AuthorProfile();
//		authorProfile.setHomeAddress("rushdy-home-addr-india");
//		authorProfile.setOfficeAddress("rushdy-office-addr-india");
//		authorProfile.setPhoneNumber("+91234569891");
//		authorProfile.setUniversity("rushdi-uni");
//		author.setAuthorProfile(authorProfile);
//		
//		logger.info(" author id :"+CRUDService.createAuthor(author));
//		
//		
		
		//one to one bidirectional association
		
		//getting book by book cover
		/*
		Book book = new Book();
		book.setBookName("book-3");
		book.setISBN("666");
		
		BookCover bookCover= new BookCover();
		bookCover.setCoverimage("book-3-c3");
		bookCover.setDesignerName("book-3-d3");
		bookCover.setBook(book);
		
		book.setBookCover(bookCover);
		
		//we can start saving from either one of two ends.
		//logger.info(" book  id  :"+CRUDService.createBook(book));
		//logger.info(" book covr id  :"+CRUDService.createBookCover(bookCover));
		
		logger.info("Book name =====>"+CRUDService.getBookByBookCover(4L).getBookName());		
		
	*/		
		//Many to one uni directional mapping
		//branch ---> company
		
		/*
		PrintingCompany company_1 = new PrintingCompany();
		company_1.setCompanyName("sarasavi");
		
		PrintingCompany company_2 = new PrintingCompany();
		company_2.setCompanyName("gunasena");
		
		
		PrintingCompanyBranch colombo_branch_company_1 = new PrintingCompanyBranch();
		colombo_branch_company_1.setBranchName("colombo branch");
		colombo_branch_company_1.setPrintingCompany(company_1);
		
		PrintingCompanyBranch kandy_branch_company_1 = new PrintingCompanyBranch();
		kandy_branch_company_1.setBranchName("kandy branch");
		kandy_branch_company_1.setPrintingCompany(company_1);
		
		
		PrintingCompanyBranch colombo_branch_company_2 = new PrintingCompanyBranch();
		colombo_branch_company_2.setBranchName("colombo");
		colombo_branch_company_2.setPrintingCompany(company_2);
		
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(colombo_branch_company_1);
			session.save(kandy_branch_company_1);
			session.save(colombo_branch_company_2);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			logger.error(e.getLocalizedMessage());

		} finally {
			session.close();
		}


		*/
		
		
		
		
		
		
		HibernateUtil.shutdown();

	}
}
