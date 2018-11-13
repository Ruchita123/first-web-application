package com.ruchitaladha.login;

public class LoginService {
	public boolean isValidUser(String user,String password){
		if(user.equals("ruchita") && password.equals("123")){
			return true;
		}
		return false;
	}

}
