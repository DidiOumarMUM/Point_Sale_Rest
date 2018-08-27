package edu.mum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.model.User;
import edu.mum.model.UserCredentials;

@Repository
//didi test
public interface UserDao  extends JpaRepository<User, Integer> {
      
	public User findByEmail(String email);
}
