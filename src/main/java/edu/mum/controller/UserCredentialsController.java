package edu.mum.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.eror.ErrorDetails;
import edu.mum.model.User;
import edu.mum.model.UserCredentials;
import edu.mum.security.JwtGenerator;
import edu.mum.service.UserCredentialsService;

@RestController
@RequestMapping({"/userCredentials"})
 public class UserCredentialsController {

	@Autowired
	UserCredentialsService credentialsService;
	private JwtGenerator jwtGenerator;
	
	@RequestMapping
	public List<UserCredentials>  listCredentials(Model model) {
		return credentialsService.findAll();
	}

 	
 	@RequestMapping("/add")
	public void addOne(@RequestBody UserCredentials userCredentials ) {

		credentialsService.save(userCredentials);
 
 		return  ;
	}
 
 	@RequestMapping("/{id}")
	public UserCredentials findOne(@PathVariable("id") String userName ) {

		UserCredentials validCredentials = credentialsService.findByUserName(userName);
 
 		return  validCredentials;
	}
 	
 	@RequestMapping(value="/postLogin", method = RequestMethod.POST)
	public ResponseEntity<?> PostLogin(@RequestBody @Valid UserCredentials credentials) {
		 

		UserCredentials validCredentials = credentialsService.findByUserName(credentials.getUserName());
		
		if (validCredentials == null || !validCredentials.getPassword().equals(credentials.getPassword()))
		{
		 
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
					              .body(new ErrorDetails(new Date(), "invalide credentials" ,"error"))  ;//"invalide user "+credentials.getUserName();
		}
		
		    User user = validCredentials.getUser() ;
		    jwtGenerator = new JwtGenerator()  ;
		    user.setToken(jwtGenerator.generate(user) );
		 return ResponseEntity.ok(user) ;
		
	}
 
 
}
