package br.com.dxc.core.dao;

import java.util.List;

public interface IGenericDAO<T> {

	T findOne(final long id);

	List<T> findAll();

	void create(final T entity);

	void update(final T entity);

	void delete(final T entity);

	void deleteById(final long entityId);
}