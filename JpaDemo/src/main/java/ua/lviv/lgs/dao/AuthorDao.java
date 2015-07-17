package ua.lviv.lgs.dao;

import ua.lviv.lgs.Author;

public interface AuthorDao extends BaseDao<Author> {
	Author findByAge(int age);
}
