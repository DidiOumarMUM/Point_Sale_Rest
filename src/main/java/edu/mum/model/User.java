package edu.mum.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name = "USERS")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id" , scope= User.class)
 public class User implements Serializable  {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Integer id = null;

    @Version
    private int version = 0;
     @Column(name = "FIRSTNAME", nullable = false)
     @NotNull
     @Size(min=4, max = 19, message= "{Size.name}")
    private String firstName;

     @NotNull
     @Size(min=4, max = 19, message= "{Size.name}")
    @Column(name = "LASTNAME", nullable = false)
    private String lastName;
     
     @Email(message = "{email}")
     @NotEmpty
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "RANK", nullable = true)
    private int ranking = 0;

    @Column(name = "IS_ADMIN", nullable = true)
    private boolean admin = false;

     @Transient
     private String token ;
    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Valid
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL) 
	@JoinColumn(name="username") 
	private UserCredentials userCredentials;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}


}