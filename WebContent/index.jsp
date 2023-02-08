<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,model.UserName"%>
<%
UserName n = (UserName) request.getAttribute("selectName");
String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NumberGuessing</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, user-scalable=yes">
<link rel="stylesheet" href="css/gameNum.css">
</head>
<body>
	<div class="line-bc">
		<div style="text-align: center;">
			<h2>++Number Guessing++</h2>
			<h3>数あてゲーム、当ててみて！</h3>
			<br> <br> <img src="Robot.png" width="150px" height="200px"><br>
			<h3>君の名は？</h3>
			<form action="/LoginServlet" method="post">
				<input type="text" name="inputName" placeholder=""> <input
					type="submit"value="ログイン">
			</form>
		<br><br><a href="/CreateAccountServlet">はじめてあそぶ人はこちら</a>
		</div>
	</div>
</body>
</html>
