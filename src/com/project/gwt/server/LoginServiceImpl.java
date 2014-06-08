package com.project.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.project.gwt.client.LoginService;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
	String UserLogin = "admin";
	String UserPassword = "098";
	
	public Boolean checkLogin(String login, String password) {
		return ( UserLogin.equals(login) && UserPassword.equals(password) );
	}
}
