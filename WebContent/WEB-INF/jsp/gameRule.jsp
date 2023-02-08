<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,model.Game,model.GameRank"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Number Guessing</title>


<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, user-scalable=yes">
<link rel="stylesheet" href="css/gameNum.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<%
List<Game> gameList = (List<Game>) request.getAttribute("gameList");

GameRank gr= (GameRank) request.getAttribute("gr");
%>
<script>
setTimeout(function(){
	window.location.href = '/LogOutServlet';
},300*1000);
</script>
</head>
<body>
	<div class="line-bc">

		<div class="mx-auto text-center" style="width: 90%;">
			<h2 class="text-center mb-3">++ Number Guessing ++</h2>
			
					<table align="center">
				<tr>
					<td>
						<h4>ルールの説明</h4>
					<td>
					<td><img src="Robot.png" width="45px;" height="60px;"></td>
				</tr>
			</table>
						<p>
							ようこそ、<%=gr.getName()%>くん。<br>ロボットが考えた、2けたまたは３けたの数を当ててね。<br>
							きみが入力した数とロボットが考えた数が<br>同じ数、同じ場所ならHIT。<br>
							同じ数、違う場所ならBLOW。<br>
							HITとBLOWをヒントに数を推理してみよう。<br>
						</p>
				
					<p>下のように、もし君が123と入力したら、、
			</p>
			<div class="list-group">
				<div class="list-group-item">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">A</th>
								<th scope="col">B</th>
								<th scope="col">C</th>
								<th scope="col">HIT<br>数も場所も正解!
								</th>
								<th scope="col">BLOW<br>その数で正解！でも場所が違うよ
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>2<!-- getThird() input--></td>
								<td>3<!-- getHit() keisansiki--></td>
								<td>1<!-- getBlow() keisansiki--></td>
								<td>2</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<p>
				ロボットの答えが３２１ならば<br>HITはB、BLOWはAとCになるよ。
			</p>
		</div>
		<form action="?" method="post">
			<div class="row">
				<div class="col">
					<button type="submit"
						formaction="/GameStartServlet?ran2num6">2けた１〜6で遊ぶ</button>
				</div>
				<div class="col">
					<button type="submit"
						formaction="/GameStartServlet?ran3num3">3けた１〜3で遊ぶ</button>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<button type="submit"
						formaction="/GameStartServlet?ran3num6">3けた１〜6で遊ぶ</button>
				</div>
				<div class="col">
					<button type="submit"
						formaction="/GameStartServlet?ran3num9">3けた１〜9で遊ぶ</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>