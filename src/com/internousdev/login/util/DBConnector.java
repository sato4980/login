package com.internousdev.login.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//この部品が mysql-u root -p のmysql文に当たる
public class DBConnector {
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/login", "root", "mysql");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

}