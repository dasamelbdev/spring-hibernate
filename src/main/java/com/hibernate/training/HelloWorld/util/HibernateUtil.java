package com.hibernate.training.HelloWorld.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.hibernate.training.HelloWorld.model.Author;
import com.hibernate.training.HelloWorld.model.AuthorProfile;
import com.hibernate.training.HelloWorld.model.Book;
import com.hibernate.training.HelloWorld.model.BookCover;

public class HibernateUtil {
	
	private static StandardServiceRegistry registry;
	   private static SessionFactory sessionFactory;

	   public static SessionFactory getSessionFactory() {
	      if (sessionFactory == null) {
	         try {

	            // Create registry builder
	            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

	            // Hibernate settings equivalent to hibernate.cfg.xml's properties
	            Map<String, String> settings = new HashMap<String, String>();
	            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/books-db");
	            settings.put(Environment.USER, "root");
	            settings.put(Environment.PASS, "root");
	            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
	            //settings.put(Environment.SHOW_SQL, "false");
	            settings.put(Environment.HBM2DDL_AUTO, "update");
	            

	            // Apply settings
	            registryBuilder.applySettings(settings);

	            // Create registry
	            registry = registryBuilder.build();

	            // Create MetadataSources
	            MetadataSources sources = new MetadataSources(registry).addAnnotatedClass(Book.class).
	            		addAnnotatedClass(Author.class).addAnnotatedClass(AuthorProfile.class).addAnnotatedClass(BookCover.class);

	            // Create Metadata
	            Metadata metadata = sources.getMetadataBuilder().build();

	            // Create SessionFactory
	            sessionFactory = metadata.getSessionFactoryBuilder().build();

	         } catch (Exception e) {
	            e.printStackTrace();
	            if (registry != null) {
	               StandardServiceRegistryBuilder.destroy(registry);
	            }
	         }
	      }
	      return sessionFactory;
	   }

	   public static void shutdown() {
	      if (registry != null) {
	         StandardServiceRegistryBuilder.destroy(registry);
	      }
	   }

}
