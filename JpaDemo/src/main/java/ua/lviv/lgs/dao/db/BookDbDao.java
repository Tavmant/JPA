package ua.lviv.lgs.dao.db;

import javax.persistence.EntityManager;

import ua.lviv.lgs.Book;
import ua.lviv.lgs.dao.BookDao;

public class BookDbDao extends BaseDbDao<Book> implements BookDao {

	public BookDbDao(EntityManager em) {
		super(em);
	}

	public Book findByTitle(String title) {
		return em.find(getEntityClass(), title);
	}

}
