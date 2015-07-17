package ua.lviv.lgs.dao.db;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ua.lviv.lgs.dao.BaseDao;

public class BaseDbDao<T> implements BaseDao<T> {

	protected EntityManager em;

	public BaseDbDao(EntityManager em) {
		this.em = em;
	}

	public void create(T a) {
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}

	public T findById(Object id) {
		return em.find(getEntityClass(), id);
	}
	
	public List<T> findAll() {
		Query query = em.createQuery("SELECT * FROM " + getEntityClass().getName());
	    return (List<T>) query.getResultList();
	}
	
	public void delete(T t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}
	
	public void update(T t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	protected final Class<T> getEntityClass() {
		final Type type = getClass().getGenericSuperclass() instanceof ParameterizedType ? getClass().getGenericSuperclass()
				: getClass().getSuperclass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			final ParameterizedType paramType = (ParameterizedType) type;
			return (Class<T>) paramType.getActualTypeArguments()[0];
		} else
			throw new IllegalArgumentException("Could not guess entity class by reflection");
	}
}
