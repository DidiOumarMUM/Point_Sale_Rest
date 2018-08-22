package edu.mum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.model.UserCredentials;

@Repository
public interface UserCredentialsDao extends JpaRepository<UserCredentials, String> {
  
	public UserCredentials findByUserName(String userName);
}
