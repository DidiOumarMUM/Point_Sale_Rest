package edu.mum.service;

import java.util.List;

import edu.mum.model.User;
 
public interface UserService {

	public void save(User user);
	public List<User> findAll();
	public User findOne(Integer id);
	public User findByEmail(String email);
	public User update(User user);
	public void saveFull( User user);		

}
