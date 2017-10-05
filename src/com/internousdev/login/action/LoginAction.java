package com.internousdev.login.action;

import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;

	public String execute() {

		String ret = ERROR;
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();
		dto = dao.select(username, password);

		if (username.equals(dto.getUsername())) {
			if (password.equals(dto.getPassword())) {
				ret = SUCCESS;
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