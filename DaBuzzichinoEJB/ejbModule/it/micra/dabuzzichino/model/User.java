package it.micra.dabuzzichino.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@SuppressWarnings("serial")
@Entity
public class User implements Serializable {
	@Column (name= "userId", nullable = false)		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 	private Integer userId;
	@Column (name= "username", nullable = false)
    private String username;
	@Column (name= "password", nullable = false)
    private String password;
	
	public User() {
	}
    	    	    
    public User( String username, String password){          
        this.username = username;
        this.password = password;
    }
	
    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void sePassword(String password) {
		this.password = password;
	}
}
