<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NumberGuessing</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, user-scalable=yes">
<link rel="stylesheet" href="css/gameNum.css">
<%
String errMsg =(String)request.getAttribute("errMsg");
%>
</head>
<body>
	<div class="line-bc">
		<div style="text-align: center;">
			<h1></h1>
			<br>
			<br> <img src="Robot.png" width="150px" height="200px"><br>
			<h2>初めての人はなまえを登録してね</h2>
			<form action="/CreateAccountServlet" method="post">
				
				<%if(errMsg!=null){ %>
				<span style="color:red;"><%=errMsg %></span>
				<%} %>
				<input type="text" name="createName"> <input type="submit" value="登録">
				<br><br><a href="/LoginServlet">ログインへ戻る</a>
			</form>
		</div>
	</div>
</body>
</html>