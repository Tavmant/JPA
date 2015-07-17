package ua.lviv.lgs.dao;

import java.util.List;

public interface BaseDao<T> {
	void create(T t);

	T findById(Object id);

	List<T> findAll();
	
	void delete(T t);
	
	void update(T t);
}
