package edu.mum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.UserDao;
import edu.mum.model.User;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional 
public class UserServiceImpl implements edu.mum.service.UserService {
	
 	@Autowired
	private UserDao userDao;

 	@Autowired
	private UserCredentialsService credentialsService;

 	
     public void save( User user) {  		
  		userDao.save(user);
 	}
  	
     @Override
    	public void saveFull( User user) {  		
   		credentialsService.save(user.getUserCredentials());
   		userDao.save(user);
 	}
   	
	
	public List<User> findAll() {
		return (List<User>)userDao.findAll();
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
	public User update(User user) {
		 return userDao.save(user);

	}

	@Override
	public User findOne(Integer id) {
		 
		return userDao.getOne(id) ;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
 

}
