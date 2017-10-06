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

		session.put("username", dto.getUsername());
		System.out.println(dto.getUsername());

		session.put("password", dto.getPassword());
		System.out.println(dto.getPassword());

		// if (username.equals(dto.getUsername())) {
		// if (password.equals(dto.getPassword())) {

		// session.put("username1", "taro"); //
		// session.get(小箱の名前)は値を取り出すことができるよ。
		// //System.out.print((String) session.get("username")); //
		// sessin.put(小箱の名前)は値を登録することができるよ。
		//
		// //session.put("password1", "123"); // sessin.put(小箱の名前,小箱の値);
		// //System.out.println((String) session.get("password"));
		//
		// session.put("username2","jiro");
		// //System.out.print((String) session.get("username"));
		//
		// //session.put("password2","456");
		// //System.out.print((String) session.get("password"));
		//
		// //session.put("username3", "hanako");
		// //System.out.print((String) session.get("username"));
		//
		// //session.put("password3", "789");
		// //System.out.println((String) session.get("password"));
		//
		// session.put("username4",dto.getUsername());
		// //System.out.println((String) session.get("username"));
		//

		ret = SUCCESS;
		// }

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
