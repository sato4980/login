package com.internousdev.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.login.util.DBConnector;

//JavaとDBを接続するプログラム
public class LoginDAO {
	public String username;
	public String password;

	public boolean select(String username, String password) {
		DBConnector db = new DBConnector(); // dbconnectorという部品を使ってデーターベースと接続している。
		Connection con = db.getConnection(); // dbの接続状態を保持
		// 上の2行は、データーベースとDBConnectorが繋がった状態になっているのを、DAOに持っていく文
		String sql = "select * from users where username = ? and password = ?";
		// このsql文の中の「=?」は、下のsetStringの1,usernameと、2,passwordにそれぞれ当てはまっていて、入力された内容が勝手に入っていく。
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// PreparedStatementは、カッコの中身をDBへ運ぶ仕事をする文、ここではsqlを運んでいる。conはconnectionのこと。
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			// executeQueryは、「検索してね」の意味。
			// ResultSetは、検索した結果を表にして覚えてくれる文。

			if (rs.next()) { // re.nextは「次の行」のこと、今はifを使って「ResultSetに次の行があれば、」という意味。
				this.username = rs.getString("username"); // データベースのresultsetからusernameをとってきてね。
				this.password = rs.getString("password"); // データベースのresultsetからpasswordを..
			}
		} catch (SQLException e) { // 『try{}catch(){}』でなんか問題や例外が起きたときにエラーを報告してくれる。
			e.printStackTrace(); // ←例外の情報を出力してくれる。
		}
		try {
			con.close();
		} catch (SQLException e) { // 『try{}catch(){}』でなんか問題や例外が起きたときにエラーを報告してくれる。
			e.printStackTrace(); // ←例外の情報を出力してくれる。
		}
		return true; // trueをactionに伝える
	}
}