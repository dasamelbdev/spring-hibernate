package com.hibernate.training.HelloWorld.crudservice;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hibernate.training.HelloWorld.App;
import com.hibernate.training.HelloWorld.model.Author;
import com.hibernate.training.HelloWorld.model.Book;
import com.hibernate.training.HelloWorld.util.HibernateUtil;

public class CRUDService {

	private static final Logger logger = LoggerFactory.getLogger(CRUDService.class);

	public static Long createBook(Book book) {

		Session session = null;
		Transaction transaction = null;
		Long bookId = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			bookId = (Long) session.save(book);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			logger.error(e.getLocalizedMessage());

		} finally {
			session.close();
		}

		return bookId;

	}

	public static Long createAuthor(Author author) {

		Session session = null;
		Transaction transaction = null;
		Long bookId = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			bookId = (Long) session.save(author);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			logger.error(e.getLocalizedMessage());

		} finally {
			session.close();
		}

		return bookId;

	}

	public static void UpdateBook(Long id, Book updatedBookInstance) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Book originalBook = (Book) session.get(Book.class, id);
			originalBook.setBookName(updatedBookInstance.getBookName());
			originalBook.setISBN(updatedBookInstance.getISBN());
			session.update(originalBook);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			logger.error(e.getLocalizedMessage());

		} finally {
			session.close();
		}

	}

	public static Book getBookByID(Long id) {

		Session session = null;
		Transaction transaction = null;
		Book book = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			book = (Book) session.get(Book.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			logger.error(e.getLocalizedMessage());

		} finally {
			session.close();
		}

		return book;

	}

	public static void removeBook(Long id) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Book originalBook = (Book) session.get(Book.class, id);
			session.delete(originalBook);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			logger.error(e.getLocalizedMessage());

		} finally {
			session.close();
		}

	}

	public static List<Book> ListBooks() {

		Session session = null;
		Transaction transaction = null;
		List<Book> bookList = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			// using criteria api

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
			Root<Book> root = criteriaQuery.from(Book.class);
			criteriaQuery.select(root);
			TypedQuery<Book> typedQuery = session.createQuery(criteriaQuery);
			bookList = typedQuery.getResultList();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			logger.error(e.getLocalizedMessage());

		} finally {
			session.close();
		}

		return bookList;
	}

}
