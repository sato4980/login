<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン成功</title>
</head>
<body>
今日の運勢は
<form action="LoginLucky">
<input type="submit" value="運試し">
</form>
	ようこそ
	<br>
	 <!-- #sessionは決まり文句 『sessionの中の～』という意味。 -->

	<s:property value="#session.username" />さん
	<br>この人のパスワードは
<s:property value="#session.password" />	です！


<!-- #session.usernameなら、sernameの中身のtaroとかを#sessionに持っていく -->
</body>
</html>

