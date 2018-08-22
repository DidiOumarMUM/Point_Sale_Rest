package edu.mum.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.eror.ErrorDetails;
import edu.mum.model.User;
import edu.mum.service.UserService;

@RestController
@RequestMapping({"/users"})
public class UserController {
	
	@Autowired
	private UserService  userService;
   
	
	@RequestMapping
	public List<User>  listUsers(Model model) {
		return userService.findAll();
	}
	
  	@RequestMapping("/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		return userService.findOne(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> processAddNewUserForm(@Valid  @RequestBody User userToBeAdded , BindingResult result) {
		
		   if(result.hasErrors())
		   {  
			    List<ObjectError> errors = result.getAllErrors();
			    return ResponseEntity.badRequest().body(errors) ;
			 
		   }
		   System.out.println(userToBeAdded.getUserCredentials().getUserName());
			userService.save(userToBeAdded);

	   	return ResponseEntity.ok(userToBeAdded);
 
	}
	
	@RequestMapping(value="/update/{id}" , method = RequestMethod.PUT)
	public User updateUser(@PathVariable("id") Integer id , @RequestBody User user) {
		
		User u = userService.findOne(id);
		u.setFirstName(user.getFirstName());
		userService.update(user)	 ;
		return u ;
				}
}
