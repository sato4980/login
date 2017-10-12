package com.internousdev.login.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String username;
	private String password;
	private Map<String, Object> session; // mapが大箱、<string,object>が小箱、
											// Stringには文字列を、objectにはいろんな部品が入れることができるよ。

	public String execute() {
		String ret = ERROR;
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();
		dto = dao.select(username, password);
		if (username.equals(dto.getUsername())) {
			if (password.equals(dto.getPassword())) {
				session.put("username", dto.getUsername());
				System.out.println(dto.getUsername());
				session.put("password", dto.getPassword());
				System.out.println(dto.getPassword());
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

	public Map<String, Object> getSession() {
		return this.session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
