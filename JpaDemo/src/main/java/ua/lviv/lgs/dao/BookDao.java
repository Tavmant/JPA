package ua.lviv.lgs.dao;

import ua.lviv.lgs.Book;

public interface BookDao extends BaseDao<Book> {
	Book findByTitle(String title);
}
