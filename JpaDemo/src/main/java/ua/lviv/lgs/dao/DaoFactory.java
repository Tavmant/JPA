package ua.lviv.lgs.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.lviv.lgs.dao.db.AuthorDbDao;
import ua.lviv.lgs.dao.db.BookDbDao;

public class DaoFactory {
	private static DaoFactory instance;
	private AuthorDao aDao;
	private BookDao bDao;
	private EntityManager em;
	private EntityManagerFactory factory;

	private DaoFactory() {
		factory = Persistence.createEntityManagerFactory("primary");
		em = factory.createEntityManager();
		aDao = new AuthorDbDao(em);
		bDao = new BookDbDao(em);
	}

	public static DaoFactory getInstance() {
		if (instance == null) {
			instance = new DaoFactory();
		}
		return instance;
	}

	public AuthorDao getAuthorDao() {
		return aDao;
	}

	public BookDao getBookDao() {
		return bDao;
	}

	public void close() {
		em.close();
		factory.close();
	}
}
