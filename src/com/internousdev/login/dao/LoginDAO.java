package com.internousdev.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.login.dto.LoginDTO;
import com.internousdev.login.util.DBConnector;

//JavaとDBを接続するプログラム
public class LoginDAO {

	public LoginDTO select(String username, String password) {
		LoginDTO dto = new LoginDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		// dbconnectorという部品を使ってデーターベースと接続している。
		// dbの接続状態を保持
		// 上の2行は、データーベースとDBConnectorが繋がった状態になっているのを、DAOに持っていく文

		String sql = "select * from users where username = ? and password = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			// PreparedStatementは、カッコの中身をDBへ運ぶ仕事をする文、ここではsqlを運んでいる。conはconnectionのこと。
			// このsql文の中の「=?」は、下のsetStringの1,usernameと、
			// 2,passwordにそれぞれ当てはまっていて、入力された内容が勝手に入っていく。
			// executeQueryは、「検索してね」の意味。
			// ResultSetは、検索した結果を表にして覚えてくれる文。

			if (rs.next()) { // re.nextは「次の行」のこと、今はifを使って「ResultSetに次の行があれば、」という意味。
				dto.setUsername(rs.getString("username")); // データベースのresultsetからusernameをとってきてね。
				dto.setPassword(rs.getString("password")); // データベースのresultsetからpasswordを..
			}
		} catch (SQLException e) { // 『try{}catch(){}』でなんか問題や例外が起きたときにエラーを報告してくれる。
			e.printStackTrace(); // ←例外の情報を出力してくれる。
		}
		try {
			con.close();
		} catch (SQLException e) { // 『try{}catch(){}』でなんか問題や例外が起きたときにエラーを報告してくれる。
			e.printStackTrace(); // ←例外の情報を出力してくれる。
		}
		return dto; // dtoをactionに伝える、dtoがstringとかintみたいな返し値。

	}
}