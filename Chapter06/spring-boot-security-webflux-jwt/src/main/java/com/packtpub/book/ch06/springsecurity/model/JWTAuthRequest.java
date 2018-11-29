package com.packtpub.book.ch06.springsecurity.model;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JWTAuthRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public JWTAuthRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public JWTAuthRequest( ) {
		super(); 
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

	public void setPassword(String password) {
		this.password = password;
	}

}
