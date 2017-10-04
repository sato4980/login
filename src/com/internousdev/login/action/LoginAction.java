package com.internousdev.login.action;

import com.internousdev.login.dao.LoginDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;

	public String execute() {

		String ret = ERROR;
		LoginDAO dao = new LoginDAO();
		boolean b = dao.select(username, password); // booleanは真(true)と偽(false)の2つを取る変数
		if (b == true) {
			if (username.equals(dao.username)) {
				if (password.equals(dao.password)) {
					ret = SUCCESS;
				}
			}
		}

		return ret;
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