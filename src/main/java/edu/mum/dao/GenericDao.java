package edu.mum.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.model.Employee;

public interface GenericDao<T> {
	/**
     * Method that returns the number of entries from a table that meet some
     * criteria (where clause params)
     * @param params
     *  sql parameters
     * @return the number of records meeting the criteria
     */

   /* void save(T t);

    void delete(Integer id);

    public void saveorupdate( T entity );
    
    T findOne(Integer id);

    T update(T t);   
    
    List<T> findAll();

	public List<T> findAll(String s,Object  hint );*/

    
    
}
