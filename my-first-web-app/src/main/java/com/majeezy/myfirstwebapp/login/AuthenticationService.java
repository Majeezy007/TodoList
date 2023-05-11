package com.majeezy.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean isAuthentic(String name, String password) {
		boolean isValidName = "Majeezy".equalsIgnoreCase(name);
		boolean isValidPassword = password.equals("password");
		return isValidName && isValidPassword;
	}
}
