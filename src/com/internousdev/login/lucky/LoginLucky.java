package com.internousdev.login.lucky;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginLucky extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

		int r;
		String[] fortune = { "大吉", "中吉", "小吉", "凶", "大凶" };
		int i = 0;{
		while (i < 3) {
			r = (int) (Math.random() * 5);
			System.out.println("今日のあなたは" + (i + 1) + "回目:" + fortune[r] + "です。");
			i++;}
}
		public Map<String, Object> getSession() {
			return this.session;
		}
		public void setSession(Map<String, Object> session) {
			this.session = session;
		}
}



