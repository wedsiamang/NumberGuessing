<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,model.Game,model.GameRank"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CLEARED!!</title>

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
List<GameRank> gameRankList = (List<GameRank>) request.getAttribute("gameRankList");
%>
<script>
	setTimeout(function() {
		window.location.href = '/LogOutServlet';
	}, 300 * 1000);
</script>
</head>
<body>
	<div class="line-bc">
		<div class="mx-auto text-center" style="width: 100%;">
			<h2 class="text-center mb-3">++ Number Guessing ++</h2>
			<table align="center">
				<tbody>
					<tr>
						<td><img src="Robot.png" width="60px;" height="70px;"></td>
						<td>
							<h3>ランキング</h3>
						</td>
						<td><img src="pneko.png" width="60px;" height="70px;"></td>
				</tbody>
			</table>
			<div class="list-group">
				<div class="list-group-item">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">Rank</th>
								<th scope="col">Name</th>
								<th scope="col">Points</th>
								<th scope="col">５>=win</th>
								<th scope="col">Try Count<br>
								</th>
								
								</th>
							</tr>
						</thead>
						<tbody>
								<%
								for (GameRank gr : gameRankList) {
								%>
							<tr>
								<td><%=gr.getRankNum()%></td>
								<td><%=gr.getName()%></td>
								<td><%=gr.getPoint()%><!-- getThird() input--></td>
								<td><%=gr.getWin()%><!-- getBlow() keisansiki--></td>
								<td><%=gr.getGameCount()%></td>
							
							</tr>
								<%
								}
								%>
						</tbody>
					</table>
				</div>
			</div><br>
			<form method="post" action="/GameClearServlet?again">
				<button>もう一度あそぶ</button>
			</form><br>
			<button>
				<a href="/LogOutServlet">終了する</a>
			</button>
		</div>
	</div>
</body>
</html>